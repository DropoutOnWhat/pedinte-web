package com.ufpr.pedinte.web.json;

import com.ufpr.pedinte.core.model.Produto;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 07/09/2020
 */

public class ProdutoJSON {

    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<ProdutoJSON> map(List<Produto> produtos) {
        System.out.println("Mapeando resposta do CORE: Produto para JSON.");
        List<ProdutoJSON> response = new ArrayList<>();
        for(Produto each : produtos) {
           response.add(map(each));
        }
        return response;
    }

    public static ProdutoJSON map(Produto produto) {
        ProdutoJSON response = new ProdutoJSON();
        if (produto != null) {
            response.setId(produto.getId());
            response.setDescricao(produto.getDescricao());
        }
        return response;
    }

    public static Produto map(ProdutoJSON json) {
        if(StringUtils.isEmpty(json.getDescricao())) {
            System.out.println("Objeto incompleto detectado, cancelando requisição.");
            return null;
        } else {
            System.out.println("Mapeando requisição do CLIENTE: JSON para Produto.");
            Produto produto = new Produto();
            produto.setId(json.getId());
            produto.setDescricao(json.getDescricao());
            return produto;
        }
    }
}
