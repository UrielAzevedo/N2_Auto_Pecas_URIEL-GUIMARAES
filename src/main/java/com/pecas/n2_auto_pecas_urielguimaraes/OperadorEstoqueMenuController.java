package com.pecas.n2_auto_pecas_urielguimaraes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OperadorEstoqueMenuController {

    @FXML
    private Button BtnProdutos;

    public void BtnProdutosOnAction() throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuCadastroProduto.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Cadastro Produto");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }
    }

    @FXML
    private Button BtnFornecedors;

    public void BtnFornecedorsOnAction() throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuCadastroFornecedor.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Cadastro Fornecedor");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }
    }

    @FXML
    private Button BtnOperadores;

    public void BtnOperadoresOnAction() throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuCadastroOperadores.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Operadores");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }
    }

    @FXML
    private Button BtnComprarProdutos;

    public void BtnComprarProdutosOnAction() throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("com/pecas/n2_auto_pecas_urielguimaraes/GerenciarOperadoresMenu.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Operadores");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }
    }

    @FXML
    private Button BtnRelatorioVendas;

    public void BtnRelatorioVendasOnAction() throws Exception{
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GerenciarOperadoresMenu.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Menu Operadores");
            stage.setScene(new Scene(rootOne));
            stage.show();
        } catch (Exception e){
            System.out.print(e);
        }
    }

}
