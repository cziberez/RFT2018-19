package hu.food.bean.user;

import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("registerMBean")
@ViewScoped
@Getter
@Setter
public class RegisterMBean {

    private User registerUser;

}
