package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.ProyectoDAO;
import uv.fei.tesis.proyectoprocesos.dataaccess.DataBaseConnection;
import uv.fei.tesis.proyectoprocesos.domain.Proyecto;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ReporteMensual implements Initializable {
    public Button bt_Buscar;
    public ComboBox<String> cb_mes;
    public ComboBox<String> cb_anio;
    public ComboBox<String> cb_carrera;
    public TableView tb_database;

    public TableColumn tf_titulo;
    public TableColumn tf_fecha;
    public TableColumn tf_carrera;
    public TableColumn tf_director;
    public TableColumn tf_tesista;

    ObservableList<Proyecto> listaProyectos;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        AñadirInf();
        configurarElementosTabla();
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

        //agregar todos los add de carrera
        cb_carrera.getItems().add("Estadística");
        cb_carrera.getItems().add("Redes y Servicios de Cómputo");
        cb_carrera.getItems().add("Tecnologías Computacionales");
        cb_carrera.getItems().add("Ingeniería de Software");
        cb_carrera.getItems().add("Ciencias y Técnicas Estadísticas");

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
        String formato = null;
        switch (cb_mes.getValue()){
            case "Enero":
                formato=cb_anio.getValue()+"01";
                break;
            case "Febrero":
                formato=cb_anio.getValue()+"02";
                break;
            case "Marzo":
                formato=cb_anio.getValue()+"03";
                break;
            case "Abril":
                formato=cb_anio.getValue()+"04";
                break;
            case "Mayo":
                formato=cb_anio.getValue()+"05";
                break;
            case "Junio":
                formato=cb_anio.getValue()+"06";
                break;
            case "Julio":
                formato=cb_anio.getValue()+"07";
                break;
            case "Agosto":
                formato=cb_anio.getValue()+"08";
                break;
            case "Septiembre":
                formato=cb_anio.getValue()+"09";
                break;
            case "Octubre":
                formato=cb_anio.getValue()+"10";
                break;
            case "Noviembre":
                formato=cb_anio.getValue()+"11";
                break;
            case "Diciembre":
                formato=cb_anio.getValue()+"12";
                break;
        }
        return formato;
    }

    public void click(ActionEvent actionEvent) throws SQLException {
        tb_database.getItems().clear();
        listaProyectos.clear();
        ProyectoDAO lista = new ProyectoDAO();
        listaProyectos.addAll(lista.buscarProyectoPorFechaYCarrera(cb_anio.getValue(),fecha(),cb_carrera.getValue()));
        tb_database.setItems(listaProyectos);
    }
    public void configurarElementosTabla(){
        listaProyectos=FXCollections.observableArrayList();
        this.tf_titulo.setCellValueFactory(new PropertyValueFactory("nombreDeProyecto"));
        this.tf_fecha.setCellValueFactory(new PropertyValueFactory("fechaEnQueSeTitulo"));
        this.tf_director.setCellValueFactory(new PropertyValueFactory("nombreDirector"));
        this.tf_tesista.setCellValueFactory(new PropertyValueFactory("nombreExponente"));
    }

    public void clicRegresar(ActionEvent event) throws IOException {
        Utilidad.regresarMenuPrincipal(event);
    }
}
