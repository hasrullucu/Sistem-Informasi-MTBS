package com.example.sisteminformasimtbs.model.classifier;

import com.example.sisteminformasimtbs.model.relation.DiagnosisResult;

import java.util.HashMap;

public abstract class Classifier {
    public abstract DiagnosisResult classify(HashMap<String , Integer> collectionOfGejala) ;
}
