import java.util.*;


public class TextDatabase {

    private List<Text> _allTexts;

    public TextDatabase(int n){
        _allTexts = new ArrayList<Text>();
        for(int i=0; i< n; i++){
            _allTexts.add(new Text());
        }
    }

    public List getAllTexts(){
        return _allTexts;
    }

    

}
