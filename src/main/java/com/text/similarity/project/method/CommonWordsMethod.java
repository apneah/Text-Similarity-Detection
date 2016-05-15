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

        HashMap<String, Integer> mapOfWordsText1 = null;
        HashMap<String, Integer> mapOfWordsText2 = null;
        int numOfWords1 = text1.getTextWordsSet().getNumberOfWords();
        int numOfWords2 = text2.getTextWordsSet().getNumberOfWords();

        int numOfSameWords = 0;

        //mapOfWordsText1 is a map of the shortest text!!!!!!!!!!!!!!!!
        if(numOfWords1 <= numOfWords2){
            mapOfWordsText1 = text1.getTextWordsSet().getMapOfWordOccurrencesInText();
            mapOfWordsText2 = text2.getTextWordsSet().getMapOfWordOccurrencesInText();
        }
        else{
            int temp = numOfWords1;
            numOfWords1 = numOfWords2;
            numOfWords2 = temp;
            mapOfWordsText1 = text2.getTextWordsSet().getMapOfWordOccurrencesInText();
            mapOfWordsText2 = text1.getTextWordsSet().getMapOfWordOccurrencesInText();
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