package br.com.letscode.produtoapp.modelo.acao;

import br.com.letscode.produtoapp.dao.BancoDeDados;
import br.com.letscode.produtoapp.modelo.Produto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CadastrarProduto {

    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public CadastrarProduto(HttpServletRequest req, HttpServletResponse resp){
        this.req = req;
        this.resp = resp;
    }

    public void executar() {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String valor = req.getParameter("valor");
        //converter string pra double
        Double valorDouble = Double.valueOf(valor);

        // criar objeto
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valorDouble);

        //salvar no banco
        BancoDeDados bancoDeDados = new BancoDeDados();
        bancoDeDados.salvar(produto);

        try {
            resp.sendRedirect("/produto-app/controladora?acao=listar-produtos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
