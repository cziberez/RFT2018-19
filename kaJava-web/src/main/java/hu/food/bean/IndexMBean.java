package hu.food.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@ViewScoped
@Named("indexMBean")
public class IndexMBean implements Serializable {

    private static final long serialVersionUID = 6268993761139416765L;

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Hello World!");
    }

    public void redirectToDemo() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/kaJava-web/xhtml/demo.xhtml");
            System.out.println("asd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}