package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

public class LevenshteinMethod extends Method {

    private Text text1;
    private Text text2;
    private double methodIndicator = 1.0;

    public LevenshteinMethod() { }

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
        //System.out.println("compare" );
        this.text1 = text1;
        this.text2 = text2;
        return LevenstheinAlgorythm();
    }

    private double LevenstheinAlgorythm() {
        int distance = LevenshteinDistance(text1.getSourceText(),
                text2.getSourceText());
        double result = 1.0 - (double)distance/(double)Math.max(text1.getSourceText().length(), text2.getSourceText().length());
        //System.out.println(this.text1.getFilename() + " " + this.text2.getFilename() + " " + distance + " " + result);
        return result;
    }

    private int LevenshteinDistance(String string1, String string2) {

        int len1 = string1.length();
        int len2 = string2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        //iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = string1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = string2.charAt(j);

                //if last two chars equal
                if (c1 == c2) {
                    //update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];

    }

    @Override
    public double getMethodIndicator() {
        return methodIndicator;
    }
}