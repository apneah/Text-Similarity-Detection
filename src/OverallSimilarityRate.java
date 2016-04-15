import java.util.ArrayList;
import java.util.List;

public class OverallSimilarityRate {

    private List<Double> similarityRateFromAllMethods;
    private Text text1;
    private Text text2;


    public OverallSimilarityRate(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
        similarityRateFromAllMethods = new ArrayList<Double>();
    }

    // simple implementation, returns average rate

    public double computeSimilarityRate() {
        double result = 0;
        for(double singleRate : similarityRateFromAllMethods) {
            result += singleRate;
        }
        return result/similarityRateFromAllMethods.size();
    }

    public void addSingleRate(double rate) {
        similarityRateFromAllMethods.add(rate);
    }
}
