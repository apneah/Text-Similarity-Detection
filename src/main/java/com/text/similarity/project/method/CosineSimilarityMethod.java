package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

import java.util.HashSet;
import java.util.Map;

public class CosineSimilarityMethod extends Method{

    private Text text1;
    private Text text2;
    private double methodIndicator = 0.65 / 0.85;

    @Override
    public Text getText2() {
        return text2;
    }

    @Override
    public Text getText1() {
        return text1;
    }

    public CosineSimilarityMethod() {}

    @Override
    public double compare(Text text1, Text text2) {

        this.text1 = text1;
        this.text2 = text2;
        return cosineSimilarityAlgorithm();
    }

    public double cosineSimilarityAlgorithm() {
        //Get vectors
        Map<String, Integer> a = text1.getTextWordsSet().getMapOfWordOccurrencesInText();
        Map<String, Integer> b = text2.getTextWordsSet().getMapOfWordOccurrencesInText();

        //Get unique words from both sequences
        HashSet<String> intersection = new HashSet<>(a.keySet());
        intersection.retainAll(b.keySet());

        double dotProduct = 0, magnitudeA = 0, magnitudeB = 0;

        //Calculate dot product
        for (String item : intersection) {
            dotProduct += a.get(item) * b.get(item);
        }

        //Calculate magnitude a
        for (String k : a.keySet()) {
            magnitudeA += Math.pow(a.get(k), 2);
        }

        //Calculate magnitude b
        for (String k : b.keySet()) {
            magnitudeB += Math.pow(b.get(k), 2);
        }

        //return cosine similarity
        return dotProduct / Math.sqrt(magnitudeA * magnitudeB);
    }

    @Override
    public double getMethodIndicator() { return methodIndicator; }

}
