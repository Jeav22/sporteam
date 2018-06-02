package co.edu.usa.ingereq.sporteam.rest;

import co.edu.usa.ingereq.sporteam.conversor.Conversor;
import co.edu.usa.ingereq.sporteam.facade.PartidoFachada;
import co.edu.usa.ingereq.sporteam.jpa.Partido;
import co.edu.usa.ingereq.sporteam.dto.PartidoDto;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/partidos")
public class ServicioPartido {

    PartidoFachada partidoFachada;
    Conversor conversor;

    public ServicioPartido() {
        partidoFachada = new PartidoFachada();
        conversor = new Conversor();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<PartidoDto> getPartidos_JSON() {
        List<PartidoDto> partidoDtos = new ArrayList<>();
        List<Partido> partidos = partidoFachada.findAll();
        for (Partido partido : partidos) {
            partidoDtos.add(conversor.partidoToDto(partido));
        }
        return partidoDtos;
    }

    @GET
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PartidoDto getPartido(@PathParam("usrNo") int usrNo) {
        return conversor.partidoToDto(partidoFachada.get(usrNo));
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response crearPartido(PartidoDto usr) {
        Partido partido = new Partido();
        partido = conversor.dtoToPartido(usr);
        List<Partido> Partidos = partidoFachada.findAll();
        for (Partido Partido : Partidos) {
            if (Partido.getEquipo1().equalsIgnoreCase(partido.getEquipo1())
                    && Partido.getEquipo2().equalsIgnoreCase(partido.getEquipo2())
                    && Partido.getFecha().equals(Partido.getFecha())) {
                return Response.status(Response.Status.FORBIDDEN).build();
            }
        }
        try {
            partidoFachada.save(partido);
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public PartidoDto updatePartido(PartidoDto usr) {
        try {
            partidoFachada.update(conversor.dtoToPartido(usr));
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            return new PartidoDto();
        }
    }

    @DELETE
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deletePartido(@PathParam("usrNo") int usrNo) {
        Partido u = partidoFachada.get(usrNo);
        partidoFachada.delete(u);
    }

}
