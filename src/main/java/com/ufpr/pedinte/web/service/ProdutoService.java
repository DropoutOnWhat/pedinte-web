package com.ufpr.pedinte.web.service;

import com.ufpr.pedinte.core.model.Produto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 05/12/2020
 */

public interface ProdutoService {
    List<Produto> findAll() throws SQLException;

    Produto findById(int id) throws SQLException;

    boolean create(Produto produto) throws SQLException;

    void update(Produto produto) throws SQLException;

    void delete(int id) throws SQLException;
}
