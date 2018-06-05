package co.edu.usa.ingereq.sporteam.conversor;

import co.edu.usa.ingereq.sporteam.dto.ApuestaDto;
import co.edu.usa.ingereq.sporteam.dto.EventoDto;
import co.edu.usa.ingereq.sporteam.dto.PartidoDto;
import co.edu.usa.ingereq.sporteam.dto.UsuarioDto;
import co.edu.usa.ingereq.sporteam.jpa.Apuesta;
import co.edu.usa.ingereq.sporteam.jpa.Evento;
import co.edu.usa.ingereq.sporteam.jpa.Partido;
import co.edu.usa.ingereq.sporteam.jpa.Usuario;
import java.util.ArrayList;
import java.util.List;

public class Conversor {

    //JPA to DTO
    public ApuestaDto apuestaToDto(Apuesta apuesta) {
        ApuestaDto apuestaDto = new ApuestaDto();
        apuestaDto.setEquipo(apuesta.getEquipo());
        apuestaDto.setId(apuesta.getId());
        apuestaDto.setValor(apuesta.getValor());
        apuestaDto.setId_partido(partidoToDto(apuesta.getId_partido()));
        return apuestaDto;
    }

    public EventoDto eventoToDto(Evento evento) {
        EventoDto eventoDto = new EventoDto();
        eventoDto.setDescripcion(evento.getDescripcion());
        eventoDto.setDireccion(evento.getDireccion());
        eventoDto.setFecha(evento.getFecha());
        eventoDto.setId(evento.getId());
        eventoDto.setLimite(evento.getLimite());
        eventoDto.setTipo(evento.getTipo());
        return eventoDto;
    }

    public PartidoDto partidoToDto(Partido partido) {
        PartidoDto partidoDto = new PartidoDto();
        partidoDto.setApuesta(partido.getApuesta());
        partidoDto.setEquipo1(partido.getEquipo1());
        partidoDto.setEquipo2(partido.getEquipo2());
        partidoDto.setFecha(partido.getFecha());
        partidoDto.setId(partido.getId());
        partidoDto.setMarcadorEquipo1(partido.getMarcadorEquipo1());
        partidoDto.setMarcadorEquipo2(partido.getMarcadorEquipo2());
        partidoDto.setUbicacion(partido.getUbicacion());
        return partidoDto;
    }

    public UsuarioDto usuarioToDto(Usuario u) {
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setCelular(u.getCelular());
        usuarioDto.setContrasena(u.getContrasena());
        usuarioDto.setCorreo(u.getCorreo());
        usuarioDto.setId(u.getId());
        usuarioDto.setNoIdentificacion(u.getNoIdentificacion());
        usuarioDto.setNombre(u.getNombre());
        if (u.getApuestas() != null) {
            usuarioDto.setApuestas(apuestasToDtos(u.getApuestas()));
        }
        if (u.getEventos() != null) {
            usuarioDto.setEventos(eventosToDtos(u.getEventos()));
        }
        if (u.getPartidos() != null) {
            usuarioDto.setPartidos(partidosToDtos(u.getPartidos()));
        }
        return usuarioDto;
    }

    //List<JPA> to List<DTO>
    public List<ApuestaDto> apuestasToDtos(List<Apuesta> apuestas) {
        List<ApuestaDto> apuestaDtos = new ArrayList<>();
        for (Apuesta apuesta : apuestas) {
            ApuestaDto apuestaDto = new ApuestaDto();
            apuestaDto = apuestaToDto(apuesta);
            apuestaDtos.add(apuestaDto);
        }
        return apuestaDtos;
    }

    public List<EventoDto> eventosToDtos(List<Evento> eventos) {
        List<EventoDto> eventoDtos = new ArrayList<>();
        for (Evento evento : eventos) {
            EventoDto eventoDto = new EventoDto();
            eventoDto = eventoToDto(evento);
            eventoDtos.add(eventoDto);
        }
        return eventoDtos;
    }

    public List<PartidoDto> partidosToDtos(List<Partido> partidos) {
        List<PartidoDto> partidoDtos = new ArrayList<>();
        for (Partido partido : partidos) {
            PartidoDto partidoDto = new PartidoDto();
            partidoDto = partidoToDto(partido);
            partidoDtos.add(partidoDto);
        }
        return partidoDtos;
    }

    public List<UsuarioDto> usuariosToDtos(List<Usuario> usuario) {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        for (Usuario u : usuario) {
            UsuarioDto usuarioDto = new UsuarioDto();
            usuarioDto = usuarioToDto(u);
            usuarioDtos.add(usuarioDto);
        }
        return usuarioDtos;
    }

