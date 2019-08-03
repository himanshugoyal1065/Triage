package com.hackathon.triage.nlp.api;

import opennlp.tools.postag.POSTaggerME;

import java.util.function.Supplier;

/**
 * @author <a href="himanshu.goyal@navis.com">Himanshu Goyal</a>
 */
public interface INlpTaggerSupplier extends Supplier<POSTaggerME> {
}
