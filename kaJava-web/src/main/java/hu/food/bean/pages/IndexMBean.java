package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@ViewScoped
@Named("indexMBean")
public class IndexMBean extends AbstractViewBean {

    @Override
    public List<Role> getRoles() {
        return null;
    }
}
