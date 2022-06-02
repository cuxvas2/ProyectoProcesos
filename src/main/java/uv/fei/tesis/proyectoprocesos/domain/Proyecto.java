package uv.fei.tesis.proyectoprocesos.domain;

import javafx.collections.ObservableArray;

public class Proyecto{
    private int id;
    private String nombreExponente;
    private String nombreDirector;
    private String sinodales;
    private String nombreDeProyecto;
    private String fechaEnQueSeTitulo;
    private String descripcionDelTema;
    private int idTipoDeProyecto;
    private int idCarrera;
    private String tipoProyecto;
    private String carrera;


    public Proyecto(int id, String nombreExponente, String nombreDirector, String sinodales, String nombreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema, int idTipoDeProyecto, int idCarrera) {
        this.id = id;
        this.nombreExponente = nombreExponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nombreDeProyecto = nombreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
        this.idTipoDeProyecto = idTipoDeProyecto;
        this.idCarrera = idCarrera;
    }

    public Proyecto(String nombreExponente, String nombreDirector, String sinodales, String nombreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema) {
        this.nombreExponente = nombreExponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nombreDeProyecto = nombreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
    }

    public Proyecto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreExponente() {
        return nombreExponente;
    }

    public void setNombreExponente(String nombreExponente) {
        this.nombreExponente = nombreExponente;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public String getSinodales() {
        return sinodales;
    }

    public void setSinodales(String sinodales) {
        this.sinodales = sinodales;
    }

    public String getNombreDeProyecto() {
        return nombreDeProyecto;
    }

    public void setNombreDeProyecto(String nombreDeProyecto) {
        this.nombreDeProyecto = nombreDeProyecto;
    }

    public String getFechaEnQueSeTitulo() {
        return fechaEnQueSeTitulo;
    }

    public void setFechaEnQueSeTitulo(String fechaEnQueSeTitulo) {
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
    }

    public String getDescripcionDelTema() {
        return descripcionDelTema;
    }

    public void setDescripcionDelTema(String descripcionDelTema) {
        this.descripcionDelTema = descripcionDelTema;
    }

    public int getIdTipoDeProyecto() {
        return idTipoDeProyecto;
    }

    public void setIdTipoDeProyecto(int idTipoDeProyecto) {
        this.idTipoDeProyecto = idTipoDeProyecto;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombreExponente='" + nombreExponente + '\'' +
                ", nombreDirector='" + nombreDirector + '\'' +
                ", sinodales='" + sinodales + '\'' +
                ", nombreDeProyecto='" + nombreDeProyecto + '\'' +
                ", fechaEnQueSeTitulo='" + fechaEnQueSeTitulo + '\'' +
                ", descripcionDelTema='" + descripcionDelTema + '\'' +
                ", idTipoDeProyecto=" + idTipoDeProyecto +
                ", idCarrera=" + idCarrera +
                ", tipoProyecto='" + tipoProyecto + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
