package com.text.similarity.project.text;

import java.io.File;

public class Text {

    private static int numberOfFiles = 1;
    private int id;
    private String sourceText;
    private TextWordsSet textWordsSet;


    private String filename;

    public Text(){
        id = numberOfFiles;
        numberOfFiles++;
        textWordsSet = null;
        filename = Integer.toString(id);
        //texts generated:
        sourceText = (new TextGenerator(20).getSourceText());    // arg for TextGenerator = how many words in text
    }

    public Text(String sourceText, String filename) {
        id = numberOfFiles;
        numberOfFiles++;
        textWordsSet = null;
        this.filename = filename;
        this.sourceText = sourceText;
    }


    public TextWordsSet getTextWordsSet() {
        if(textWordsSet == null){
            textWordsSet = new TextWordsSet(this);
        }
        return textWordsSet;
    }

    public int getId() {
        return id;
    }

    public void setTextWordsSet(TextWordsSet textWordsSet) {
        this.textWordsSet = textWordsSet;
    }

    public String getSourceText() {
        return sourceText;
    }

    public String getFilename() {
        return filename;
    }

}
