package com.pecas.n2_auto_pecas_urielguimaraes.GUI;

import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoFornecedor;
import com.pecas.n2_auto_pecas_urielguimaraes.DAO.DaoProduto;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Fornecedor;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorEstoque;
import com.pecas.n2_auto_pecas_urielguimaraes.model.OperadorVendas;
import com.pecas.n2_auto_pecas_urielguimaraes.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuCadastroFornecedorController implements Initializable {

    DaoFornecedor fornecedorDao = new DaoFornecedor();
    DaoProduto produtoDao = new DaoProduto();

    @FXML
    public TextField TxtNome;

    @FXML
    public ComboBox<Produto> CboxProduto;

    @FXML
    public Button BtnAdicionar;

    @FXML
    public Button BtnExcluir;

    @FXML
    public ListView<Fornecedor> LstViewFornecedores;

    public void BtnAdicionarOnAction () {

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(TxtNome.getText());
        fornecedor.adicionarProdutoFornecido(CboxProduto.getValue());

        if (TxtNome.getText().equals("")){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        try {
            fornecedorDao.gravar(fornecedor);
        } catch (Exception e) {
            e.printStackTrace();
        }

        atualizarLista();
    }

    public void BtnExcluirOnAction () {
        Fornecedor fornecedor = LstViewFornecedores.getSelectionModel().getSelectedItem();

        try{
            fornecedorDao.excluir(fornecedor);
        } catch (Exception e){
            e.printStackTrace();
        }

        atualizarLista();
    }

    public void atualizarLista () {
        List<Fornecedor> fornecedors = null;

        try{
            fornecedors = fornecedorDao.listar();
        } catch (Exception e){
            fornecedors = new ArrayList<>();
        }

        ObservableList<Fornecedor> fornecedoresObv = FXCollections.observableArrayList(fornecedors);
        LstViewFornecedores.setItems(fornecedoresObv);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Produto> produtos = null;

        try{
            produtos = produtoDao.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Produto> listProdutos = FXCollections.observableArrayList(produtos);
        CboxProduto.setItems(listProdutos);

        atualizarLista ();
    }
}
