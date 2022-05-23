package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

public interface IProyectoDAO {
    public boolean agregarProyecto (Proyecto proyecto);
    public Proyecto buscarProyectoPorId (int buscarId);

}
