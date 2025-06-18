package org.projeto.web.pages;

import org.openqa.selenium.By;
import org.projeto.web.core.DSL;

public class ProdutoPage {

    private DSL dsl = new DSL();

    public void setProdutoNome(String produtoNome){
        dsl.escrever(By.id("produtonome"),produtoNome);
    }

    public void setProdutoValor(String produtoValor){
        dsl.escrever(By.id("produtovalor"),produtoValor);
    }

    public void setProdutoCores(String produtoCores){
        dsl.escrever(By.id("produtocores"),produtoCores);
    }

    public void botaoAdicionarProduto(){
        dsl.clicarBotaoLink(By.linkText("ADICIONAR PRODUTO"));
    }

    public void botaoSalvarProduto(){
        dsl.clicarBotaoLink(By.cssSelector("button[type='submit']"));
    }

    public void botaoListarProdutos(){
        dsl.clicarBotaoLink(By.linkText("LISTA DE PRODUTOS"));
    }


}
