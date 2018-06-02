package co.edu.usa.ingereq.sporteam.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APUESTA")
public class Apuesta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int valor;
    private String equipo;
    
    @ManyToOne
    @JoinColumn(name = "id_partido")
    private Partido id_partido;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;
    
    public Apuesta() {
    }

    public Apuesta( Partido id_partido, Usuario id_usuario, int valor, String equipo) {
        this.id_partido = id_partido;
        this.id_usuario = id_usuario;
        this.valor = valor;
        this.equipo = equipo;
    }

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

    public Partido getId_partido() {
        return id_partido;
    }

    public void setId_partido(Partido id_partido) {
        this.id_partido = id_partido;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

}
