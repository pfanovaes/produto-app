package br.com.letscode.produtoapp.modelo.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProdutoFormulario {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public ProdutoFormulario(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        try {
            req.getRequestDispatcher("WEB-INF/produto-form.jsp")
                    .forward(req, resp);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }


    }
}
