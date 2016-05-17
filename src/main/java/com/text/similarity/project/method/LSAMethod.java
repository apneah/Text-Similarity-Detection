package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;
import edu.ucla.sspace.lsa.LatentSemanticAnalysis;
import edu.ucla.sspace.vector.VectorIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LSAMethod extends Method{
    private Text text1;
    private Text text2;

    @Override
    public double compare(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        return LSAAlgorithm();
    }
    private double LSAAlgorithm(){
        try {
            LatentSemanticAnalysis latentSemanticAnalysis = new LatentSemanticAnalysis();

            // pass documents to be processed
            latentSemanticAnalysis.processDocument(new BufferedReader(new FileReader(text1.getFile().getName())));
            latentSemanticAnalysis.processDocument(new BufferedReader(new FileReader(text2.getFile().getName())));

            latentSemanticAnalysis.processSpace(System.getProperties());

            for (String word : latentSemanticAnalysis.getWords())
                System.out.printf("%s maps to %s%n", word,
                        VectorIO.toString(latentSemanticAnalysis.getVector(word)));




        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}