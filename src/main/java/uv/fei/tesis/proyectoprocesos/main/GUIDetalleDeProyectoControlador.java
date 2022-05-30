package uv.fei.tesis.proyectoprocesos.main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIDetalleDeProyectoControlador implements Initializable {
    @FXML
    private TableView<Proyecto> tblProyecto;
    @FXML private TableColumn<Proyecto, String> colNombreTesis;
    @FXML private TableColumn<Proyecto, String> colDescripcion;
    @FXML private TableColumn colFechaDeProyecto;
    @FXML private TableColumn<Proyecto, String> colNombreDeTesis;
    @FXML private TableColumn<Proyecto, String> colDirector;
    @FXML private TableColumn<Proyecto, String> colCategoria;
    @FXML private TableColumn<Proyecto, String> colProfesor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        proyectoDAO.buscarProyectoPorId(1);


    }
}
