package com.text.similarity.project.method;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class MethodWindow {

    private List<String> listOfMethods;

    public MethodWindow() {
        listOfMethods = new ArrayList<String>();
        askForMethods();
    }

    public void askForMethods() {

        final JRadioButton commonWordsButton = new JRadioButton("Common Words Method");
        final JRadioButton LCSButton = new JRadioButton("LCS Method");
        final JRadioButton cosineButton = new JRadioButton("Cosine Similarity Method");
        final JRadioButton levenshteinButton = new JRadioButton("Levenshtein Method");
        JComponent[] options = new JComponent[]{commonWordsButton, LCSButton, cosineButton, levenshteinButton};

        JOptionPane.showConfirmDialog(null, options, "Choose methods for text comparisons:", JOptionPane.OK_CANCEL_OPTION);
        if(commonWordsButton.isSelected()) {
            listOfMethods.add("Common Words");
            System.out.println("choosing common words method");
        }
        if(LCSButton.isSelected()) {
            listOfMethods.add("LCS");
            System.out.println("choosing LCS method");
        }
        if(cosineButton.isSelected()) {
            listOfMethods.add("Cosine Similarity");
            System.out.println("choosing cosine similarity method");
        }
        if(levenshteinButton.isSelected()) {
            listOfMethods.add("Levenshtein Method");
            System.out.println("choosing Levenshtein method");
        }
    }

    public List<String> getListOfMethods() {
            return listOfMethods;
        }
}

