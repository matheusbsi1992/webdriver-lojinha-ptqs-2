package org.projeto.web.core;

import org.openqa.selenium.By;
import org.projeto.web.comunicacao.AcessoComunicacao;

import static org.projeto.web.comunicacao.AcessoComunicacao.getComunicacaoAbertaWeb;

public class DSL {


    public void escrever(By by,String texto){
        getComunicacaoAbertaWeb()
                .findElement(by)
                .sendKeys(texto);
    }

    public void clicarBotaoLink(By by){
        getComunicacaoAbertaWeb()
                .findElement(by)
                .click();
    }

    public String mensagemTexto(){
        return getComunicacaoAbertaWeb()
                //.findElement(By.xpath("//div//div[.='O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00']"))
                .findElement(By.cssSelector(".toast.rounded"))
                .getText();
    }
}
