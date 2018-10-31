package hu.food;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.IOException;

@ManagedBean
public class IndexMBean {

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Hello World!");
    }

    public void redirectToDemo() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/xhtml/demo.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}