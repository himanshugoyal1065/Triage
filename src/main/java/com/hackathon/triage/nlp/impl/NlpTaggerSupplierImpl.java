package com.hackathon.triage.nlp.impl;

import com.hackathon.triage.nlp.api.INlpTaggerSupplier;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public class NlpTaggerSupplierImpl implements INlpTaggerSupplier {

    private POSTaggerME _posTaggerMe;

    @Override
    public POSTaggerME get() {
        if (_posTaggerMe == null) {
            FileInputStream modelIn = null;
            POSModel posModel = null;
            File f = new File(getFilePath());
            try {
                modelIn = new FileInputStream(f);
            } catch (IOException e) {
                System.out.println("the file couldn't be read " + e);
            }
            try {
                posModel= new POSModel(modelIn);
            } catch (Exception e) {
                System.out.println("POSModel exception " + e);
            }

            POSTaggerME tagger = new POSTaggerME(posModel);
            _posTaggerMe = tagger;
        }
        return _posTaggerMe;
    }

    private String getFilePath() {
        return "C:\\Users\\goyalhi\\Downloads\\hackathons\\triage\\triage\\src\\main\\resources\\static\\en-pos-maxent.bin";
    }
}
