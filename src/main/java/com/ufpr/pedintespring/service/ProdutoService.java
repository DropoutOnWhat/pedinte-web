package com.ufpr.pedintespring.service;

import dao.ProdutoDAO;
import model.Produto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 11/09/2020
 */

@Service
public class ProdutoService {

    ProdutoDAO dao = new ProdutoDAO();

    public List<Produto> findAll() throws SQLException {
        return dao.fetchAll();
    }
}
