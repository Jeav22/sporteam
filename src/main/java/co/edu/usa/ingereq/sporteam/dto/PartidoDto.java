package co.edu.usa.ingereq.sporteam.dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "partido")
@XmlAccessorType(XmlAccessType.FIELD)
public class PartidoDto {

    private int id;

    private String ubicacion;
    private String fecha;
    private String equipo1;
    private String equipo2;
    private int marcadorEquipo1;
    private int marcadorEquipo2;
    private int apuesta;

    @XmlTransient
    private List<UsuarioDto> jugadores;

    @XmlTransient
    private List<ApuestaDto> apostadores;

    public PartidoDto() {
        this.jugadores = new ArrayList<>();
        this.apostadores = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getMarcadorEquipo1() {
        return marcadorEquipo1;
    }

    public void setMarcadorEquipo1(int marcadorEquipo1) {
        this.marcadorEquipo1 = marcadorEquipo1;
    }

    public int getMarcadorEquipo2() {
        return marcadorEquipo2;
    }

    public void setMarcadorEquipo2(int marcadorEquipo2) {
        this.marcadorEquipo2 = marcadorEquipo2;
    }

    public List<UsuarioDto> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<UsuarioDto> jugadores) {
        this.jugadores = jugadores;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public List<ApuestaDto> getApostadores() {
        return apostadores;
    }

    public void setApostadores(List<ApuestaDto> apostadores) {
        this.apostadores = apostadores;
    }

}
