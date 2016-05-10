package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;

import java.util.HashSet;
import java.util.Map;

public class CosineSimilarityMethod extends Method{

    public CosineSimilarityMethod(Text text1, Text text2) {
        super(text1, text2);
    }

    @Override
    public double compare() {
        return cosineSimilarityAlgorithm();
    }

    public double cosineSimilarityAlgorithm() {
        //Get vectors
        Map<String, Integer> a = getText1().getTextWordsSet().getMapOfWordOccurrencesInText();
        Map<String, Integer> b = getText2().getTextWordsSet().getMapOfWordOccurrencesInText();

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

}
