package com.text.similarity.project.comparsion;

import com.text.similarity.project.text.Text;

import java.util.ArrayList;
import java.util.List;

public class OverallSimilarityRate  {

    private List<Double> similarityRateFromAllMethods;
    private Text text1;
    private Text text2;
    private double overallSimilarityRate;

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
                result += singleRate;
            }
            overallSimilarityRate = result/similarityRateFromAllMethods.size();
        }
        return overallSimilarityRate;
    }

    public void addSingleRate(double rate) {
        similarityRateFromAllMethods.add(rate);
    }

    public String getSingleRate(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text1.getId());
        stringBuilder.append(" : ");
        stringBuilder.append(text2.getId());
        stringBuilder.append(" similarity Rate = ");
        stringBuilder.append(computeSimilarityRate());

        return stringBuilder.toString();
    }
}
