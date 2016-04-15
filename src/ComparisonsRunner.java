public class ComparisonsRunner {

    private Text text1;
    private Text text2;

    public ComparisonsRunner(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public OverallSimilarityRate runAllComparisons() {
        OverallSimilarityRate similarityRate = similarityRate = new OverallSimilarityRate(text1, text2);
        similarityRate.addSingleRate(0.0);  // tutaj w nawiasie wywolanie naszej super metody porownywania
        similarityRate.addSingleRate(0.0); // druga metoda, trzecia itd.

        // ...
        return similarityRate;
    }
}
