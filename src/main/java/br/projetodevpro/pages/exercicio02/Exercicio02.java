package br.projetodevpro.pages.exercicio02;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.wicketstuff.annotation.mount.MountPath;

@MountPath("exercicio02")
public class Exercicio02 extends WebPage {
    private static final long serialVersionUID = 1L;

    private String msg = "";

    public Exercicio02() {

        msg = "Digite seu Nome!!";

        final Label labelretorno = new Label("lbRetorno",msg);

        Form form = new Form("form"){
            @Override
            protected void onSubmit() {
                msg = "Seja Bem Vindo Ao Wicket!!!";
                labelretorno.setDefaultModelObject(msg);
            }
        };

        add(labelretorno);
        add(form);
    }

}
