package com.text.similarity.project.text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    private int id;
    private String pathname;
    private List<Text> allTexts;

    public TextReader(String pathname) {
        this.pathname = pathname;
        this.allTexts = new ArrayList<>();
    }

    public List<Text> createTextDataBase() {

        File folder = new File(pathname);
        File[] listOfFiles = folder.listFiles();
        if(listOfFiles.length == 0) allTexts = null;
        else {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    String sourceText = readFileSourceText(file);
                    Text text = new Text(sourceText, file.getName().substring(0, file.getName().length() - 4));
                    allTexts.add(text);
                }
            }
        }
        return allTexts;
    }

    public String readFileSourceText(File file) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] data = new byte[(int) file.length()];
        try {
            fis.read(data);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String sourceText = null;
        try {
            sourceText = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sourceText;
    }

}
