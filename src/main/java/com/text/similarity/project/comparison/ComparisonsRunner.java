package com.text.similarity.project.comparison;

import com.text.similarity.project.method.Method;
import com.text.similarity.project.method.MethodFactory;
import com.text.similarity.project.text.Text;

import java.util.List;

public class ComparisonsRunner {

    private Text text1;
    private Text text2;
    static private List<Method> listOfMethods;

    public ComparisonsRunner(Text text1, Text text2, List<Method> listOfMethods) {
        this.text1 = text1;
        this.text2 = text2;
        this.listOfMethods = listOfMethods;
    }

    public OverallSimilarityRate runAllComparisons() {

        OverallSimilarityRate similarityRate = new OverallSimilarityRate(text1, text2);

        if(listOfMethods.isEmpty()) return null;
        for(Method method : listOfMethods){
            similarityRate.addSingleRate(method.compare(text1, text2));
        }
        return similarityRate;
    }
}
