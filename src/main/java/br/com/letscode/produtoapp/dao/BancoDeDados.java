package br.com.letscode.produtoapp.dao;

import br.com.letscode.produtoapp.modelo.Produto;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private static List<Produto> produtos = new ArrayList<>();

    public void salvar(Produto produto) {
        BancoDeDados.produtos.add(produto);
    }

    public List<Produto> listar() {
        return BancoDeDados.produtos;
    }
}
