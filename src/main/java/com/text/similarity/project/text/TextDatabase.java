package com.text.similarity.project.text;

import java.util.*;

public class TextDatabase {

    //private String pathname = "C:\\Users\\Ola\\Documents\\text-similarity-project\\edata"; //Ola G.
    //private String pathname = "C:\\Users\\Olka\\Documents\\GitHub\\text-similarity-project\\data"; // Ola B.
    private String pathname;
    private List<Text> allTexts;

    // for reading all txt files from given folder
    public TextDatabase(String pathname) {
        this.pathname = pathname;
        if(pathname == null) {
            System.out.println("Invalid pathname argument.");
            System.exit(0);
        }
        TextReader reader = new TextReader(pathname);
        allTexts = reader.createTextDataBase();
        if(allTexts == null) {
            System.out.println("No texts to compare, data folder is empty.");
            System.exit(0);
        }
        if(allTexts.size() == 1) {
            System.out.println("No texts to compare, found only one file in data folder.");
            System.exit(0);
        }
        // System.out.println("all texts: " + allTexts.size());
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
