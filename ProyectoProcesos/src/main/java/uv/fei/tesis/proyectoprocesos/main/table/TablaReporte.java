package uv.fei.tesis.proyectoprocesos.main.table;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.*;

public class TablaReporte {

    private StringProperty titulo;
    private Date fecha;
    private SimpleStringProperty carrera;
    private SimpleStringProperty director;
    private SimpleStringProperty tesista;

    public TablaReporte(String nombreDeProyecto, Date fechaEnQueSeTitulo, String nombreCarrera, String nombreDirector, String nombreExponente) {
        this.titulo= new SimpleStringProperty(nombreDeProyecto);
        this.fecha=fechaEnQueSeTitulo;
        this.carrera =new SimpleStringProperty(nombreCarrera);
        this.director =new SimpleStringProperty(nombreDirector);
        this.tesista =new SimpleStringProperty(nombreExponente);
    }

    public TablaReporte() {
    }

    public static void llenarInf(Connection coneccion, ObservableList<TablaReporte> _lista){
        try {
            for (int i=31; i>0;i--) {
                Statement instruccion = coneccion.createStatement();
                ResultSet resultado = instruccion.executeQuery(
                    "SELECT nombreDeProyecto," +
                    "    fechaEnQueSeTitulo," +
                    "    nombreCarrera,\n" +
                    "    nombreDirector," +
                    "    nombreExponente" +
                    "    FROM proyecto A" +
                    "    INNER JOIN carrera B" +
                    "    ON A.idCarrera = B.id");
                while (resultado.next()) {
                    _lista.add(
                        new TablaReporte(
                            resultado.getString("nombreDeProyecto"),
                            resultado.getDate("fechaEnQueSeTitulo"),
                            resultado.getString("nombreCarrera"),
                            resultado.getString("nombreDirector"),
                            resultado.getString("nombreExponente")
                        )
                    );
                }
            }
        }catch (SQLException e){

        }
    }
    public String getTitulo() {
        return titulo.get();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCarrera() {
        return carrera.get();
    }

    public String getDirector() {
        return director.get();
    }

    public String getTesista() {
        return tesista.get();
    }

    /*
    SELECT A.nombreDeProyecto,
        A.fechaEnQueSeTitulo,
        A.idcarrera,
        A.nombreDirector,
        A.nombreExponente
    FROM proyecto A

    version 2
    SELECT A.nombreDeProyecto,
	A.fechaEnQueSeTitulo,
    A.idcarrera,
    A.nombreDirector,
    A.nombreExponente
FROM proyecto A
INNER JOIN carrera B
ON(A.idcarrera = B.id);

ultima version
    SELECT nombreDeProyecto,
    fechaEnQueSeTitulo,
    nombreCarrera,
    nombreDirector,
    nombreExponente
    FROM proyecto A
    INNER JOIN carrera B
    ON A.idCarrera = B.id
    */
}
