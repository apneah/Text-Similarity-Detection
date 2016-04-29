package com.text.similarity.project.text;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextWordsSet {

    private Text text;
    private HashMap<String, Integer> mapOfWordOccurrencesInText;
    private int numberOfWords;

    public TextWordsSet(Text text){
        this.text = text;
        this.numberOfWords = 0;
        text.setTextWordsSet(this);
        mapOfWordOccurrencesInText = new HashMap<String, Integer>();
        generateWordsSetFromText();
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    private void generateWordsSetFromText(){
        String input = text.getSourceText();
        Pattern p = Pattern.compile("[\\w']+");
        Matcher m = p.matcher(input);

        while ( m.find() ) {
            String word = input.substring(m.start(), m.end());
            if(mapOfWordOccurrencesInText.containsKey(word)){
                mapOfWordOccurrencesInText.put(word, mapOfWordOccurrencesInText.get(word)+1);
            }
            else{
                mapOfWordOccurrencesInText.put(word, 1);
            }
            numberOfWords += 1;
        }
    }

    public HashMap<String, Integer> getMapOfWordOccurrencesInText() {
        return mapOfWordOccurrencesInText;
    }
}
