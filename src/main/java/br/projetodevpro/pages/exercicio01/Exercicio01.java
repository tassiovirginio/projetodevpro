package br.projetodevpro.pages.exercicio01;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("exercicio01")
public class Exercicio01 extends WebPage {
    private static final long serialVersionUID = 1L;

    public Exercicio01() {

        String mensagem = "Olá Mundo!!!";

        Label labelOlaMundo = new Label("lbMensagem",mensagem);

        add(labelOlaMundo);

    }

}
