package uv.fei.tesis.proyectoprocesos.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.sql.Date;

public class RegistrarProyectoController {

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

    private void accionRegistrar(ActionEvent actionEvent) {
        if (!itemsVacios()){
            Proyecto proyecto = new Proyecto();
            proyecto.setNombreDirector(txtNombreDirector.getText());
            proyecto.setFechaEnQueSeTitulo(String.valueOf(dateFechaTitulacion.getValue()));
            proyecto.setIdTipoDeProyecto(getIdTipoDeProyecto(boxTipoProyecto.getValue()));
            proyecto.setNombreDeProyecto(txtNombreDeProyecto.getText());
            proyecto.setIdCarrera(getIdCarrera(boxCarrera.getValue()));
            proyecto.setSinodales(txtSinodailes.getText());
            proyecto.setDescripcionDelTema(txtDescripcionTema.getText());
            proyecto.setNombreExponente(txtNombrePresentador.getText());

            ProyectoDAO proyectoDAO = new ProyectoDAO();
            boolean resultado = proyectoDAO.agregarProyecto(proyecto);
            if (resultado){
                Alert alertConfirmacion = new Alert(Alert.AlertType.INFORMATION);
                alertConfirmacion.setTitle("Correcto");
                alertConfirmacion.setHeaderText("Registro existosamente");
                alertConfirmacion.setContentText("EL proyecto se ha registrado exitosamente.");
                alertConfirmacion.showAndWait();
                //Regresarlo a la pantalla anterios o dejar los campos vacios
            }else {
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Error");
                alertError.setHeaderText("¡Ups!, no se ha podido registrar el proyecto");
                alertError.setContentText("Vuelve a intentarlo en unos minutos  y verifica que hayas llenado" +
                        "todos los apartados.");
                alertError.showAndWait();
            }
        }

    }

    private void accionRegresar(ActionEvent actionEvent) {
        //Regresar a la ventana de menú
    }

    private boolean itemsVacios(){
        boolean bandera = false;
        if (txtDescripcionTema.getText().isBlank() || txtSinodailes.getText().isBlank() || txtNombreDeProyecto.getText().isBlank()
            || txtNombreDirector.getText().isBlank() || txtNombrePresentador.getText().isBlank() || boxCarrera.getValue().isBlank()
            || boxTipoProyecto.getValue().isBlank() || dateFechaTitulacion.getValue().toString().isBlank()){
            bandera = true;
        }
        return bandera;
    }

    private int getIdCarrera(String carrera){
        int id = 0;
        switch (carrera) {
            case "Ingenieria de software" -> id = 1;
            case "Redes" -> id = 2;
            default -> {
            }
        }
        return id;
    }

    private  int getIdTipoDeProyecto(String tipoProyecto){
        int id = 0;
        return id;
    }


}
