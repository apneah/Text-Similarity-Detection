import java.util.Random;

public class Text {

    private static int numberOfFiles = 0;
    private int id;
    private String sourceText;
    private TextWordsSet textWordsSet;


    public TextWordsSet getTextWordsSet() {
        if(textWordsSet == null){
            textWordsSet = new TextWordsSet(this);
        }
        return textWordsSet;
    }

    public Text(){
        id = numberOfFiles;
        numberOfFiles++;
        sourceText = concatenateWords(generateRandomWords(500));
        textWordsSet = null;
    }

    public void setTextWordsSet(TextWordsSet textWordsSet) {
        this.textWordsSet = textWordsSet;
    }

    public String getSourceText() {
        return sourceText;
    }

    private static String[] generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        return randomStrings;
    }

    private static String concatenateWords(String[] arrayOfWords){
        StringBuilder text = new StringBuilder();
        for(String word : arrayOfWords){
            text.append(" ");
            text.append(word);
        }
        return text.toString();
    }
}
