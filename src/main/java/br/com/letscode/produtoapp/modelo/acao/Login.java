package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Login(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");



        if (!nome.equals("jorge")) {
            try {
                resp.sendRedirect("/produto-app/login-form.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!senha.equals("1234")) {
            try {
                resp.sendRedirect("/produto-app/login-form.jsp");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Usuario usuario = new Usuario(nome, senha);

        HttpSession sessao = req.getSession();
        sessao.setAttribute("usuariologado", usuario);

        try {
            resp.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
