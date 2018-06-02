package co.edu.usa.ingereq.sporteam.rest;

import co.edu.usa.ingereq.sporteam.conversor.Conversor;
import co.edu.usa.ingereq.sporteam.facade.EventoFachada;
import co.edu.usa.ingereq.sporteam.jpa.Evento;
import co.edu.usa.ingereq.sporteam.dto.EventoDto;
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

@Path("/eventos")
public class ServicioEvento {

    EventoFachada eventoFachada;
    Conversor conversor;

    public ServicioEvento() {
        eventoFachada = new EventoFachada();
        conversor = new Conversor();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<EventoDto> getEventos_JSON() {
        List<Evento> listaEventos = eventoFachada.findAll();
        List<EventoDto> eventoDtos = new ArrayList<>();
        for (Evento listaEvento : listaEventos) {
            eventoDtos.add(conversor.eventoToDto(listaEvento));
        }
        return eventoDtos;
    }

    @GET
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EventoDto getEvento(@PathParam("usrNo") int usrNo) {
        return conversor.eventoToDto(eventoFachada.get(usrNo));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response crearEvento(EventoDto usr) {
        try {
            eventoFachada.save(conversor.dtoToEvento(usr));
            return Response.status(Response.Status.ACCEPTED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public EventoDto updateEvento(EventoDto usr) {
        try {
            eventoFachada.update(conversor.dtoToEvento(usr));
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            return new EventoDto();
        }
    }

    @DELETE
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteEvento(@PathParam("usrNo") int usrNo) {
        Evento u = eventoFachada.get(usrNo);
        eventoFachada.delete(u);
    }

}
