module uv.fei.tesis.proyectoprocesos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    exports uv.fei.tesis.proyectoprocesos.main;
    opens uv.fei.tesis.proyectoprocesos.main to javafx.fxml;
}