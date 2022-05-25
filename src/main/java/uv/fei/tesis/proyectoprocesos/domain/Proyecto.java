package uv.fei.tesis.proyectoprocesos.domain;


import java.sql.Date;

public class Proyecto {
    int id;
    private String nombreExponente;
    private String nombreDirector;
    private String sinodales;
    private String nombreDeProyecto;
    private String fechaEnQueSeTitulo;
    private String descripcionDelTema;
    int idTipoDeProyecto;
    int idCarrera;

    public Proyecto(String nombreExponente, String nombreDirector, String sinodales, String nombreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema) {
        this.nombreExponente = nombreExponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nombreDeProyecto = nombreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
    }

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

    public Proyecto(String nombreExponente, String nombreDirector, String sinodales, String nombreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema, int idTipoDeProyecto, int idCarrera) {
        this.nombreExponente = nombreExponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nombreDeProyecto = nombreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
        this.idTipoDeProyecto = idTipoDeProyecto;
        this.idCarrera = idCarrera;
    }

    public Proyecto() {
        this.nombreExponente = "";
        this.nombreDirector = "";
        this.sinodales = "";
        this.nombreDeProyecto = "";
        this.fechaEnQueSeTitulo = "";
        this.descripcionDelTema = "";
        this.idTipoDeProyecto = 0;
        this.idCarrera = 0;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proyecto)) return false;

        Proyecto proyecto = (Proyecto) o;

        if (getId() != proyecto.getId()) return false;
        if (getIdTipoDeProyecto() != proyecto.getIdTipoDeProyecto()) return false;
        if (getIdCarrera() != proyecto.getIdCarrera()) return false;
        if (getNombreExponente() != null ? !getNombreExponente().equals(proyecto.getNombreExponente()) : proyecto.getNombreExponente() != null)
            return false;
        if (getNombreDirector() != null ? !getNombreDirector().equals(proyecto.getNombreDirector()) : proyecto.getNombreDirector() != null)
            return false;
        if (getSinodales() != null ? !getSinodales().equals(proyecto.getSinodales()) : proyecto.getSinodales() != null)
            return false;
        if (getNombreDeProyecto() != null ? !getNombreDeProyecto().equals(proyecto.getNombreDeProyecto()) : proyecto.getNombreDeProyecto() != null)
            return false;
        if (getFechaEnQueSeTitulo() != null ? !getFechaEnQueSeTitulo().equals(proyecto.getFechaEnQueSeTitulo()) : proyecto.getFechaEnQueSeTitulo() != null)
            return false;
        return getDescripcionDelTema() != null ? getDescripcionDelTema().equals(proyecto.getDescripcionDelTema()) : proyecto.getDescripcionDelTema() == null;
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
                '}';
    }
}
