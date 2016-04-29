package com.text.similarity.project;

import com.text.similarity.project.comparsion.Comparator;
import com.text.similarity.project.text.Text;
import com.text.similarity.project.text.TextDatabase;

public class Main {

    public static void main(String[] args) {
        int num = 4;

        TextDatabase textDatabase = new TextDatabase(num);

        for(Text t : textDatabase.getAllTexts()){
            System.out.println(t.getSourceText());
        }
        Comparator comparator = new Comparator(textDatabase.getAllTexts());
        comparator.compareAllTexts();
        System.out.println(comparator.getResult());

    }
}
