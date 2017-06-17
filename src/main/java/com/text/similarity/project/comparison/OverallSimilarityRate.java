package com.text.similarity.project.comparison;

import com.text.similarity.project.text.Text;

import java.util.ArrayList;
import java.util.List;

public class OverallSimilarityRate implements Comparable<OverallSimilarityRate>{

    private List<Double> similarityRateFromAllMethods;
    private Text text1;
    private Text text2;
    private double overallSimilarityRate;

    public String getText1Name(){
        return text1.getFilename();
    }

    public String getText2Name(){
        return text2.getFilename();
    }

    public OverallSimilarityRate(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        similarityRateFromAllMethods = new ArrayList<Double>();
        overallSimilarityRate = -1;

    }

    // simple implementation, returns average rate
    public double computeSimilarityRate() {
        if(overallSimilarityRate < 0) {
            double result = 0;
            for (double singleRate : similarityRateFromAllMethods) {
                if(singleRate > 1.0) singleRate = 1.0;
                result += singleRate;
            }
            overallSimilarityRate = result/similarityRateFromAllMethods.size();
        }
        return overallSimilarityRate;
    }

    public void addSingleRate(double rate) {
        similarityRateFromAllMethods.add(rate);
    }


    public String getRate(){
        return String.valueOf(text1.getFilename()) + " : " + text2.getFilename() +
                " similarity rate = " + String.format("%.4f", computeSimilarityRate());
    }

    @Override
    public int compareTo(OverallSimilarityRate o) {
        return -((Double) overallSimilarityRate).compareTo(o.computeSimilarityRate());
    }
}
