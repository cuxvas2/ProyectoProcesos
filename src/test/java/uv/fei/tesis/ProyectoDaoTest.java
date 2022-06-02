package uv.fei.tesis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProyectoDaoTest {
    private Proyecto proyecto;
    private ProyectoDAO proyectoDAO;

    @Before
    public void inicio(){
        proyectoDAO = new ProyectoDAO();
        proyecto = new Proyecto(1,"Paulo","Jose","Maria","Mariposas in Isof","2002-12-20","las mariposas un suceso extraño",1,1);
        proyecto = new Proyecto(2,"Victor","Jose","Lulú","Ordenamiento","2020-11-26","Metodo de ordenamiento de complejidad logaritmica",1,3);
    }

    @Test
    public void buscarProyectoPorId(){
        assertFalse(proyecto.equals(proyectoDAO.buscarProyectoPorId(1)));
    }

    @Test
    public void agregarProyecto() {
        assertTrue(proyectoDAO.agregarProyecto(proyecto));
    }

    @Test
    public void eliminarProyecto() {
        int id = 2;
        assertTrue(proyectoDAO.eliminarProyecto(id));
    }
}
