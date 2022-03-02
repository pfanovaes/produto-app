package br.com.letscode.produtoapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/controladora")
public class AutorizacaoFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        // regra de login

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String acao = req.getParameter("acao");

        HttpSession sessao = req.getSession();
        Object usuariologado = sessao.getAttribute("usuariologado");

        List<String> rotasprotegidas = Arrays.asList("produto-form", "cadastrar-produto", "listar-produtos", "remover-produtos", "alterar-produtos");

        boolean eUmaRotaProtegida = rotasprotegidas.contains(acao);

        if(eUmaRotaProtegida && usuariologado == null) {
            resp.sendRedirect("/produto-app/login-form.jsp");
            return;
        }

        chain.doFilter(servletRequest, servletResponse);
    }
}
