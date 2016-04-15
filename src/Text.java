import java.util.Random;

public class Text {
    private static int numberOfFiles = 0;
    private int numberOfWords;
    private int id;
    private String sourceText;
    private String[] sourceWords;

    public static int getNumberOfFiles() {
        return numberOfFiles;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getId() {
        return id;
    }

    public String getSourceText() {
        return sourceText;
    }

    public String[] getSourceWords() {
        return sourceWords;
    }

    public Text(){
        id = numberOfFiles;
        numberOfFiles++;
        sourceWords = generateRandomWords(500);
        sourceText = concatenateWords(sourceWords);
        numberOfWords = sourceWords.length;
    }

    private static String[] generateRandomWords(int numberOfWords)
    {
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
