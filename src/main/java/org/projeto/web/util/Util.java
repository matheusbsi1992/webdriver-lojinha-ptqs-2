package org.projeto.web.util;

import org.projeto.web.comunicacao.AcessoComunicacao;

import java.time.Duration;

public class Util {

    public static void sincronismoImplicito(){
        AcessoComunicacao.getComunicacaoAbertaWeb()
                .manage()
                .timeouts()
                .implicitlyWait(Duration.ofMillis(5000));
    }
}
