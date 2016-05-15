package com.text.similarity.project.comparison;

import com.text.similarity.project.method.Method;
import com.text.similarity.project.method.MethodFactory;
import com.text.similarity.project.text.Text;

import java.util.ArrayList;
import java.util.List;

public class Comparator {

    private List<Text> allTexts;
    private int listSize;
    private List<OverallSimilarityRate> results = new ArrayList<>();

    public Comparator(List<Text> allTexts) {
        this.allTexts = allTexts;
        this.listSize = allTexts.size();
    }

    public void compareAllTexts() {

        MethodFactory methodFactory = new MethodFactory();
        List<Method> listOfMethods = methodFactory.getMethodList();
        if(listOfMethods.isEmpty()) return;

        for (int i = 0; i < allTexts.size() - 1; i++) {
            for (int j = i + 1; j < allTexts.size(); j++) {
                ComparisonsRunner runner = new ComparisonsRunner(allTexts.get(i), allTexts.get(j), listOfMethods);
                results.add(runner.runAllComparisons());
            }
        }
    }

    public List<OverallSimilarityRate> getResults() {
        return results;
    }

    public String resultsToString(){
        StringBuilder stringBuilder = new StringBuilder();
        if(results.isEmpty()) return "no results";
        for(OverallSimilarityRate result : results) {
            stringBuilder.append(result.getRate());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
