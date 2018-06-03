package co.edu.usa.ingereq.sporteam.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PARTIDO")
public class Partido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ubicacion;
    private String fecha;
    private String equipo1;
    private String equipo2;
    private int marcadorEquipo1;
    private int marcadorEquipo2;
    private int apuesta;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "JUGADORES",
            joinColumns = @JoinColumn(name = "ID_PARTIDO"),
            inverseJoinColumns = @JoinColumn(name = "ID_USUARIO")
    )
    private List<Usuario> jugadores;

    @OneToMany(mappedBy = "id_partido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apuesta> apostadores;

    public Partido() {
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

    public List<Usuario> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Usuario> jugadores) {
        this.jugadores = jugadores;
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public List<Apuesta> getApostadores() {
        return apostadores;
    }

    public void setApostadores(List<Apuesta> apostadores) {
        this.apostadores = apostadores;
    }

}
