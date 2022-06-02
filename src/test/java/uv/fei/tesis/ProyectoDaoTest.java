package uv.fei.tesis;

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
    }

    @Test
    public void buscarProyectoPorId(){
        assertFalse(proyecto.equals(proyectoDAO.buscarProyectoPorId(1)));
    }
    @Test
    public void buscarProyectoPorFechaYCarrera(){
        System.out.println(proyectoDAO.buscarProyectoPorFechaYCarrera("2022","05","Ingenieria de sof"));
    }
    @Test
    public void buscarProyectoTipoCarreraPorId(){
        System.out.println(proyectoDAO.buscarProyectoTipoCarreraPorId(3));
    }
}
