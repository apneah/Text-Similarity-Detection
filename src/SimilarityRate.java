import java.util.ArrayList;
import java.util.List;

public class SimilarityRate {

    private List<Double> similarityRateFromOneMethod;
    private Text text1;
    private Text text2;


    public SimilarityRate(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        similarityRateFromOneMethod = new ArrayList<Double>();
    }

    // simple implementation, returns average rate

    public double computeSimilarityRate() {
        double result = 0;
        for(double singleRate : similarityRateFromOneMethod) {
            result += singleRate;
        }
        return result/similarityRateFromOneMethod.size();
    }

}
