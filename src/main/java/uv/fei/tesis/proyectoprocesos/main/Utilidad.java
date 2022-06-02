package uv.fei.tesis.proyectoprocesos.main;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class Utilidad {
    public static void pasarValoresEntreVentanas(Object object, String direccionFxml, String tituloDeLaVentana, ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
        URL url = Paths.get(direccionFxml).toUri().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Scene scene = new Scene(fxmlLoader.load(url ), 600, 400);
        stage.setUserData(object);
        stage.setTitle(tituloDeLaVentana);
        stage.setScene(scene);
        stage.show();
    }
    public static void regresarMenuPrincipal(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MenuPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 870, 530);
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }
    public static void abrirVentana(ActionEvent event, String fxml, String titulo) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();

    }
    public static void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    public static void mensajeErrorAlCargarLaInformacionDeLaVentana(){
        Utilidad.mostrarAlertaSinConfirmacion("Error de sistema", "Hubo un error "
                + "al cargar la información. Por favor, inténtelo más tarde", Alert.AlertType.ERROR);
    }
    public static void mostrarAlertaSinConfirmacion(String titulo, String mensaje, Alert.AlertType tipoAlerta){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
