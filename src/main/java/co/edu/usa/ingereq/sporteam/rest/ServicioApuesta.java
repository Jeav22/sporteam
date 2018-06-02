package co.edu.usa.ingereq.sporteam.rest;

import co.edu.usa.ingereq.sporteam.conversor.Conversor;
import co.edu.usa.ingereq.sporteam.facade.ApuestaFachada;
import co.edu.usa.ingereq.sporteam.jpa.Apuesta;
import co.edu.usa.ingereq.sporteam.dto.ApuestaDto;
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

@Path("/apuestas")
public class ServicioApuesta {

    ApuestaFachada apuestaFachada;
    Conversor conversor;

    public ServicioApuesta() {
        apuestaFachada = new ApuestaFachada();
        conversor = new Conversor();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ApuestaDto> getApuestas_JSON() {
        List<Apuesta> listaApuestas = apuestaFachada.findAll();
        List<ApuestaDto> apuestaDtos = new ArrayList<>();
        for (Apuesta listaApuesta : listaApuestas) {
            apuestaDtos.add(conversor.apuestaToDto(listaApuesta));
        }
        return apuestaDtos;
    }

    @GET
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ApuestaDto getApuesta(@PathParam("usrNo") int usrNo) {
        return conversor.apuestaToDto(apuestaFachada.get(usrNo));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response crearApuesta(ApuestaDto usr) {
        try {
            apuestaFachada.save(conversor.dtoToApuesta(usr));
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ApuestaDto updateApuesta(ApuestaDto usr) {
        try {
            apuestaFachada.update(conversor.dtoToApuesta(usr));
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            return new ApuestaDto();
        }
    }

    @DELETE
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteApuesta(@PathParam("usrNo") int usrNo) {
        Apuesta u = apuestaFachada.get(usrNo);
        apuestaFachada.delete(u);
    }

}
