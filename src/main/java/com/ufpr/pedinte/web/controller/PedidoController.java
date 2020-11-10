package com.ufpr.pedinte.web.controller;

import com.ufpr.pedinte.core.model.Pedido;
import com.ufpr.pedinte.core.model.Produto;
import com.ufpr.pedinte.web.json.PedidoJSON;
import com.ufpr.pedinte.web.json.ProdutoJSON;
import com.ufpr.pedinte.web.json.ResponseJSON;
import com.ufpr.pedinte.web.service.PedidoService;
import com.ufpr.pedinte.web.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    PedidoService pedidoService;

//    @GetMapping("/")
//    public ResponseJSON findAll() {
//        List<Pedido> result = new ArrayList<>();
//        try {
//            pedidoService = new PedidoService();
//            result = pedidoService.findAll();
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        }
//        return PedidoJSON.map(result);
//    }

}
