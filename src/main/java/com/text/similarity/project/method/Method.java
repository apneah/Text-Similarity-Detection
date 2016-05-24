package com.text.similarity.project.method;

import com.text.similarity.project.text.Text;


public abstract class Method {

    private Text text1;
    private Text text2;

    public Method(){}

    public abstract double compare(Text text1, Text text2);

    public Text getText1() {
        return text1;
    }

    public Text getText2() {
        return text2;
    }

}
