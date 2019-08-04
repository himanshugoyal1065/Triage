package com.hackathon.triage.nlp;

import com.hackathon.triage.bootstrap.DatabasePolpulator;
import com.hackathon.triage.config.NlpConfig;
import com.hackathon.triage.nlp.api.INlpTaggerSupplier;
import com.hackathon.triage.nlp.impl.NlpNounProvider;
import com.hackathon.triage.nlp.impl.NlpTaggerSupplierImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {NlpConfig.class})
public class NlpNounProviderTestSuite {

    @Autowired
    private INlpTaggerSupplier _nlpTaggerSupplier;

    @MockBean
    private DatabasePolpulator _databasePopulator;

    @Test
    public void testNounsGenerated() {
        NlpNounProvider nlpNounProvider = new NlpNounProvider(_nlpTaggerSupplier);
        List<String> nounsObtained = nlpNounProvider.getNouns("Rewrite N4 JUnit tests which directly access the Emulator code");
        System.out.println("nouns obtained " + nounsObtained);
        assertTrue("the nouns obtained are zero", nounsObtained.size() > 0);
    }
}
