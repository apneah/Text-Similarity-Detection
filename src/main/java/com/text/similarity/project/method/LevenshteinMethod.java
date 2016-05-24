package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

public class LevenshteinMethod extends Method {

    private Text text1;
    private Text text2;
    private double methodIndicator = 1.0;

    public LevenshteinMethod() { System.out.println("constructor" ); }

    @Override
    public Text getText1() {
        return text1;
    }

    @Override
    public Text getText2() {
        return text2;
    }

    @Override
    public double compare(Text text1, Text text2) {
        System.out.println("compare" );
        this.text1 = text1;
        this.text2 = text2;
        return LevenstheinAlgorythm();
    }

    private double LevenstheinAlgorythm() {
        int distance = LevenshteinDistance(text1.getSourceText(), text1.getSourceText().length(),
                text2.getSourceText(), text2.getSourceText().length());
        double result = (double)distance/(double)Math.min(text1.getSourceText().length(), text2.getSourceText().length());
        System.out.println(this.text1.getFilename() + " " + this.text2.getFilename() + " " + result);
        return result;
    }

    private int LevenshteinDistance(String s, int len_s, String t, int len_t) {

        int cost;

        /* base case: empty strings */
        if (len_s == 0) return len_t;
        if (len_t == 0) return len_s;

        /* test if last characters of the strings match */
        if (s.charAt(len_s-1) == t.charAt(len_t-1)) cost = 0;
        else cost = 1;

        /* return minimum of delete char from s, delete char from t, and delete char from both */
        return Math.min(Math.min(LevenshteinDistance(s, len_s - 1, t, len_t) + 1,
                LevenshteinDistance(s, len_s, t, len_t - 1) + 1), LevenshteinDistance(s, len_s - 1, t, len_t - 1) + cost);
    }

    @Override
    public double getMethodIndicator() {
        return methodIndicator;
    }
}