package uv.fei.tesis.proyectoprocesos.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uv.fei.tesis.proyectoprocesos.bussinesslogic.UsuarioDAO;

import java.io.IOException;

public class Login{
    @FXML
    private AnchorPane panel;
    @FXML private TextField txtUsuario;
    @FXML private TextField txtContrseña;


    public void clicIngresar(ActionEvent actionEvent) throws IOException {
        Usuario usuario = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuario.setContrasenia(txtContrseña.getText());
        usuario.setCorreo(txtUsuario.getText());

        if (usuarioDAO.buscarUsuario(usuario)){
            Utilidad.regresarMenuPrincipal(actionEvent);
        }else {
            Utilidad.mostrarAlertaSinConfirmacion("Usuario no encontrado","Inserte un usuario valido", Alert.AlertType.ERROR);
        }


    }
    public void verificarUsuario(){

    }
}
