package com.hackathon.triage.nlp.impl;

import com.hackathon.triage.nlp.api.INlpTaggerSupplier;
import opennlp.tools.postag.POSTaggerME;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class NlpNounProvider {

    @Autowired
    private INlpTaggerSupplier _nlpTaggerSupplier;

    public NlpNounProvider() {
    }

    public NlpNounProvider(INlpTaggerSupplier inINlpTaggerSupplier) {
        _nlpTaggerSupplier = inINlpTaggerSupplier;
    }

    public List<String> getNouns(String inSentence) {
        List<String> nouns = new ArrayList<>();
        POSTaggerME posTaggerME = _nlpTaggerSupplier.get();
        String tokens[] = inSentence.split(" ");
        String tagged[] = posTaggerME.tag(tokens);
        for (int i = 0; i < tagged.length; i++) {
            if (tagged[i].equalsIgnoreCase("nnp") || tagged[i].equalsIgnoreCase("nnps")) {
                nouns.add(tokens[i]);
            }
        }
        return nouns;
    }
}
