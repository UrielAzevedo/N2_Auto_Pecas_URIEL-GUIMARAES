module com.pecas.n2_auto_pecas_urielguimaraes {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pecas.n2_auto_pecas_urielguimaraes to javafx.fxml;
    exports com.pecas.n2_auto_pecas_urielguimaraes;
    exports com.pecas.n2_auto_pecas_urielguimaraes.GUI;
    opens com.pecas.n2_auto_pecas_urielguimaraes.GUI to javafx.fxml;
}