import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olka on 2016-04-19.
 */
public class MethodFactory {

    private Text text1;
    private Text text2;

    public MethodFactory(Text text1, Text text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    public List<Method> provideMethods() {
        List<Method> methodList = new ArrayList<Method>();

        methodList.add(new LCSMethod(text1, text2));
        methodList.add(new CommonWordsMethod(text1, text2));

        return methodList;
    }
}
