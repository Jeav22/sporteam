package co.edu.usa.ingereq.sporteam.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "evento")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoDto {

    private int id;

    private String fecha;
    private int limite;
    private String tipo;
    private String descripcion;
    private String direccion;

    @XmlTransient
    private List<UsuarioDto> participantes;

    public EventoDto() {
        this.participantes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<UsuarioDto> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<UsuarioDto> participantes) {
        this.participantes = participantes;
    }

}
