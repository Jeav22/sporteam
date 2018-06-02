package co.edu.usa.ingereq.sporteam.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "usuario")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioDto {

    private int id;

    private String nombre;
    private String correo;
    private String contrasena;
    private String celular;
    private int noIdentificacion;

    private List<ApuestaDto> apuestas;

    private List<PartidoDto> partidos;

    private List<EventoDto> eventos;

    public UsuarioDto() {
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

    public List<ApuestaDto> getApuestas() {
        return apuestas;
    }

    public void setApuestas(List<ApuestaDto> apuestas) {
        this.apuestas = apuestas;
    }

    public List<PartidoDto> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<PartidoDto> partidos) {
        this.partidos = partidos;
    }

    public List<EventoDto> getEventos() {
        return eventos;
    }

    public void setEventos(List<EventoDto> eventos) {
        this.eventos = eventos;
    }

}
