package com.text.similarity.project.analysis;

import com.text.similarity.project.comparsion.OverallSimilarityRate;

import java.util.ArrayList;
import java.util.List;

public class SourceFinder {
    private List<OverallSimilarityRate> originalResults;
    private List<OverallSimilarityRate> processedResults;


    public SourceFinder(List<OverallSimilarityRate> originalResults){
        this.originalResults = originalResults;
        this.processedResults = processSimilarityRates();
    }

    private List<OverallSimilarityRate> processSimilarityRates (){
        List<OverallSimilarityRate> list = new ArrayList<OverallSimilarityRate>();
        for(OverallSimilarityRate result : originalResults){
            if(result.computeSimilarityRate() > 0.2){
                list.add(result);
            }
        }



        return list;
    }
}
