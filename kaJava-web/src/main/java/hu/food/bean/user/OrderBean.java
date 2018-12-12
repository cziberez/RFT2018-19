package hu.food.bean.user;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.services.OrderService;
import hu.food.service.vo.OrderVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("orderBean")
@ViewScoped
public class OrderBean extends AbstractViewBean {

    @EJB
    private OrderService orderService;

    @Inject
    private UserMBean userMBean;

    private List<OrderVo> myOrders;

    @PostConstruct
    public void init(){
        myOrders = orderService.findOrdersByUser(userMBean.getUserVo().getId());
    }

    @Override
    public List<Role> getRoles() {
        return null;
    }

    public List<OrderVo> getMyOrders() {
        return myOrders;
    }

    public void setMyOrders(List<OrderVo> myOrders) {
        this.myOrders = myOrders;
    }
}
