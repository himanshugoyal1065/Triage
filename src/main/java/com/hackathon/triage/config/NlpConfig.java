package com.hackathon.triage.config;

import com.hackathon.triage.nlp.api.INlpTaggerSupplier;
import com.hackathon.triage.nlp.impl.NlpNounProvider;
import com.hackathon.triage.nlp.impl.NlpTaggerSupplierImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class NlpConfig {

    @Bean
    public INlpTaggerSupplier getNlpFileReader() {
        return new NlpTaggerSupplierImpl();
    }

    @Bean
    public NlpNounProvider getNounProvider() {
        return new NlpNounProvider();
    }
}
