package co.edu.usa.ingereq.sporteam.rest;

import co.edu.usa.ingereq.sporteam.conversor.Conversor;
import co.edu.usa.ingereq.sporteam.dto.UsuarioDto;
import co.edu.usa.ingereq.sporteam.facade.UsuarioFachada;
import co.edu.usa.ingereq.sporteam.jpa.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class ServicioUsuario {

    UsuarioFachada usuarioFachada;
    Conversor conversor;

    public ServicioUsuario() {
        usuarioFachada = new UsuarioFachada();
        conversor = new Conversor();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<UsuarioDto> getUsuarios_JSON() {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        List<Usuario> listaUsuarios = usuarioFachada.findAll();
        usuarioDtos = conversor.usuariosToDtos(listaUsuarios);
        return usuarioDtos;
    }

    @GET
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDto getUsuario(@PathParam("usrNo") int usrNo) {
        return conversor.usuarioToDto(usuarioFachada.get(usrNo));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDto crearUsuario(UsuarioDto usr) {
        Usuario usuario = new Usuario();
        usuario = conversor.dtoToUsuario(usr);

        List<Usuario> usuarios = usuarioFachada.findAll();
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(usr.getCorreo())) {
                return new UsuarioDto();
            }
        }
        try {
            usuarioFachada.save(usuario);
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error de guardado");
            return new UsuarioDto();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDto loginUsuario(UsuarioDto usr) {
        List<UsuarioDto> usuarios = conversor.usuariosToDtos(usuarioFachada.findAll());
        for (UsuarioDto usuario : usuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(usr.getCorreo()) && usuario.getContrasena().equals(usr.getContrasena())) {
                System.out.println("ok");
                return usuario;
            }
        }
        return new UsuarioDto();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public UsuarioDto updateUsuario(UsuarioDto usr) {
        try {
            usuarioFachada.update(conversor.dtoToUsuario(usr));
            return usr;
        } catch (Exception e) {
            e.printStackTrace();
            return new UsuarioDto();
        }
    }

    @DELETE
    @Path("/{usrNo}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteUsuario(@PathParam("usrNo") int usrNo) {
        Usuario u = usuarioFachada.get(usrNo);
        usuarioFachada.delete(u);
    }

}
