package com.example.sisteminformasimtbs.testing;

import java.util.HashMap;

public abstract class Classifier {
    public abstract DiagnosisResult classify(HashMap<String , Integer> collectionOfGejala) ;
}
