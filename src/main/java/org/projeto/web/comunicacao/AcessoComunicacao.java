package org.projeto.web.comunicacao;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

public class AcessoComunicacao {

    private static WebDriver webDriver;


    private static ChromeOptions opcaoDriverChrome() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("127");// version stable
        chromeOptions.addArguments("start-maximized"); // open Browser in maximized mode
        chromeOptions.addArguments("disable-infobars"); // disabling infobars
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--disable-gpu"); // applicable to windows os only
        chromeOptions.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        chromeOptions.addArguments("--no-sandbox"); // Bypass OS security model
        chromeOptions.addArguments("--allowed-ips");
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));

        return chromeOptions;
    }

    public static WebDriver getComunicacaoAbertaWeb(){
        if(webDriver==null){
            webDriver = new ChromeDriver(opcaoDriverChrome());
        }
        return webDriver;
    }

    public static void getComunicacaoFecharWeb(){
        if(webDriver!=null){
            webDriver.quit();
        }
        webDriver=null;
    }

}
