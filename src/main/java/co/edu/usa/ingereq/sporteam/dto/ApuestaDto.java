package co.edu.usa.ingereq.sporteam.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "apuesta")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApuestaDto {

    private int id;
    private int valor;
    private String equipo;

    private PartidoDto id_partido;
    
    @XmlTransient
    private UsuarioDto id_usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public PartidoDto getId_partido() {
        return id_partido;
    }

    public void setId_partido(PartidoDto id_partido) {
        this.id_partido = id_partido;
    }

    public UsuarioDto getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(UsuarioDto id_usuario) {
        this.id_usuario = id_usuario;
    }

}
