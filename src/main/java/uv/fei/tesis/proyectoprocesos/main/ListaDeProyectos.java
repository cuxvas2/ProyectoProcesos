package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaDeProyectos implements Initializable {
    @FXML private TableView<Proyecto> tblProyecto;
    @FXML private  TableColumn<Proyecto,String> colExponente;
    @FXML private TableColumn<Proyecto,String> colNombreProyecto;

    @FXML private TableColumn<Proyecto, String> colDirector;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        Proyecto proyecto;
        proyecto = proyectoDAO.buscarProyectoTipoCarreraPorId(3);
        ObservableList<Proyecto> listaProyectos =
                FXCollections.observableArrayList();
        listaProyectos.add(proyecto);
        observaList(listaProyectos);
    }

    private void observaList(ObservableList<Proyecto> proyectos) {
        this.colDirector.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDirector()));
        this.colExponente.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreExponente()));
        this.colNombreProyecto.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDeProyecto()));
        this.tblProyecto.setItems(proyectos);

    }

}
