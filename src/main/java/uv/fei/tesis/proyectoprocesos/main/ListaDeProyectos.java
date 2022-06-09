package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaDeProyectos implements Initializable {
    @FXML private Button btnDetalleDeProyecto;
    @FXML private TableView<Proyecto> tblProyecto;
    @FXML private  TableColumn<Proyecto,String> colExponente;
    @FXML private TableColumn<Proyecto,String> colNombreProyecto;

    @FXML private TableColumn<Proyecto, String> colDirector;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        List<Proyecto> proyectos = proyectoDAO.obtenerProyectos();
        ObservableList<Proyecto> listaProyectos =
                FXCollections.observableArrayList();
        listaProyectos.addAll(proyectos);
        observaList(listaProyectos);
        btnDetalleDeProyecto.setDisable(true);
    }

    private void observaList(ObservableList<Proyecto> proyectos) {
        this.colDirector.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDirector()));
        this.colExponente.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreExponente()));
        this.colNombreProyecto.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDeProyecto()));
        this.tblProyecto.setItems(proyectos);

    }

    public void clicRegresar(ActionEvent event) throws IOException {
        Utilidad.regresarMenuPrincipal(event);
    }

    public void clicDetalleDeProyecto(ActionEvent event) {


    }

    public void seleccionarProyecto(MouseEvent mouseEvent) {
        btnDetalleDeProyecto.setDisable(tblProyecto.getSelectionModel().getSelectedItem() == null);

    }
}
