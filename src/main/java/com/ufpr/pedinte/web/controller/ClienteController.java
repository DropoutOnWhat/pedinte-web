package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Cliente;
import com.ufpr.pedinte.web.json.ClienteJSON;
import com.ufpr.pedinte.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 27/09/2020
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping("/")
    public List<ClienteJSON> findAll() {
        List<Cliente> result = new ArrayList<>();
        try {
            result = service.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ClienteJSON.map(result);
    }

    @GetMapping("/{id}")
    public ClienteJSON findById(@PathVariable(value="id") int id) {
        Cliente result = null;
        try {
            result = service.findById(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return ClienteJSON.map(result);
    }

    @PostMapping
    public void createCliente(@RequestBody ClienteJSON json) throws SQLException {
        try {
            Cliente cliente = ClienteJSON.map(json);
            service.create(cliente);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public void updateCliente(@RequestBody ClienteJSON json, @PathVariable(value="id") int id) {
        try {
            Cliente cliente = ClienteJSON.map(json);
            service.update(cliente);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable(value="id") int id) {
        try {
            service.delete(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
