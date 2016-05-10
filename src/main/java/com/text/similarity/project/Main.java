package com.text.similarity.project;

import com.text.similarity.project.analysis.SourceFinder;
import com.text.similarity.project.comparison.Comparator;
import com.text.similarity.project.text.Text;
import com.text.similarity.project.text.TextDatabase;

public class Main {

    public static void main(String[] args) {

        TextDatabase textDatabase;
        // int numberOfTextsToGenerate = 10;
        // textDatabase = new TextDatabase(numberOfTextsToGenerate);
        textDatabase = new TextDatabase();

        for(Text t : textDatabase.getAllTexts()){
            System.out.println(t.getId() + ": " + t.getSourceText());
        }
        Comparator comparator = new Comparator(textDatabase.getAllTexts());
        comparator.compareAllTexts();

        System.out.println(comparator.getResult());

        System.out.println(new SourceFinder(comparator.getResults()).getFistOnTheList());

    }
}
