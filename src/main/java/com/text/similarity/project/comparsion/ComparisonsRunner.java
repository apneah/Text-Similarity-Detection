package com.text.similarity.project.comparsion;

import com.text.similarity.project.method.Method;
import com.text.similarity.project.method.MethodFactory;
import com.text.similarity.project.text.Text;

import java.util.List;

public class ComparisonsRunner {

    private Text text1;
    private Text text2;

    public ComparisonsRunner(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public OverallSimilarityRate runAllComparisons() {

        OverallSimilarityRate similarityRate = new OverallSimilarityRate(text1, text2);
        MethodFactory methodFactory = new MethodFactory(text1, text2);
        List<Method> setOfMethods = methodFactory.provideMethods();

        for(Method method : setOfMethods){
            similarityRate.addSingleRate(method.compare());
        }

        return similarityRate;
    }
}
