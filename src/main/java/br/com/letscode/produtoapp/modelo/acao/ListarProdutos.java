package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListarProdutos {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public ListarProdutos(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        BancoDeDados bd = new BancoDeDados();
        List<Produto> produtos = bd.listar();

        req.setAttribute("produtos", produtos);
        try {
            req.getRequestDispatcher("WEB-INF/listar-produtos.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();

        }
    }
}
