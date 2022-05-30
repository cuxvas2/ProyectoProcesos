package uv.fei.tesis.proyectoprocesos.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {
    private Connection connection;
    private final String DB = "jdbc:mysql://127.0.0.1/tesisdb";
    private final String DB2 = "jdbc:mysql://databases.000webhost.com:3306/id18993546_tesisdb";

    private final String USUARIO = "Tesista";
    private final String USUARIO2 = "id18993546_tesista";
    private final String CONTRASENA = "Procesos";
    private final String CONTRASENA2 = "Procesos1234*";

    public Connection getConnection() throws SQLException {
        connect();
        return connection;
    }

    private void connect() throws SQLException {
        connection = DriverManager.getConnection(DB2, USUARIO2, CONTRASENA2);
    }

    public void cerrarConexion() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
