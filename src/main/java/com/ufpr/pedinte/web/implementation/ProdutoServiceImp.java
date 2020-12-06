package com.ufpr.pedinte.web.implementation;

import com.ufpr.pedinte.core.dao.ProdutoDAO;
import com.ufpr.pedinte.core.model.Produto;
import com.ufpr.pedinte.web.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 11/09/2020
 */

@Service
public class ProdutoServiceImp implements ProdutoService {

    ProdutoDAO dao = new ProdutoDAO();

    public List<Produto> findAll() throws SQLException {
        System.out.println("Buscando todos os Produtos do CORE.");
        return dao.fetchAll();
    }

    public Produto findById(int id) throws SQLException {
        System.out.println("Procurando Produto com ID = " + id + " no CORE.");
        return dao.find(id);
    }

    public boolean create(Produto produto) throws SQLException {
        System.out.println("Criando novo produto no CORE.");
        return dao.createProduto(produto);
    }

    public void update(Produto produto) throws SQLException {
        System.out.println("Atualizando produto com ID = " + produto.getId() + " no CORE.");
        dao.updateProduto(produto);
    }

    public void delete(int id) throws SQLException {
        System.out.println("Removendo produto com ID = " + id + " no CORE.");
        Produto produto = new Produto();
        produto.setId(id);
        dao.removeProduto(produto);
    }
}
