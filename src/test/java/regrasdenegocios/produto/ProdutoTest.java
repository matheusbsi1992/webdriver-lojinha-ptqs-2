package regrasdenegocios.produto;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.projeto.web.core.DSL;
import org.projeto.web.pages.ProdutoPage;
import org.projeto.web.util.Util;
import regrasdenegocios.login.LoginTest;

import static regrasdenegocios.login.LoginTest.encerrarComunicacao;
import static regrasdenegocios.login.LoginTest.loginInicializar;

@DisplayName("Classe que deve realizar o processo de validação de teste do Produto")
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoTest //extends LoginTest
    {

    private ProdutoPage produtoPage= new  ProdutoPage();
    private DSL dsl = new DSL();

    @BeforeEach
    public void inicializarProduto(){
        //1--faz o login atraves do LoginTest
        loginInicializar();
        //--espera do Ajax
        Util.sincronismoImplicito();
        //--encerra o tempo de espera

        //identificar botao para direcionar para a pagina de insercao
        produtoPage.botaoAdicionarProduto();
    }


    @Test
    @DisplayName("Identificar a validação de valor zero do produto")
    //@Order(1)
    public void test01IdentificarValorZeroDoProduto(){
        //informar nome do produto
        produtoPage.setProdutoNome("Balarama Melada");
        //informar valor do produto zerado
        produtoPage.setProdutoValor("0.00");
        //informar cores do produto
        produtoPage.setProdutoCores("rosa,amarelo");
        //submeter formulario
        produtoPage.botaoSalvarProduto();

        //--espera do Ajax
        Util.sincronismoImplicito();
        //--encerra o tempo de espera

        //Verifica que o valor e correspondente
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",dsl.mensagemTexto());
    }

    @Test
    @DisplayName("Identificar a validação de valor maior do que Sete Mil Reais do produto")
    //@Order(2)
    public void test02IdentificarValorMaiorDoQueSeteMilDoProduto(){
        //informar nome do produto
        produtoPage.setProdutoNome("Balarama Melada");
        //informar valor do produto zerado
        produtoPage.setProdutoValor("7.000,01");
        //informar cores do produto
        produtoPage.setProdutoCores("rosa,amarelo");
        //submeter formulario
        produtoPage.botaoSalvarProduto();

        //--espera do Ajax
        Util.sincronismoImplicito();
        //--encerra o tempo de espera

        //Verifica que o valor e correspondente
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00",dsl.mensagemTexto());
    }

    @Test
    @DisplayName("Identificar a validação de valor correspondente do produto entre R$ 0,01 e R$ 7.000,00")
    //@Order(3)
    public void test03IdentificarValorEntreUmCentavoESeteMilDoProduto(){
        //informar nome do produto
        produtoPage.setProdutoNome("Balarama Melada Lagartense - 2025");
        //informar valor do produto zerado
        produtoPage.setProdutoValor("115.05");
        //informar cores do produto
        produtoPage.setProdutoCores("rosa,amarelo");
        //submeter formulario
        produtoPage.botaoSalvarProduto();

        //--espera do Ajax
        Util.sincronismoImplicito();
        //--encerra o tempo de espera

        //Verifica que o valor e correspondente
        Assertions.assertEquals("Produto adicionado com sucesso",dsl.mensagemTexto());

        //retorna para a lista de produtos
        //produtoPage.botaoListarProdutos();

    }

        @Test
        @DisplayName("Identificar a validação de valor correspondente do produto com valor limite: R$ 0,01")
        //@Order(3)
        public void test04IdentificarValordeUmCentavoProduto(){
            //informar nome do produto
            produtoPage.setProdutoNome("Balarama Melada Lagartense - 2025");
            //informar valor do produto zerado
            produtoPage.setProdutoValor("0.01");
            //informar cores do produto
            produtoPage.setProdutoCores("rosa,amarelo");
            //submeter formulario
            produtoPage.botaoSalvarProduto();

            //--espera do Ajax
            Util.sincronismoImplicito();
            //--encerra o tempo de espera

            //Verifica que o valor e correspondente
            Assertions.assertEquals("Produto adicionado com sucesso",dsl.mensagemTexto());

            //retorna para a lista de produtos
            //produtoPage.botaoListarProdutos();

        }

        @Test
        @DisplayName("Identificar a validação de valor correspondente do produto com valor limite: R$ 7.000,00")
        //@Order(3)
        public void test05IdentificarValordeSeteMilReaisProduto(){
            //informar nome do produto
            produtoPage.setProdutoNome("Balarama Melada Lagartense - 2025");
            //informar valor do produto zerado
            produtoPage.setProdutoValor("7.000,00");
            //informar cores do produto
            produtoPage.setProdutoCores("rosa,amarelo");
            //submeter formulario
            produtoPage.botaoSalvarProduto();

            //--espera do Ajax
            Util.sincronismoImplicito();
            //--encerra o tempo de espera

            //Verifica que o valor e correspondente
            Assertions.assertEquals("Produto adicionado com sucesso",dsl.mensagemTexto());

            //retorna para a lista de produtos
            //produtoPage.botaoListarProdutos();

        }

    @AfterEach
    public void encerrarComunicao(){
        encerrarComunicacao();
    }

}
