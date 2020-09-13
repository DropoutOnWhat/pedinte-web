package com.ufpr.pedintespring.json;


import model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA.
 * 07/09/2020
 */

public class ProdutoJSON {

    int id;
    String descricao;

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
        if(produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado.");
            return null;
        } else {
            List<ProdutoJSON> result = new ArrayList<>();
            for(Produto each : produtos) {
                ProdutoJSON json = new ProdutoJSON();
                json.setId(each.getId());
                json.setDescricao(each.getDescricao());
                result.add(json);
            }
            return result;
        }
    }
}
