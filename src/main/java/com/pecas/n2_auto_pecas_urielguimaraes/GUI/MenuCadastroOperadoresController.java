package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoOperadoresVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuCadastroOperadoresController implements Initializable {

    private boolean OperadorEstoque;
    private final DaoOperadorEstoque operadoresEstoqueDAO= new DaoOperadorEstoque();
    private final DaoOperadoresVendas operadoresVendasDao = new DaoOperadoresVendas();

    @FXML
    private ToggleButton TglBtnOperadorEstoque;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnExcluir;

    @FXML
    private ListView<OperadorEstoque> LstViewOperadorEstoque;

    @FXML
    private ListView<OperadorVendas> LstViewOperadorVendas;

    @FXML
    private TextField TxtNome;

    public void TglBtnOperadorEstoqueOnAction () {
        OperadorEstoque = TglBtnOperadorEstoque.isSelected();
    }

    public void BtnAdicionarOnAction () {

        if (TxtNome.getText().equals("")){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        if(OperadorEstoque){

            OperadorEstoque operadorEstoque = new OperadorEstoque();
            operadorEstoque.setNome(TxtNome.getText());

            try{
                operadoresEstoqueDAO.gravar(operadorEstoque);
            } catch (Exception e){
                e.printStackTrace();
            }

            atualizarLista();

        } else {
            OperadorVendas operadorVendas = new OperadorVendas();
            operadorVendas.setNome(TxtNome.getText());

            try{
                operadoresVendasDao.gravar(operadorVendas);
            } catch (Exception e){
                e.printStackTrace();
            }

            atualizarLista();
        }
    }

    public void BtnExcluirOnAction () {

        OperadorEstoque operadorEstoque = LstViewOperadorEstoque.getSelectionModel().getSelectedItem();
        OperadorVendas operadorVendas = LstViewOperadorVendas.getSelectionModel().getSelectedItem();

        if (operadorEstoque == null && operadorVendas == null) {
            return;
        }

        if (operadorEstoque != null) {
            try {
                operadoresEstoqueDAO.excluir(operadorEstoque);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (operadorVendas != null) {
            try {
                operadoresVendasDao.excluir(operadorVendas);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        atualizarLista();
    }

    private void atualizarLista() {
        List<OperadorEstoque> operadoresEstoque = null;
        List<OperadorVendas> operadoresVendas = null;

        try {
            operadoresEstoque = operadoresEstoqueDAO.listar();
            operadoresVendas = operadoresVendasDao.listar();
        } catch (Exception e){
            operadoresEstoque = new ArrayList<>();
            operadoresVendas = new ArrayList<>();
        }

        ObservableList<OperadorEstoque> operadoresEstoqueObv = FXCollections.observableList(operadoresEstoque);
        LstViewOperadorEstoque.setItems(operadoresEstoqueObv);

        ObservableList<OperadorVendas> operadoresVendasObv = FXCollections.observableList(operadoresVendas);
        LstViewOperadorVendas.setItems(operadoresVendasObv);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        atualizarLista();
    }
}
