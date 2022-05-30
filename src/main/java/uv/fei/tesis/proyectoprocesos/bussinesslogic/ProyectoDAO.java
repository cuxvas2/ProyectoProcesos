package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tesis.proyectoprocesos.dataaccess.DataBaseConnection;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO implements IProyectoDAO{
    private final Logger LOG = Logger.getLogger(ProyectoDAO.class);


    @Override
    public boolean agregarProyecto(Proyecto proyecto) {
        boolean bandera = false;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()){
            String query = "INSERT INTO proyecto VALUES (NULL,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,proyecto.getNombreExponente());
            statement.setString(2,proyecto.getNombreDirector());
            statement.setString(3,proyecto.getSinodales());
            statement.setString(4,proyecto.getNombreDeProyecto());
            statement.setString(5,proyecto.getFechaEnQueSeTitulo());
            statement.setString(6,proyecto.getDescripcionDelTema());
            statement.setInt(7,proyecto.getIdTipoDeProyecto());
            statement.setInt(8,proyecto.getIdCarrera());
            int resultSet = statement.executeUpdate();
            if (resultSet == 0){
                throw new SQLException("No se ha podido registrar proyecto con nombre " + proyecto.getNombreDeProyecto());
            } else {
                bandera = true;
            }
        }catch (SQLException ex){
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return bandera;
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

    @Override
    public List<Proyecto> buscarProyectoPorFechaYCarrera(String añoEnQueSeTitulo,String mesEnQueSeTitulo, String nombreCarrera) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        List<Proyecto> proyectos = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "SELECT A.*, " +
                    "nombreCarrera " +
                    "FROM proyecto A " +
                    "INNER JOIN carrera B " +
                    "ON A.idCarrera = B.id " +
                    "where fechaEnQueSeTitulo LIKE ? ? and nombreCarrera like ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,añoEnQueSeTitulo + "-");
            statement.setString(2, mesEnQueSeTitulo + "%");
            statement.setString(3,"%" + nombreCarrera + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                proyectos.add(getProyecto(resultSet));
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return proyectos;


    }

    private Proyecto getProyecto(ResultSet resultSet) {
        Proyecto proyecto = new Proyecto();
        int id = 0;
        String nombreExponente  = "";
        String nombreDirector = "";
        String sinodales = "";
        String nomnreDeProyecto = "";
        String fechaEnQueSeTitulo = null;
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
