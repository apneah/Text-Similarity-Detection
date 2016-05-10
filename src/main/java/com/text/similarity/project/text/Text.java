package com.text.similarity.project.text;

public class Text {

    private static int numberOfFiles = 0;
    private int id;
    private String sourceText;
    private TextWordsSet textWordsSet;

    public Text(){
        id = numberOfFiles;
        numberOfFiles++;
        textWordsSet = null;
        //texts generated:
        sourceText = (new TextGenerator(20).getSourceText());    // arg for TextGenerator = how many words in text
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

}
