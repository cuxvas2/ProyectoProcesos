package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tesis.proyectoprocesos.dataaccess.DataBaseConnection;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProyectoDAO implements IProyectoDAO{
    private final Logger LOG = Logger.getLogger(ProyectoDAO.class);


    @Override
    public boolean agregarProyecto(Proyecto proyecto) {
        return false;
    }

    @Override
    public Proyecto buscarProyectoPorId(int buscarId) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Proyecto proyecto = new Proyecto();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "Select * from proyecto where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, buscarId);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado el proyecto con el id " + buscarId);
            } else {
                proyecto = getProyecto(resultSet);
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return proyecto;

    }

    private Proyecto getProyecto(ResultSet resultSet) {
        Proyecto proyecto = new Proyecto();
        int id = 0;
        String nombreExponente  = "";
        String nombreDirector = "";
        String sinodales = "";
        String nomnreDeProyecto = "";
        String fechaEnQueSeTitulo = "";
        String descripcionDelTema = "";
        int idTipoDeProyecto =  0;
        int idCarrera = 0;


        try {
            id = resultSet.getInt("id");
            nombreExponente = resultSet.getString("nombreExponente");
            nombreDirector = resultSet.getString("nombreDirector");
            sinodales = resultSet.getString("sinodales");
            nomnreDeProyecto = resultSet.getString("nombreDeProyecto");
            fechaEnQueSeTitulo = resultSet.getString("fechaEnQueSeTitulo");
            descripcionDelTema = resultSet.getString("descripcionDelTema");
            idTipoDeProyecto = resultSet.getInt("idTipoProyecto");
            idCarrera =resultSet.getInt("idCarrera");

            proyecto.setId(id);
            proyecto.setNombreExponente(nombreExponente);
            proyecto.setNombreDirector(nombreDirector);
            proyecto.setSinodales(sinodales);
            proyecto.setNombreDeProyecto(nomnreDeProyecto);
            proyecto.setFechaEnQueSeTitulo(fechaEnQueSeTitulo);
            proyecto.setDescripcionDelTema(descripcionDelTema);
            proyecto.setIdTipoDeProyecto(idTipoDeProyecto);
            proyecto.setIdCarrera(idCarrera);



        } catch(SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        }
        return proyecto;
    }
}
