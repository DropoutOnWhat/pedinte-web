package com.ufpr.pedinte.web.service;

import com.ufpr.pedinte.core.model.Pedido;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 05/12/2020
 */

public interface PedidoService {

    List<Pedido> findAll() throws SQLException;

    Pedido findById(int id) throws SQLException;

    void create(Pedido pedido) throws SQLException;

    void update(Pedido pedido) throws SQLException;

    void delete(int id) throws SQLException;


}
