package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

import java.util.HashMap;


public class CommonWordsMethod extends Method {

    public CommonWordsMethod(Text text1, Text text2) {
        super(text1, text2);
    }

    @Override
    public double compare() {
        return commonWordsAlgorithm();
    }

    private double commonWordsAlgorithm(){
        HashMap<String, Integer> mapOfWordsText1;
        HashMap<String, Integer> mapOfWordsText2;
        int numOfWords1 = super.getText1().getTextWordsSet().getNumberOfWords();
        int numOfWords2 = super.getText2().getTextWordsSet().getNumberOfWords();

        int numOfSameWords = 0;

        //mapOfWordsText1 is a map of the shortest text!!!!!!!!!!!!!!!!
        if(numOfWords1 <= numOfWords2){
            mapOfWordsText1 = super.getText1().getTextWordsSet().getMapOfWordOccurrencesInText();
            mapOfWordsText2 = super.getText2().getTextWordsSet().getMapOfWordOccurrencesInText();
        }
        else{
            int temp = numOfWords1;
            numOfWords1 = numOfWords2;
            numOfWords2 = temp;
            mapOfWordsText1 = super.getText2().getTextWordsSet().getMapOfWordOccurrencesInText();
            mapOfWordsText2 = super.getText1().getTextWordsSet().getMapOfWordOccurrencesInText();
        }
        //System.out.println();
        for(String word : mapOfWordsText1.keySet()){

            if(mapOfWordsText2.containsKey(word)){

                numOfSameWords += Math.min(mapOfWordsText1.get(word), mapOfWordsText2.get(word));
                //System.out.println(word + " " + Math.min(mapOfWordsText1.get(word), mapOfWordsText2.get(word)));
            }
        }
        //System.out.println(numOfSameWords + " " + numOfSameWords/(double)numOfWords1);
        return numOfSameWords/(double)numOfWords1;
    }
}