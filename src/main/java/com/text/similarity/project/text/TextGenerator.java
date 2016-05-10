package com.text.similarity.project.text;

import java.io.*;
import java.util.Random;

public class TextGenerator {

    static private int id = 0;
    private int numberOfWords;
    private String[] randomStrings;
    private String sourceText;

    public TextGenerator(int numberOfWords) {
        id++;
        this.numberOfWords = numberOfWords;
        randomStrings = generateRandomWords();
        sourceText = concatenateWords(randomStrings);
        createTextFile();
    }

    public String getSourceText() {
        return sourceText;
    }

    private void createTextFile() {

        Writer writer = null;
        try {
            writer = new FileWriter(createFilename());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(sourceText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String createFilename() {

        StringBuilder sb = new StringBuilder();
        sb.append("data\\text");
        sb.append(id);
        sb.append(".txt");
        return sb.toString();
    }

    private String[] generateRandomWords() {

        String[] randomWords = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[4];   // words of length 3 (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++) {
                word[j] = (char)('a' + random.nextInt(4));
            }
            randomWords[i] = new String(word);
        }
        return randomWords;
    }

    private String concatenateWords(String[] arrayOfWords){
        StringBuilder sourceText = new StringBuilder();
        for(String word : arrayOfWords){
            sourceText.append(word);
            sourceText.append(" ");
        }
        return sourceText.toString();
    }

}
