package uv.fei.tesis.proyectoprocesos.main;

import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuPrincipal {
    public void clicRegistrarProyecto(ActionEvent actionEvent) throws IOException {
        Utilidad.abrirVentana(actionEvent,"RegistarProyecto.fxml","Registrar proyecto");

    }

    public void clicDetallesDeProyecto(ActionEvent actionEvent) throws IOException {
        Utilidad.abrirVentana(actionEvent,"GUIDetalleDeProyecto.fxml","Detalle proyecto");

    }

    public void clicReporteMensualProyecto(ActionEvent actionEvent) throws IOException {
        Utilidad.abrirVentana(actionEvent,"ReporteMensual.fxml","Reporte mensual");

    }
}
