package com.text.similarity.project.text;

import java.util.*;


public class TextDatabase {

    private List<Text> allTexts;

    public TextDatabase(int n){
        allTexts = new ArrayList<Text>();
        for(int i=0; i< n; i++){
            allTexts.add(new Text());
        }
    }

    public List<Text> getAllTexts(){
        return allTexts;
    }

}
