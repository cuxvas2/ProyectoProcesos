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
    public boolean eliminarProyecto(int id) {
        boolean flag=false;
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection=dataBaseConnection.getConnection()){
            String query="DELETE FROM proyecto WHERE id=?";
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setInt(1, id);
            int resultSet=statement.executeUpdate();
            if (resultSet==0){
                throw new SQLException("Educative experience couldn't be deleted");
            }else{
                flag = true;
            }
        } catch (SQLException e) {
            LOG.warn(ProyectoDAO.class.getName(), e);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return flag;
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

    @Override
    public List<String> buscarTiposProyectos() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        List<String> listaTiposProyectos = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select tipo from tipo_proyecto;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado ningun tipo de proyecto");
            } else {
                String nombre = "";
                do {
                    nombre = resultSet.getString("tipo");
                    listaTiposProyectos.add(nombre);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return listaTiposProyectos;
    }

    @Override
    public int buscarIdProyecto(String nombre) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int id = 0;
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select id from tipo_proyecto where tipo = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,nombre);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado ningun id de proyecto con nombre " + nombre);
            } else {
                id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return id;
    }

    @Override
    public List<String> buscarLicenciaturas() {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        List<String> listaLicenciaturas = new ArrayList<>();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select nombreCarrera from carrera;";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado ninguna Carrera");
            } else {
                String nombre = "";
                do {
                    nombre = resultSet.getString("nombreCarrera");
                    listaLicenciaturas.add(nombre);
                }while (resultSet.next());
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return listaLicenciaturas;
    }

    @Override
    public int buscarIdLicenciatura(String licenciatura) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        int id = 0;
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select id from carrera where nombreCarrera = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,licenciatura);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado ningun id de licenciatura con nombre " + licenciatura);
            } else {
                id = resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return id;
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

    @Override
    public Proyecto buscarProyectoTipoCarreraPorId(int buscarId) {
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        Proyecto proyecto = new Proyecto();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "Select * from proyecto p, tipo_proyecto tp, carrera c where p.id = ? " +
                    "and p.idTipoProyecto = tp.id and p.idCarrera = c.id";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, buscarId);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado el proyecto con el id " + buscarId);
            } else {
                proyecto = getProyectoTipoCarrera(resultSet);
            }
        } catch (SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return proyecto;
    }

    @Override
    public boolean buscarProyectoRepetidoDePresentador(String nombrePresentador, String nombreProyeto, String nivel) {
        boolean resultado = false;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select p.id, p.nombreExponente, nombreCarrera from proyecto p inner join carrera c " +
                    "on c.id = p.idCarrera where (nombreExponente = ? and nombreCarrera like ? ) or (nombreDeProyecto = ? ) ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nombrePresentador);
            statement.setString(2,nivel + "%");
            statement.setString(3,nombreProyeto);
            ResultSet resultSet = statement.executeQuery();
            resultado = resultSet.next();
            System.out.println(resultado + " - >"); //Borrar

        } catch (SQLException ex) {
            LOG.warn(UsuarioDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return resultado;
    }

    private Proyecto getProyectoTipoCarrera(ResultSet resultSet) {
        Proyecto proyecto = new Proyecto();
        int id = 0;
        String nombreExponente  = "";
        String nombreDirector;
        String sinodales = "";
        String nomnreDeProyecto = "";
        String fechaEnQueSeTitulo = null;
        String descripcionDelTema = "";
        String tipoProyecto="";
        String carrera="";
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
            tipoProyecto = resultSet.getString("tipo");
            carrera = resultSet.getString("nombreCarrera");


            proyecto.setId(id);
            proyecto.setNombreExponente(nombreExponente);
            proyecto.setNombreDirector(nombreDirector);
            proyecto.setSinodales(sinodales);
            proyecto.setNombreDeProyecto(nomnreDeProyecto);
            proyecto.setFechaEnQueSeTitulo(fechaEnQueSeTitulo);
            proyecto.setDescripcionDelTema(descripcionDelTema);
            proyecto.setIdTipoDeProyecto(idTipoDeProyecto);
            proyecto.setIdCarrera(idCarrera);
            proyecto.setTipoProyecto(tipoProyecto);
            proyecto.setCarrera(carrera);



        } catch(SQLException ex) {
            LOG.warn(ProyectoDAO.class.getName(), ex);
        }
        return proyecto;
    }
}
