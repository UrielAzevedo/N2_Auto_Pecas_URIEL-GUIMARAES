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
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

public class MenuCadastroProdutoController implements Initializable {

    DaoProduto daoProduto = new DaoProduto();
    DaoFornecedor daoFornecedor = new DaoFornecedor();

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtPreco;

    @FXML
    private TextField TxtUnidades;

    @FXML
    private ComboBox<Fornecedor> CboxFornecedor;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnExcluir;

    @FXML
    private ListView<Produto> LstViewProdutos;

    public void BtnAdicionarOnAction () {
        if (TxtNome.getText().equals("") || TxtPreco.getText().equals("")){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        try{
            Double.parseDouble(TxtPreco.getText());
            Integer.parseInt(TxtUnidades.getText());
        } catch (Exception e){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.show();
            return;
        }

        Produto produto = new Produto();

        produto.setPreco(Double.parseDouble(TxtPreco.getText()));
        produto.setNome(TxtNome.getText());
        produto.adicionarUnidades(Integer.parseInt(TxtUnidades.getText()), produto);

        try{
            daoProduto.gravar(produto);
        } catch (Exception e){
            e.printStackTrace();
        }

        atualizarLista();
    }

    public void BtnExcluirOnAction() {

        Produto produto = LstViewProdutos.getSelectionModel().getSelectedItem();

        if(produto == null) return;

        try{
            daoProduto.excluir(produto);
        } catch (Exception e){
            e.printStackTrace();
        }

        atualizarLista();
    }

    public void atualizarLista () {
        List<Produto> produtos = null;

        try{
            produtos = daoProduto.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Produto> produtosObv = FXCollections.observableArrayList(produtos);
        LstViewProdutos.setItems(produtosObv);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Fornecedor> fornecedores = null;

        try{
            fornecedores = daoFornecedor.listar();
        } catch (Exception e){
            e.printStackTrace();
        }

        ObservableList<Fornecedor> listFornecedores = FXCollections.observableArrayList(fornecedores);
        CboxFornecedor.setItems(listFornecedores);

        atualizarLista();

    }
}
