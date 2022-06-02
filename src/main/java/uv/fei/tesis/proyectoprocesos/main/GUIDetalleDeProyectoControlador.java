package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
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
    @FXML private TableColumn <Proyecto,String>colFechaDeProyecto;
    @FXML private TableColumn<Proyecto, String> colDirector;
    @FXML private TableColumn<Proyecto, String> colCategoria;
    @FXML private TableColumn<Proyecto, String> colProfesor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        ObservableList<Proyecto> listaProyectos =
                FXCollections.observableArrayList(proyectoDAO.buscarProyectoPorFechaYCarrera("2022","05","Ingenieria de sof"));
        System.out.println(listaProyectos.get(0));
        observaList(listaProyectos);
    }

    private void observaList(ObservableList<Proyecto> proyectos) {
        this.colNombreTesis.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDeProyecto()));
        this.colDescripcion.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getDescripcionDelTema()));
        this.colFechaDeProyecto.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getFechaEnQueSeTitulo()));
        this.colDirector.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDirector()));
        this.colCategoria.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getIdCarrera()));
        this.colProfesor.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getSinodales()));
        this.tblProyecto.setItems(proyectos);

    }



}
