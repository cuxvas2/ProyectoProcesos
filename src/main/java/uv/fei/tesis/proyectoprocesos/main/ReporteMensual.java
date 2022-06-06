package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReporteMensual implements Initializable {
    public Button bt_Buscar;
    public ComboBox<String> cb_mes;
    public ComboBox<String> cb_anio;
    public ComboBox<String> cb_carrera;

    @FXML private TableView<Proyecto> tb_database;
    @FXML private TableColumn<Proyecto, String> tf_titulo;
    @FXML private TableColumn<Proyecto, String> tf_fecha;
    @FXML private TableColumn<Proyecto, String> tf_director;
    @FXML private TableColumn<Proyecto, String> tf_tesista;

    public ProyectoDAO proyectoDAO = new ProyectoDAO();
    public List<Proyecto> proyectos;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        AñadirInf();
    }

    public void AñadirInf(){
        //Agrega todos los add mes
        cb_mes.getItems().add("Enero");
        cb_mes.getItems().add("Febrero");
        cb_mes.getItems().add("Marzo");
        cb_mes.getItems().add("Abril");
        cb_mes.getItems().add("Mayo");
        cb_mes.getItems().add("Junio");
        cb_mes.getItems().add("Julio");
        cb_mes.getItems().add("Agosto");
        cb_mes.getItems().add("Septiembre");
        cb_mes.getItems().add("Octubre");
        cb_mes.getItems().add("Noviembre");
        cb_mes.getItems().add("Diciembre");

        //agregar todo los add del año
        cb_anio.getItems().add("2022");
        cb_anio.getItems().add("2021");
        cb_anio.getItems().add("2020");
        cb_anio.getItems().add("2019");
        cb_anio.getItems().add("2018");
        cb_anio.getItems().add("2017");
        cb_anio.getItems().add("2016");
        cb_anio.getItems().add("2015");
        cb_anio.getItems().add("2014");
        cb_anio.getItems().add("2013");
        cb_anio.getItems().add("2012");
        cb_anio.getItems().add("2011");
        cb_anio.getItems().add("2010");

        List<String> listaCarreras = new ArrayList<String>();
        listaCarreras = proyectoDAO.buscarLicenciaturas();
        ObservableList<String> observableListCarreras = FXCollections.observableList(listaCarreras);
        cb_carrera.setItems(observableListCarreras);
    }

    public void clickmes(ActionEvent actionEvent) {
        if (cb_mes.getValue()!=null && cb_anio.getValue()!=null && cb_carrera.getValue()!=null ){
            bt_Buscar.setDisable(false);
        }
    }
    public void Clickanio(ActionEvent actionEvent) {
        if (cb_mes.getValue()!=null && cb_anio.getValue()!=null && cb_carrera.getValue()!=null ){
            bt_Buscar.setDisable(false);
        }
    }
    public void clickcarrera(ActionEvent actionEvent) {
        if (cb_mes.getValue()!=null && cb_anio.getValue()!=null && cb_carrera.getValue()!=null ){
            bt_Buscar.setDisable(false);
        }
    }
    public String fecha(){
        String formato="";
        switch (cb_mes.getValue()){
            case "Enero":
                formato="01";
                break;
            case "Febrero":
                formato="02";
                break;
            case "Marzo":
                formato="03";
                break;
            case "Abril":
                formato="04";
                break;
            case "Mayo":
                formato="05";
                break;
            case "Junio":
                formato="06";
                break;
            case "Julio":
                formato="07";
                break;
            case "Agosto":
                formato="08";
                break;
            case "Septiembre":
                formato="09";
                break;
            case "Octubre":
                formato="10";
                break;
            case "Noviembre":
                formato="11";
                break;
            case "Diciembre":
                formato="12";
                break;
        }
        return formato;
    }

    public void click(ActionEvent actionEvent) throws SQLException {
        proyectos = proyectoDAO.buscarProyectoPorFechaYCarrera(cb_anio.getValue(),fecha(),cb_carrera.getValue());
        ObservableList<Proyecto> listaProyect = FXCollections.observableArrayList();
        listaProyect.addAll(proyectos);
        configurarElementosTabla(listaProyect);
    }
    public void configurarElementosTabla(ObservableList<Proyecto> proyectos){
        this.tf_titulo.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDeProyecto()));
        this.tf_fecha.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getFechaEnQueSeTitulo()));
        this.tf_director.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreDirector()));
        this.tf_tesista.setCellValueFactory(cellDataFeatures -> new ReadOnlyObjectWrapper(cellDataFeatures.getValue().getNombreExponente()));
        this.tb_database.setItems(proyectos);
    }

    public void clicRegresar(ActionEvent event) throws IOException {
        Utilidad.regresarMenuPrincipal(event);
    }
}
