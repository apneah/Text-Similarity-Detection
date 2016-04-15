import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Comparator {

    private List<Text> allTexts;
    private int listSize;
    private ArrayList<SimilarityRate> results;

    public Comparator(List<Text> allTexts) {
        this.allTexts = allTexts;
        this.listSize = allTexts.size();
        this.results = new ArrayList <SimilarityRate>();
    }

    public void compareAllTexts() {
        for(int i=0; i<allTexts.size()-1; i++) {
            for(int j=i+1; i<allTexts.size(); i++) {
                results.add(compare2Texts(allTexts.get(i), allTexts.get(j)));
            }
        }
    }

}
