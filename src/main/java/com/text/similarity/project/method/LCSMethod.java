package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;


public class LCSMethod extends Method{

    public LCSMethod(Text text1, Text text2) {
        super(text1, text2);
    }

    @Override
    public double compare() {
        return LCSAlgorithm();
    }

    private double LCSAlgorithm(){
        System.out.println("LCS not working yet");
        return 0.5;
    }
}
