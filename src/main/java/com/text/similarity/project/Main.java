package com.text.similarity.project;

import com.text.similarity.project.analysis.SourceFinder;
import com.text.similarity.project.comparison.Comparator;
import com.text.similarity.project.text.TextDatabase;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        TextDatabase textDatabase;
        // int numberOfTextsToGenerate = 10;
        // textDatabase  new TextDatabase(numberOfTextsToGenerate);

        // here, select your own path to folder with txt files to compare:
        String pathname = "C:\\Users\\Ola\\Documents\\text-similarity-project\\data";
        textDatabase = new TextDatabase(pathname);
/*
        for(Text t : textDatabase.getAllTexts()){
            System.out.println(t.getId() + ": " + t.getSourceText());
        }
*/
        Comparator comparator = new Comparator(textDatabase.getAllTexts());
        comparator.getTimeAndCompareAllTexts();

        // writing results to txt files
        String possibleSources = new SourceFinder(comparator.getResults()).getFistOnTheList();
        Writer writer = null;
        try {
            writer = new FileWriter("results.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(comparator.resultsToString());
            writer.write(possibleSources);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK");
    }
}