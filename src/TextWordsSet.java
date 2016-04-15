import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Olka on 2016-04-15.
 */
public class TextWordsSet {
    private Text text;
    private HashMap<String, Integer> mapOfWordOccurencesInText;

    public TextWordsSet(Text text){
        this.text = text;
        text.setTextWordsSet(this);
        mapOfWordOccurencesInText = new HashMap<String, Integer>();
        generateWordsSetFromText();
    }

    private void generateWordsSetFromText(){
        String input = text.getSourceText();
        Pattern p = Pattern.compile("[\\w']+");
        Matcher m = p.matcher(input);

        while ( m.find() ) {
            String word = input.substring(m.start(), m.end());
            if(mapOfWordOccurencesInText.containsKey(word)){
                mapOfWordOccurencesInText.put(word, mapOfWordOccurencesInText.get(word)+1);
            }
            else{
                mapOfWordOccurencesInText.put(word, 1);
            }
        }
    }

    public HashMap<String, Integer> getMapOfWordOccurencesInText() {
        return mapOfWordOccurencesInText;
    }
}