    //DTO to JPA
    public Apuesta dtoToApuesta(ApuestaDto apuestaDto) {
        Apuesta apuesta = new Apuesta();
        apuesta.setEquipo(apuestaDto.getEquipo());
        apuesta.setId(apuestaDto.getId());
        apuesta.setValor(apuestaDto.getValor());
        if (apuestaDto.getId_usuario() != null) {
            apuesta.setId_usuario(dtoToUsuario(apuestaDto.getId_usuario()));
        }
        apuesta.setId_partido(dtoToPartido(apuestaDto.getId_partido()));
        return apuesta;
    }

    public Evento dtoToEvento(EventoDto eventoDto) {
        Evento evento = new Evento();
        evento.setDescripcion(eventoDto.getDescripcion());
        evento.setDireccion(eventoDto.getDireccion());
        evento.setFecha(eventoDto.getFecha());
        evento.setId(eventoDto.getId());
        evento.setLimite(eventoDto.getLimite());
        evento.setTipo(eventoDto.getTipo());
        if (eventoDto.getParticipantes() != null) {
            evento.setParticipantes(dtosToUsuarios(eventoDto.getParticipantes()));
        }
        return evento;
    }

    public Partido dtoToPartido(PartidoDto partidoDto) {
        Partido partido = new Partido();
        partido.setApuesta(partidoDto.getApuesta());
        partido.setEquipo1(partidoDto.getEquipo1());
        partido.setEquipo2(partidoDto.getEquipo2());
        partido.setFecha(partidoDto.getFecha());
        partido.setId(partidoDto.getId());
        partido.setMarcadorEquipo1(partidoDto.getMarcadorEquipo1());
        partido.setMarcadorEquipo2(partidoDto.getMarcadorEquipo2());
        partido.setUbicacion(partidoDto.getUbicacion());
        if (partidoDto.getJugadores() != null) {
            partido.setJugadores(dtosToUsuarios(partidoDto.getJugadores()));
        }
        if (partidoDto.getApostadores() != null) {
            partido.setApostadores(dtosToApuestas(partidoDto.getApostadores()));
        }
        return partido;
    }

    public Usuario dtoToUsuario(UsuarioDto u) {
        Usuario usuario = new Usuario();
        usuario.setCelular(u.getCelular());
        usuario.setContrasena(u.getContrasena());
        usuario.setCorreo(u.getCorreo());
        usuario.setId(u.getId());
        usuario.setNoIdentificacion(u.getNoIdentificacion());
        usuario.setNombre(u.getNombre());
        if (u.getApuestas() != null) {
            usuario.setApuestas(dtosToApuestas(u.getApuestas()));
        }
        if (u.getEventos() != null) {
            usuario.setEventos(dtosToEventos(u.getEventos()));
        }
        if (u.getPartidos() != null) {
            usuario.setPartidos(dtosToPartidos(u.getPartidos()));
        }
        return usuario;
    }

    //List<DTO> to List<JPA>
    public List<Apuesta> dtosToApuestas(List<ApuestaDto> apuestaDtos) {
        List<Apuesta> apuestas = new ArrayList<>();
        for (ApuestaDto a : apuestaDtos) {
            Apuesta apuesta = new Apuesta();
            apuesta = dtoToApuesta(a);
            apuestas.add(apuesta);
        }
        return apuestas;
    }

    public List<Evento> dtosToEventos(List<EventoDto> eventoDtos) {
        List<Evento> eventos = new ArrayList<>();
        for (EventoDto eventoDto : eventoDtos) {
            Evento evento = new Evento();
            evento = dtoToEvento(eventoDto);
            eventos.add(evento);
        }
        return eventos;
    }

    public List<Partido> dtosToPartidos(List<PartidoDto> partidoDtos) {
        List<Partido> partidos = new ArrayList<>();
        for (PartidoDto partidoDto : partidoDtos) {
            Partido partido = new Partido();
            partido = dtoToPartido(partidoDto);
            partidos.add(partido);
        }
        return partidos;
    }

    public List<Usuario> dtosToUsuarios(List<UsuarioDto> usuarioDtos) {
        List<Usuario> usuarios = new ArrayList<>();
        for (UsuarioDto u : usuarioDtos) {
            Usuario usuario = new Usuario();
            usuario = dtoToUsuario(u);
            usuarios.add(usuario);
        }
        return usuarios;
    }

}
