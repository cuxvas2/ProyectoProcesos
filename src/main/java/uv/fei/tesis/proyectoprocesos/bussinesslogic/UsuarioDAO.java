package uv.fei.tesis.proyectoprocesos.bussinesslogic;

import org.apache.log4j.Logger;
import uv.fei.tesis.proyectoprocesos.dataaccess.DataBaseConnection;
import uv.fei.tesis.proyectoprocesos.main.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private final Logger LOG = Logger.getLogger(UsuarioDAO.class);

    public boolean buscarUsuario(Usuario usuario){
        boolean resultado = false;
        DataBaseConnection dataBaseConnection = new DataBaseConnection();
        try (Connection connection = dataBaseConnection.getConnection()) {
            String query = "select id,contrasenia, correo from usuario where contrasenia = ? and correo = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, usuario.getContrasenia());
            statement.setString(2, usuario.getCorreo());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                throw new SQLException("No se ha encontrado ningun usuario");
            } else {
                resultado = true;
            }
        } catch (SQLException ex) {
            LOG.warn(UsuarioDAO.class.getName(), ex);
        } finally {
            dataBaseConnection.cerrarConexion();
        }
        return resultado;

    }
}
