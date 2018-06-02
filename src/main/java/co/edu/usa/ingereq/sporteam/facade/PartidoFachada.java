package co.edu.usa.ingereq.sporteam.facade;

import co.edu.usa.ingereq.sporteam.dao.ServiceImpl;
import co.edu.usa.ingereq.sporteam.dao.SingletonConnection;
import co.edu.usa.ingereq.sporteam.jpa.Partido;
import java.util.List;
import javax.persistence.EntityManager;

public class PartidoFachada extends ServiceImpl<Partido> {

    public PartidoFachada() {
        super(Partido.class);
        try {
            EntityManager em = SingletonConnection.getConnection();
            super.setEntityManager(em);
        } catch (Exception e) {
            System.out.println("Problemas en la realizacion de conexion con la base de datos\n" + e);
        }
    }

    @Override
    public List<Partido> findAll() {
        return super.findAll();
    }
}
