package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.services.UserService;
import hu.food.service.enums.Role;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

@ViewScoped
@Named("indexMBean")
public class IndexMBean extends AbstractViewBean {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserService userService;

    @Override
    public List<Role> getRoles() {
        return Collections.singletonList(Role.GUEST);
    }
}
