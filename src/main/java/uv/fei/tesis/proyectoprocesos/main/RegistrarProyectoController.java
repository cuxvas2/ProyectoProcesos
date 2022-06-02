package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrarProyectoController implements Initializable {

    @FXML private Button btnRegresar;
    @FXML private TextField txtNombreDeProyecto;
    @FXML private TextField txtNombrePresentador;
    @FXML private TextField txtSinodailes;
    @FXML private TextArea txtDescripcionTema;
    @FXML private ChoiceBox<String> boxTipoProyecto;
    @FXML private ChoiceBox<String> boxCarrera;
    @FXML private TextField txtNombreDirector;
    @FXML private DatePicker dateFechaTitulacion;
    @FXML private Button btnRegistrar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        añadirElementosBox();
    }

    @FXML
    private void accionRegistrar(ActionEvent actionEvent) {
        if (!itemsVacios() && validarFechaAnteriorActual()){
            Proyecto proyecto = new Proyecto();
            ProyectoDAO proyectoDAO = new ProyectoDAO();

            proyecto.setNombreDirector(txtNombreDirector.getText());
            proyecto.setFechaEnQueSeTitulo(String.valueOf(dateFechaTitulacion.getValue()));
            proyecto.setIdTipoDeProyecto(proyectoDAO.buscarIdProyecto(boxTipoProyecto.getValue()));
            proyecto.setNombreDeProyecto(txtNombreDeProyecto.getText());
            proyecto.setIdCarrera(proyectoDAO.buscarIdLicenciatura(boxCarrera.getValue()));
            proyecto.setSinodales(txtSinodailes.getText());
            proyecto.setDescripcionDelTema(txtDescripcionTema.getText());
            proyecto.setNombreExponente(txtNombrePresentador.getText());

            boolean resultado = proyectoDAO.agregarProyecto(proyecto);
            if (resultado){
                avisos("Correcto", "EL proyecto se ha registrado exitosamente.", Alert.AlertType.INFORMATION);
                setItemsEnBlanco();
                //Regresarlo a la pantalla anterios o dejar los campos vacios
            }else {
                avisos("Error","¡Ups!, no se ha podido registrar el proyecto, estamos teniendo problemas.\n " +
                        "Vuelve a intentarlo en unos minutos", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void accionRegresar(ActionEvent actionEvent) {
        //Regresar a la ventana de menú
    }

    private boolean itemsVacios(){
        boolean bandera = false;
        if (txtDescripcionTema.getText().isBlank() || txtSinodailes.getText().isBlank() || txtNombreDeProyecto.getText().isBlank()
                || txtNombreDirector.getText().isBlank() || txtNombrePresentador.getText().isBlank() || boxCarrera.getValue() == null
                || boxTipoProyecto.getValue() == null || dateFechaTitulacion.getValue() == null){
            bandera = true;
            avisos("¡Campos vacios!","Llena todos los apartados para poder continnuar", Alert.AlertType.ERROR);
        }
        return bandera;
    }

    private void añadirElementosBox(){
        ProyectoDAO proyectoDAO = new ProyectoDAO();
        List<String> listaCarreras = new ArrayList<String>();
        listaCarreras = proyectoDAO.buscarLicenciaturas();
        ObservableList<String> observableListCarreras = FXCollections.observableList(listaCarreras);
        boxCarrera.setItems(observableListCarreras);

        List<String> listaTiposProyectos = new ArrayList<String>();
        listaTiposProyectos=proyectoDAO.buscarTiposProyectos();
        ObservableList<String> observableListProyectos = FXCollections.observableList(listaTiposProyectos);
        boxTipoProyecto.setItems(observableListProyectos);
    }

    private boolean validarFechaAnteriorActual(){
        boolean flag = false;
        if (dateFechaTitulacion.getValue() != null){
            flag = dateFechaTitulacion.getValue().isBefore(LocalDate.now());
            if (!flag){
                avisos("¿Fecha futura?","La fecha no puede ser posterior o igual a la actual", Alert.AlertType.ERROR);
            }
        }
        return flag;
    }

    private void avisos(String titulo, String mensaje, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void setItemsEnBlanco(){
        txtNombreDirector.setText("");
        txtNombrePresentador.setText("");
        txtNombreDeProyecto.setText("");
        txtSinodailes.setText("");
        txtDescripcionTema.setText("");
    }


}
