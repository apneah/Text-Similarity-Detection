package com.text.similarity.project.analysis;

import com.text.similarity.project.comparison.OverallSimilarityRate;

import java.util.*;

public class SourceFinder {
    private List<OverallSimilarityRate> originalResults;
    private List<OverallSimilarityRate> processedResults;
    private Set<Integer> resultsIds;
    private List<PossibleSource> possibleSourceList;


    public SourceFinder(List<OverallSimilarityRate> originalResults){
        this.originalResults = originalResults;
        this.resultsIds = new HashSet<>();
        this.processedResults = processSimilarityRates();
        this.possibleSourceList = getPossibleSources();
    }

    private List<OverallSimilarityRate> processSimilarityRates (){

        List<OverallSimilarityRate> list = new ArrayList<>();
        for(OverallSimilarityRate result : originalResults){
            if(result.computeSimilarityRate() > 0.2){
                list.add(result);
                if(!resultsIds.contains(result.getText1Id())){
                    resultsIds.add(result.getText1Id());
                }
                if(!resultsIds.contains(result.getText2Id())){
                    resultsIds.add(result.getText2Id());
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public List<OverallSimilarityRate> resultsWithId(int id){
        List<OverallSimilarityRate> result = new ArrayList<>();
        for(OverallSimilarityRate o : processedResults){
            if(o.getText1Id() == id || o.getText2Id() == id){
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
        for(Integer id : resultsIds){

            PossibleSource possibleSource = new PossibleSource(id);
            List<OverallSimilarityRate> rates = resultsWithId(id);
            for(OverallSimilarityRate rate : rates){
                int anotherId;
                if(rate.getText1Id() != id){
                    anotherId = rate.getText1Id();
                }
                else{
                    anotherId = rate.getText2Id();
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
