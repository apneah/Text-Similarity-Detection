package com.text.similarity.project.text;

import java.util.*;

public class TextDatabase {

    //private String pathname = "C:\\Users\\Ola\\Documents\\text-similarity-project\\data"; //Ola Go
    private String pathname = "C:\\Users\\Olka\\Documents\\GitHub\\text-similarity-project\\data"; // Ola By
    private List<Text> allTexts;

    // for reading all txt files from given folder
    public TextDatabase() {
        TextReader reader = new TextReader(pathname);
        allTexts = reader.createTextDataBase();
        //System.out.println("all texts: " + allTexts.size());
    }

    // for creating random generated database
    public TextDatabase(int n){
        allTexts = new ArrayList<>();
        for(int i = 0; i < n; i++){
            allTexts.add(new Text());
        }
    }

    public List<Text> getAllTexts(){
        return allTexts;
    }

}
