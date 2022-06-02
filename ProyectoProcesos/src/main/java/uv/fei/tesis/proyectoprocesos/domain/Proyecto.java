package uv.fei.tesis.proyectoprocesos.domain;

public class Proyecto {
    int id;
    private String nombreEsponente;
    private String nombreDirector;
    private String sinodales;
    private String nomnreDeProyecto;
    private String fechaEnQueSeTitulo;
    private String descripcionDelTema;
    int idTipoDeProyecto;
    int idCarrera;

    public Proyecto(String nombreEsponente, String nombreDirector, String sinodales, String nomnreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema) {
        this.nombreEsponente = nombreEsponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nomnreDeProyecto = nomnreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
    }

    public Proyecto(int id, String nombreEsponente, String nombreDirector, String sinodales, String nomnreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema, int idTipoDeProyecto, int idCarrera) {
        this.id = id;
        this.nombreEsponente = nombreEsponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nomnreDeProyecto = nomnreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
        this.idTipoDeProyecto = idTipoDeProyecto;
        this.idCarrera = idCarrera;
    }

    public Proyecto(String nombreEsponente, String nombreDirector, String sinodales, String nomnreDeProyecto, String fechaEnQueSeTitulo, String descripcionDelTema, int idTipoDeProyecto, int idCarrera) {
        this.nombreEsponente = nombreEsponente;
        this.nombreDirector = nombreDirector;
        this.sinodales = sinodales;
        this.nomnreDeProyecto = nomnreDeProyecto;
        this.fechaEnQueSeTitulo = fechaEnQueSeTitulo;
        this.descripcionDelTema = descripcionDelTema;
        this.idTipoDeProyecto = idTipoDeProyecto;
        this.idCarrera = idCarrera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEsponente() {
        return nombreEsponente;
    }

    public void setNombreEsponente(String nombreEsponente) {
        this.nombreEsponente = nombreEsponente;
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

    public String getNomnreDeProyecto() {
        return nomnreDeProyecto;
    }

    public void setNomnreDeProyecto(String nomnreDeProyecto) {
        this.nomnreDeProyecto = nomnreDeProyecto;
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
        if (getNombreEsponente() != null ? !getNombreEsponente().equals(proyecto.getNombreEsponente()) : proyecto.getNombreEsponente() != null)
            return false;
        if (getNombreDirector() != null ? !getNombreDirector().equals(proyecto.getNombreDirector()) : proyecto.getNombreDirector() != null)
            return false;
        if (getSinodales() != null ? !getSinodales().equals(proyecto.getSinodales()) : proyecto.getSinodales() != null)
            return false;
        if (getNomnreDeProyecto() != null ? !getNomnreDeProyecto().equals(proyecto.getNomnreDeProyecto()) : proyecto.getNomnreDeProyecto() != null)
            return false;
        if (getFechaEnQueSeTitulo() != null ? !getFechaEnQueSeTitulo().equals(proyecto.getFechaEnQueSeTitulo()) : proyecto.getFechaEnQueSeTitulo() != null)
            return false;
        return getDescripcionDelTema() != null ? getDescripcionDelTema().equals(proyecto.getDescripcionDelTema()) : proyecto.getDescripcionDelTema() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getNombreEsponente() != null ? getNombreEsponente().hashCode() : 0);
        result = 31 * result + (getNombreDirector() != null ? getNombreDirector().hashCode() : 0);
        result = 31 * result + (getSinodales() != null ? getSinodales().hashCode() : 0);
        result = 31 * result + (getNomnreDeProyecto() != null ? getNomnreDeProyecto().hashCode() : 0);
        result = 31 * result + (getFechaEnQueSeTitulo() != null ? getFechaEnQueSeTitulo().hashCode() : 0);
        result = 31 * result + (getDescripcionDelTema() != null ? getDescripcionDelTema().hashCode() : 0);
        result = 31 * result + getIdTipoDeProyecto();
        result = 31 * result + getIdCarrera();
        return result;
    }

    @Override
    public String toString() {
        return "Proyecto{" +
                "id=" + id +
                ", nombreEsponente='" + nombreEsponente + '\'' +
                ", nombreDirector='" + nombreDirector + '\'' +
                ", sinodales='" + sinodales + '\'' +
                ", nomnreDeProyecto='" + nomnreDeProyecto + '\'' +
                ", fechaEnQueSeTitulo='" + fechaEnQueSeTitulo + '\'' +
                ", descripcionDelTema='" + descripcionDelTema + '\'' +
                ", idTipoDeProyecto=" + idTipoDeProyecto +
                ", idCarrera=" + idCarrera +
                '}';
    }
}
