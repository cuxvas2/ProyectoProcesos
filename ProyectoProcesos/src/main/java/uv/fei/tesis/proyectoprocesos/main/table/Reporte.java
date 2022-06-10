package uv.fei.tesis.proyectoprocesos.main.table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import uv.fei.tesis.proyectoprocesos.main.ReporteMensual;

import java.sql.*;

public class Reporte extends TablaReporte {
    private StringProperty titulo;
    private Date fecha;
    private SimpleStringProperty carrera;
    private SimpleStringProperty director;
    private SimpleStringProperty tesista;
    private ReporteMensual rep;

    public Reporte(String nombreDeProyecto, Date fechaEnQueSeTitulo, String nombreCarrera, String nombreDirector, String nombreExponente) {
        this.titulo= new SimpleStringProperty(nombreDeProyecto);
        this.fecha=fechaEnQueSeTitulo;
        this.carrera =new SimpleStringProperty(nombreCarrera);
        this.director =new SimpleStringProperty(nombreDirector);
        this.tesista =new SimpleStringProperty(nombreExponente);
    }

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


}
