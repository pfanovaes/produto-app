package br.com.letscode.produtoapp.servlet;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;
import br.com.letscode.produtoapp.modelo.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/controladora")
public class Controladora extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        // regra de login

        HttpSession sessao = req.getSession();
        Object usuariologado = sessao.getAttribute("usuariologado");

        List<String> rotasprotegidas = Arrays.asList("produto-form", "cadastrar-produto", "listar-produtos", "remover-produtos", "alterar-produtos");

        boolean eUmaRotaProtegida = rotasprotegidas.contains(acao);

        if(eUmaRotaProtegida && usuariologado == null) {
            resp.sendRedirect("/produto-app/login-form.jsp");
            return;
        }

        switch (acao) {
            case "produto-form":
                ProdutoFormulario produtoFormulario = new ProdutoFormulario(req, resp);
                produtoFormulario.executar();
                break;

            case "cadastrar-produto":
                CadastrarProduto cadastrarProduto = new CadastrarProduto(req, resp);
                cadastrarProduto.executar();
                break;

            case "listar-produtos":

                ListarProdutos listarProdutos = new ListarProdutos(req, resp);
                listarProdutos.executar();

                break;

            case "remover-produtos":
                RemoverProdutos removerProdutos = new RemoverProdutos(req, resp);
                removerProdutos.executar();
                break;

            case "alterar-produtos":
                AlterarProdutos alterarProdutos = new AlterarProdutos(req, resp);
                alterarProdutos.executar();
                break;

            case "login":
                Login login = new Login(req, resp);
                login.executar();
                break;
        }
    }
}
