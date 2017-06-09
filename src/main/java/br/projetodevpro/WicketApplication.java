/**
 * Copyright 2015 - Tássio Guerreiro Antunes Virgínio
 *
 * Este arquivo é parte do programa  Reserva de Recursos
 *
 * O Reserva de Recursos é um software livre; você pode redistribui-lo e/ou modifica-lo
 * dentro dos termos da Licença Pública Geral GNU como publicada pela
 * Fundação do Software Livre (FSF); na versão 2 da Licença.
 *
 * Este programa é distribuido na esperança que possa ser util, mas SEM
 * NENHUMA GARANTIA; sem uma garantia implicita de ADEQUAÇÂO a qualquer
 * MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 *
 * Você deve ter recebido uma cópia da Licença Pública Geral GNU, sob o
 * título "licensa_uso.htm", junto com este programa, se não, escreva para a
 * Fundação do Software Livre(FSF) Inc., 51 Franklin St, Fifth Floor,
 */

package br.projetodevpro;

import br.projetodevpro.pages.exercicio01.Exercicio01;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.response.filter.AjaxServerAndClientTimeFilter;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.time.Duration;
import org.springframework.stereotype.Component;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

import java.util.logging.Logger;

@Component
public class WicketApplication extends WebApplication {

    static Logger log = Logger.getLogger(WicketApplication.class.getName());

    @Override
    public Class<Exercicio01> getHomePage() {
        return Exercicio01.class;
    }

    @Override
    public void init() {
        log.info("\n" +
                "********************************************************************\n"+
                "***                      Carregando o Sistema                    ***\n"+
                "********************************************************************");

        getResourceSettings().setResourcePollFrequency(Duration.ONE_SECOND);

        getApplicationSettings().setUploadProgressUpdatesEnabled(true);

        getRequestCycleSettings().addResponseFilter(new AjaxServerAndClientTimeFilter());

        getComponentInstantiationListeners().add(new SpringComponentInjector(this));

        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

        getDebugSettings().setAjaxDebugModeEnabled(false);

        // don't throw exceptions for missing translations
        getResourceSettings().setThrowExceptionOnMissingResource(false);

        // enable ajax debug etc.
        getDebugSettings().setDevelopmentUtilitiesEnabled(true);

        // make markup friendly as in deployment-mode
        getMarkupSettings().setStripWicketTags(true);

        new AnnotatedMountScanner().scanPackage(this.getClass().getPackage().getName()+".pages").mount(this);


    }


}
