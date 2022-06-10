package uv.fei.tesis;

import org.junit.Before;
import org.junit.Test;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

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
    @Test
    public void agregarProyecto() {
        assertTrue(proyectoDAO.agregarProyecto(proyecto));
    }

    @Test
    public void eliminarProyecto() {
        int id = 2;
        assertTrue(proyectoDAO.eliminarProyecto(id));
    }

    @Test
    public void buscarTiposProyectos() {
        assertNotNull(proyectoDAO.buscarTiposProyectos());
    }

    @Test
    public void buscarIdProyecto() {
        int id = 1;
        assertEquals(proyectoDAO.buscarIdProyecto("Tesis"),id);
    }

    @Test
    public void buscarLicenciaturas() {
        assertNotNull(proyectoDAO.buscarLicenciaturas());
    }

    @Test
    public void buscarIdLicenciatura() {
        int id = 1;
        assertEquals(proyectoDAO.buscarIdLicenciatura("Estadistica"),id);
    }
    @Test
    public void obtenerProyectosDao(){
        System.out.println(proyectoDAO.obtenerProyectos());
    }
}
