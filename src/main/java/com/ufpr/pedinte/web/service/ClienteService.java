package com.ufpr.pedinte.web.service;

import com.ufpr.pedinte.core.model.Cliente;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 05/12/2020
 */

public interface ClienteService {

    List<Cliente> findAll() throws SQLException;

    Cliente findById(int id) throws SQLException;

    boolean create(Cliente cliente) throws SQLException;

    void update(Cliente cliente) throws SQLException;

    void delete(int id) throws SQLException;
}
