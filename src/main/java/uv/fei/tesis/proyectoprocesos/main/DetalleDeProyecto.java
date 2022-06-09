package uv.fei.tesis.proyectoprocesos.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.Setter;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetalleDeProyecto implements Initializable {
    @Setter
    private Proyecto proyecto;
    @FXML private AnchorPane panel;
    @FXML
    private Label lblNombreExponente;
    @FXML private Label lblNombreDirector;
    @FXML private Label lblSinodales;
    @FXML private Label lblNombreDeProyecto;
    @FXML private Label lblFechaDeTitulacion;
    @FXML private Label lblDescripcionDelTema;
    @FXML private Label lblTipo;
    @FXML private Label lblCarrera;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblCarrera.setText(proyecto.getCarrera());
        lblTipo.setText(proyecto.getTipoProyecto());
        lblDescripcionDelTema.setText(proyecto.getDescripcionDelTema());
        lblFechaDeTitulacion.setText(proyecto.getFechaEnQueSeTitulo());
        lblNombreDeProyecto.setText(proyecto.getNombreDeProyecto());
        lblSinodales.setText(proyecto.getSinodales());
        lblNombreDirector.setText(proyecto.getNombreDirector());
        lblNombreExponente.setText(proyecto.getNombreExponente());



    }

    public void clicRegresar(ActionEvent event) throws IOException {
        Utilidad.abrirVentana(event,"ListaDeProyectos.fxml","Lista de proyectos");
    }
}
