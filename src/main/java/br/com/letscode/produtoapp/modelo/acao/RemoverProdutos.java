package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoverProdutos {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public RemoverProdutos(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        String id = req.getParameter("id");
        Integer idComoInteger = Integer.valueOf(id);

        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.removerProduto(idComoInteger);

        try {
            resp.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
