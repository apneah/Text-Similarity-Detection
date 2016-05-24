package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

public class LevenshteinMethod extends Method{
    private Text text1;
    private Text text2;

    public LevenshteinMethod() {}

    @Override
    public double compare(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        int result =  LevenshteinDistance(text1.getSourceText(), text1.getSourceText().length(), text2.getSourceText(), text2.getSourceText().length());
        return (double)result/Math.min(text1.getSourceText().length(), text2.getSourceText().length());
    }


    int LevenshteinDistance(String s, int len_s, String t, int len_t) {
        int cost;


  /* base case: empty strings */
        if (len_s == 0) return len_t;
        if (len_t == 0) return len_s;

  /* test if last characters of the strings match */
        if (s.charAt(len_s-1) == t.charAt(len_t-1))
            cost = 0;
        else
            cost = 1;

  /* return minimum of delete char from s, delete char from t, and delete char from both */
        return Math.min(Math.min(LevenshteinDistance(s, len_s - 1, t, len_t    ) + 1,
                LevenshteinDistance(s, len_s    , t, len_t - 1) + 1), LevenshteinDistance(s, len_s - 1, t, len_t - 1) + cost);
    }

}
