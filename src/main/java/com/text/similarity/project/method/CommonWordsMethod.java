package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

import java.util.HashMap;


public class CommonWordsMethod extends Method {

    private Text text1;
    private Text text2;

    public CommonWordsMethod() { }

    @Override
    public double compare(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        return commonWordsAlgorithm();
    }

    private double commonWordsAlgorithm(){

        HashMap<String, Integer> mapOfWordsText1 = text1.getTextWordsSet().getMapOfWordOccurrencesInText();
        HashMap<String, Integer> mapOfWordsText2 = text2.getTextWordsSet().getMapOfWordOccurrencesInText();

        int numOfSameWords = 0;

        for(String word : mapOfWordsText1.keySet()){

            if(mapOfWordsText2.containsKey(word)){
                numOfSameWords += Math.min(mapOfWordsText1.get(word), mapOfWordsText2.get(word));
            }
        }
        return numOfSameWords / (double)Math.min(text1.getTextWordsSet().getNumberOfWords(), text2.getTextWordsSet().getNumberOfWords());
    }
}