package regrasdenegocios.login;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.projeto.web.core.DSL;
import org.projeto.web.pages.LoginPage;

import static org.projeto.web.comunicacao.AcessoComunicacao.getComunicacaoAbertaWeb;
import static org.projeto.web.comunicacao.AcessoComunicacao.getComunicacaoFecharWeb;

@DisplayName("Classe que faz o teste da Pagina de Login")
public class LoginTest {

    private static LoginPage loginPage = new LoginPage();

    private static DSL dsl = new DSL();

    @BeforeAll
    public static void loginInicializar(){
        //--abertura de comunicacao
        getComunicacaoAbertaWeb().get("meu link");
        loginPage.setUsuario("meu usuario");
        loginPage.setSenha("minha senha");
        loginPage.botaoSubmeterLogin();
    }

    @AfterAll
    public  static void encerrarComunicacao(){
        dsl.clicarBotaoLink(By.linkText("Sair"));
        getComunicacaoFecharWeb();
    }


}
