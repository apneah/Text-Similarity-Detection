package com.text.similarity.project.text;

import java.util.Random;

public class TextGenerator {

    private int numberOfWords;
    private String[] randomStrings;
    private String sourceText;


    public TextGenerator(int numberOfWords) {
        this.numberOfWords = numberOfWords;
        randomStrings = generateRandomWords();
        sourceText = concatenateWords(randomStrings);
    }


    public String getSourceText() {
        return sourceText;
    }

    private String[] generateRandomWords() {

        String[] randomWords = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[3]; // words of length 3 (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(4));
            }

            randomWords[i] = new String(word);
        }
        return randomWords;
    }

    private String concatenateWords(String[] arrayOfWords){
        StringBuilder sourceText = new StringBuilder();
        for(String word : arrayOfWords){
            sourceText.append(" ");
            sourceText.append(word);
        }
        return sourceText.toString();
    }

}
