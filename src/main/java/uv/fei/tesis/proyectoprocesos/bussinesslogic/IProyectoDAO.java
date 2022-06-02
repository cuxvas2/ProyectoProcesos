package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.util.Date;
import java.util.List;

public interface IProyectoDAO {
    public boolean agregarProyecto (Proyecto proyecto);
    public Proyecto buscarProyectoPorId (int buscarId);

    Proyecto buscarProyectoTipoCarreraPorId(int buscarId);

    List<Proyecto> buscarProyectoPorFechaYCarrera(String añoEnQueSeTitulo, String mesEnQueSeTitulo, String nombreCarrera);
}
