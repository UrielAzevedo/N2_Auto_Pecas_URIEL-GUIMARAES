package com.pecas.n2_auto_pecas_urielguimaraes;

import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.UnidadeProduto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("OperatorSelection.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);
        stage.setTitle("Operator Selection");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        Produto p1 = new Produto();
        p1.setNome("lanterna Siena");
        p1.setPreco(60);

        p1.adicionarUnidade(new UnidadeProduto(p1));
        p1.adicionarUnidade(new UnidadeProduto(p1));
        p1.adicionarUnidade(new UnidadeProduto(p1));

        OperadorVendas opv1 = new OperadorVendas();

        launch();
    }
}