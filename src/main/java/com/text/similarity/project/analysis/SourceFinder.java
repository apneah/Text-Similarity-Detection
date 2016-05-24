package com.text.similarity.project.analysis;

import com.text.similarity.project.comparison.OverallSimilarityRate;

import java.util.*;

public class SourceFinder {
    private List<OverallSimilarityRate> originalResults;
    private List<OverallSimilarityRate> processedResults;
    private Set<String> resultsIds;
    private List<PossibleSource> possibleSourceList;
    private static double minimumRate = 0.65;


    public SourceFinder(List<OverallSimilarityRate> originalResults){
        this.originalResults = originalResults;
        this.resultsIds = new HashSet<>();
        this.processedResults = processSimilarityRates();
        this.possibleSourceList = getPossibleSources();
    }

    private List<OverallSimilarityRate> processSimilarityRates (){

        List<OverallSimilarityRate> list = new ArrayList<>();
        for(OverallSimilarityRate result : originalResults){
            if(result.computeSimilarityRate() > minimumRate){
                list.add(result);
                if(!resultsIds.contains(result.getText1Name())){
                    resultsIds.add(result.getText1Name());
                }
                if(!resultsIds.contains(result.getText2Name())){
                    resultsIds.add(result.getText2Name());
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public List<OverallSimilarityRate> resultsWithId(String textName){
        List<OverallSimilarityRate> result = new ArrayList<>();
        for(OverallSimilarityRate o : processedResults){
            if(o.getText1Name().equals(textName) || o.getText2Name().equals(textName)){
                result.add(o);
            }
        }
        return result;
    }

    public String getProcessedString(){
        StringBuilder stringBuilder = new StringBuilder();

        for(OverallSimilarityRate result : processedResults) {
            stringBuilder.append(result.getRate());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<PossibleSource> getPossibleSources(){
        List<PossibleSource> possibleSourceList = new ArrayList<>();
        for(String textName : resultsIds){

            PossibleSource possibleSource = new PossibleSource(textName);
            List<OverallSimilarityRate> rates = resultsWithId(textName);
            for(OverallSimilarityRate rate : rates){
                String anotherId;
                if(!rate.getText1Name().equals(textName)){
                    anotherId = rate.getText1Name();
                }
                else{
                    anotherId = rate.getText2Name();
                }
                possibleSource.add(anotherId, rate.computeSimilarityRate());
            }

            possibleSourceList.add(possibleSource);
        }
        Collections.sort(possibleSourceList);
        return possibleSourceList;
    }

    public String getFistOnTheList(){

        if(possibleSourceList.isEmpty()) return "no possible sources detected";
        PossibleSource possibleSource = possibleSourceList.get(0);

        return String.valueOf("\n" + possibleSource.getId()) + " possibly is a source text for: " + possibleSource.getListToString();
    }
}
