package uv.fei.tesis.proyectoprocesos.main;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import uv.fei.tesis.proyectoprocesos.dataaccess.DataBaseConnection;
import uv.fei.tesis.proyectoprocesos.main.table.Reporte;
import uv.fei.tesis.proyectoprocesos.main.table.TablaReporte;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class ReporteMensual implements Initializable {
    public Button bt_Buscar;
    public ComboBox<String> cb_mes;
    public ComboBox<String> cb_anio;
    public ComboBox<String> cb_carrera;
    public TableView tb_database;

    private TextField _tf_titulo;
    private TextField _tf_fecha;
    private TextField _tf_carrera;
    private TextField _tf_director;
    private TextField _tf_tesista;

    public TableView<TablaReporte> table_reporte;
    public TableColumn tf_titulo;
    public TableColumn tf_fecha;
    public TableColumn tf_carrera;
    public TableColumn tf_director;
    public TableColumn tf_tesista;

    DataBaseConnection coneccion1;
    ObservableList<TablaReporte> tableReporte;


    //-----------------------------------------------------------------------------
    private StringProperty titulo;
    private Date fecha;
    private StringProperty carrera;
    private StringProperty director;
    private StringProperty tesista;
    //Getters
    public String getTitulo(){return titulo.get();}
    public Date getFecha(){return fecha;}
    public String getCarrera(){return carrera.get();}
    public String getDirector(){return director.get();}
    public String getTesista(){return tesista.get();}
    //Setters
    public void setTitulo(String titulo){this.titulo= new SimpleStringProperty(titulo);}
    public void setFecha(Date fecha){this.fecha=fecha;}
    public void setCarrera(String carrera){this.carrera= new SimpleStringProperty(carrera);}
    public void setDirector(String director){this.director= new SimpleStringProperty(director);}
    public void setTesista(String tesista){this.tesista= new SimpleStringProperty(tesista);}


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
    public String fecha(int dia){
        String formato = null;
        switch (cb_mes.getValue()){
            case "Enero":
                formato=cb_anio.getValue()+"-01";
                break;
            case "Febrero":
                formato=cb_anio.getValue()+"-02";
                break;
            case "Marzo":
                formato=cb_anio.getValue()+"-03";
                break;
            case "Abril":
                formato=cb_anio.getValue()+"-04";
                break;
            case "Mayo":
                formato=cb_anio.getValue()+"-05";
                break;
            case "Junio":
                formato=cb_anio.getValue()+"-06";
                break;
            case "Julio":
                formato=cb_anio.getValue()+"-07";
                break;
            case "Agosto":
                formato=cb_anio.getValue()+"-08";
                break;
            case "Septiembre":
                formato=cb_anio.getValue()+"-09";
                break;
            case "Octubre":
                formato=cb_anio.getValue()+"-10";
                break;
            case "Noviembre":
                formato=cb_anio.getValue()+"-11";
                break;
            case "Diciembre":
                formato=cb_anio.getValue()+"-12";
                break;
        }
        if (dia <10){
            formato=formato+"-0"+dia;
        }else {
            formato=formato+"-"+dia;
        }
        return formato;
    }

    public void click(ActionEvent actionEvent) throws SQLException {
        tableReporte= FXCollections.observableArrayList();
        ReporteMensual.LlenarInf(coneccion1.getConnection(),tableReporte);
    }

    public static void LlenarInf(Connection coneccion,
                                 ObservableList<TablaReporte> lista) {
        ReporteMensual rep1=null;
        try {
            Statement statement=coneccion.createStatement();
            for (int i=31; i>0;i--) {
                ResultSet resultado = statement.executeQuery(
                        "SELECT nombreDeProyecto, " +
                                "    fechaEnQueSeTitulo, " +
                                "    nombreCarrera, " +
                                "    nombreDirector, " +
                                "    nombreExponente " +
                                "FROM proyecto A " +
                                "Where nombreCarrera = '" + rep1.cb_carrera.getValue() + "'" +
                                "    fechaEnQueSeTitulo = '" + rep1.fecha(i) + "'"
                );
                while (resultado.next()){
                    lista.add( new Reporte(
                        resultado.getString("nombreDeProyecto"),
                        resultado.getDate("fechaEnQueSeTitulo"),
                        resultado.getString("nombreCarrera"),
                        resultado.getString("nombreDirector"),
                        resultado.getString("nombreExponente")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
