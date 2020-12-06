package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Pedido;
import com.ufpr.pedinte.web.json.PedidoJSON;
import com.ufpr.pedinte.web.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 24/10/2020
 */

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @GetMapping("/")
    public List<PedidoJSON> findAll() {
        List<Pedido> result = new ArrayList<>();
        try {
            result = service.findAll();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return PedidoJSON.map(result);
    }

    @GetMapping("/{id}")
    public PedidoJSON findById(@PathVariable(value = "id") int id) {
        Pedido result = new Pedido();
        try {
            result = service.findById(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return PedidoJSON.map(result);
    }

    @PostMapping
    public void createPedido(@RequestBody PedidoJSON json) throws SQLException {
        try {
            Pedido pedido = PedidoJSON.map(json);
            service.create(pedido);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public void updatePedido(@RequestBody PedidoJSON json, @PathVariable(value="id") int id) throws SQLException {
        try {
            Pedido pedido = PedidoJSON.map(json);
            service.update(pedido);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable(value = "id") int id) {
        try {
            service.delete(id);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
