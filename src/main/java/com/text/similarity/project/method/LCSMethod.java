package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;


public class LCSMethod extends Method{

    private Text text1;
    private Text text2;
    private double methodIndicator = 1;

    public LCSMethod() {}

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
        this.text1 = text1;
        this.text2 = text2;
        return LCSAlgorithm();
    }

    private double LCSAlgorithm(){
        String sequence1 = this.getText1().getSourceText();
        String sequence2 = this.getText2().getSourceText();

        int[][] LCS = new int[sequence1.length() + 1][sequence2.length() + 1];
        String[][] solution = new String[sequence1.length() + 1][sequence2.length() + 1];

        // if 1 is null then LCS(text1, text2) = 0
        for (int i = 0; i <= sequence2.length(); i++) {
            LCS[0][i] = 0;
            solution[0][i] = "0";
        }

        // if 2 is null then LCS(text1, text2) = 0
        for (int i = 0; i <= sequence1.length(); i++) {
            LCS[i][0] = 0;
            solution[i][0] = "0";
        }

        for (int i = 1; i <= sequence1.length(); i++) {
            for (int j = 1; j <= sequence2.length(); j++) {
                if (sequence1.charAt(i-1) == sequence2.charAt(j-1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }
        //this will be the percentage of the length of the longest subsequence out of the shortest of texts
        return (double)LCS[sequence1.length()][sequence2.length()] / Math.min(sequence1.length(), sequence2.length());
    }

    @Override
    public double getMethodIndicator() { return methodIndicator; }

}
