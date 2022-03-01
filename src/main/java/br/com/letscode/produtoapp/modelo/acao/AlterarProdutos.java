package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AlterarProdutos {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public AlterarProdutos(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        String id = req.getParameter("id");
        Integer idComoInteiro = Integer.valueOf(id);

        BancoDeDados bancoDeDados = new BancoDeDados();
        Produto produto = bancoDeDados.buscarPorId(idComoInteiro);

        req.setAttribute("produto", produto);

        try {
            req.getRequestDispatcher("WEB_INF/produto-form.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}