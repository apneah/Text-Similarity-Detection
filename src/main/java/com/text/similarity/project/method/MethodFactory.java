package com.text.similarity.project.method;

import java.util.ArrayList;
import java.util.List;

public class MethodFactory {

    private List<Method> methodList;

    public MethodFactory() {
        methodList = new ArrayList<Method>();
    }

    public List<Method> getMethodList() {
        if(methodList.isEmpty()) return setMethods();
        else return methodList;
    }

    public List<Method> setMethods() {

        MethodWindow window = new MethodWindow();
        if(window.getListOfMethods().contains("Common Words")) {
            methodList.add(new CommonWordsMethod());
        }
        if(window.getListOfMethods().contains("LCS")) {
            methodList.add(new LCSMethod());
        }
        if(window.getListOfMethods().contains("Cosine Similarity")) {
            methodList.add(new CosineSimilarityMethod());
        }
        if(window.getListOfMethods().contains("Levenshtein Method")) {
            methodList.add(new LevenshteinMethod());
            //System.out.println("in method factory");
        }

        return methodList;
    }

}
