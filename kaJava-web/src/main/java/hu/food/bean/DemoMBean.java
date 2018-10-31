package hu.food.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("demoMBean")
public class DemoMBean implements Serializable {

    private static final long serialVersionUID = -8041099559929109897L;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void handleKeyEvent() {
        text = text.toUpperCase();
    }

    private int number;

    public int getNumber() {
        return number;
    }

    public void increment() {
        number++;
    }
}
