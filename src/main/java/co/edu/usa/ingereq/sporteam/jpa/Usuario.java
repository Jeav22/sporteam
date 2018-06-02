package co.edu.usa.ingereq.sporteam.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")

public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String correo;
    private String contrasena;
    private String celular;
    private int noIdentificacion;

    @OneToMany(mappedBy = "id_usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apuesta> apuestas;

    @ManyToMany(mappedBy = "jugadores", cascade = CascadeType.ALL)
    private List<Partido> partidos;

    @ManyToMany(mappedBy = "participantes", cascade = CascadeType.ALL)
    private List<Evento> eventos;

    public Usuario() {
        this.apuestas = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.eventos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(int noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    public void addPartido(Partido partido) {
        if (!getPartidos().contains(partido)) {
            getPartidos().add(partido);
        }
        if (!partido.getJugadores().contains(this)) {
            partido.getJugadores().add(this);
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void addEvento(Evento evento) {
        if (!getEventos().contains(evento)) {
            getEventos().add(evento);
        }
        if (!evento.getParticipantes().contains(this)) {
            evento.getParticipantes().add(this);
        }
    }

    public void addApuesta(Apuesta apuesta) {
        if (!getApuestas().contains(apuesta)) {
            apuesta.setId_usuario(this);
            this.apuestas.add(apuesta);
        }
    }

    public List<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }

}
