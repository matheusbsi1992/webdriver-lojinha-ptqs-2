package org.projeto.web.pages;

import org.openqa.selenium.By;
import org.projeto.web.core.DSL;

public class LoginPage {

    private DSL dsl = new DSL();

    public void setUsuario(String usuario){
        dsl.clicarBotaoLink(By.cssSelector("label[for='usuario']"));
        dsl.escrever(By.id("usuario"),usuario);
    }

    public void setSenha(String senha){
        dsl.clicarBotaoLink(By.cssSelector("label[for='senha']"));
        dsl.escrever(By.id("senha"),senha);
    }

    public void botaoSubmeterLogin(){
        dsl.clicarBotaoLink(By.cssSelector("button[type='submit']"));
    }

}
