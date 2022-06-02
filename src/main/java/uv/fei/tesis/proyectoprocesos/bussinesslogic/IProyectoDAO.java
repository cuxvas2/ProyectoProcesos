package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.util.List;

public interface IProyectoDAO {
    public boolean agregarProyecto (Proyecto proyecto);
    public boolean eliminarProyecto (int id);
    public Proyecto buscarProyectoPorId (int buscarId);
    public List<String> buscarTiposProyectos();
    public int buscarIdProyecto(String nombre);
    public  List<String> buscarLicenciaturas();
    public int buscarIdLicenciatura(String licenciatura);

}
