package com.ufpr.pedinte.web.json;

import com.ufpr.pedinte.core.model.Cliente;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Regis Gaboardi (@gmail.com)
 * Provided with Love and IntelliJ IDEA for pedinte-spring.
 * 27/09/2020
 */

public class ClienteJSON {

    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public static ResponseJSON map(List<Cliente> clientes) {
        ResponseJSON response = new ResponseJSON();
        if(clientes.isEmpty()) {
            response.setStatus(400);
            response.setMessage("Nenhum Cliente encontrado");
        } else {
            System.out.println("Mapeando resposta do CORE: Cliente para JSON.");
            response.setStatus(200);
            response.setMessage("Clientes encontrados estão no content.");
            List<ClienteJSON> result = new ArrayList<>();
            for(Cliente each : clientes) {
                ClienteJSON json = new ClienteJSON();
                json.setId(each.getId());
                json.setNome(each.getNome());
                json.setSobrenome(each.getSobrenome());
                json.setCpf(each.getCpf());
            }
            response.setContent(result);
        }
        return response;
    }

    public static ResponseJSON map(Cliente cliente) {
        ResponseJSON response = new ResponseJSON();
        if(cliente == null || cliente.getId() == 0) {
            response.setStatus(400);
            response.setMessage("Nenhum Cliente encontrado.");
            System.out.println(response.getMessage());
        } else {
            System.out.println("Mapeando resposta do CORE: Cliente para JSON.");
            response.setStatus(200);
            response.setMessage("Clientes encontrados estão no content.");
            ClienteJSON json = new ClienteJSON();
            json.setId(cliente.getId());
            json.setNome(cliente.getNome());
            json.setSobrenome(cliente.getSobrenome());
            json.setCpf(cliente.getCpf());
        }
        return response;
    }

    public static Cliente map(ClienteJSON json) {
        if(StringUtils.isEmpty(json.getCpf())) {
            System.out.println("Objeto incompleto detectado, cancelando requisição.");
            return null;
        } else {
            System.out.println("Mapeando requisição do CLIENTE: JSON para Cliente.");
            Cliente cliente = new Cliente();
            cliente.setId(json.getId());
            cliente.setCpf(json.getCpf());
            cliente.setNome(json.getNome());
            cliente.setSobrenome(json.getSobrenome());
            return cliente;
        }
    }
}
