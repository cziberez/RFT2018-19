package hu.food.bean.pages;

import hu.food.bean.abstractbean.AbstractViewBean;
import hu.food.service.enums.Role;
import hu.food.service.services.OrderService;
import hu.food.service.vo.OrderVo;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Named("orderMBean")
@ViewScoped
public class OrderMBean extends AbstractViewBean {

    @EJB
    private OrderService orderService;

    private List<OrderVo> orders;

    private OrderVo selectedOrder;

    @PostConstruct
    @Override
    public void init() {
        super.init();
        orders = orderService.getAllOrder();

    }

    @Override
    public List<Role> getRoles() {
        return Arrays.asList(Role.ADMINISTRATOR, Role.SHOPRENTER);
    }

    public List<OrderVo> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderVo> orders) {
        this.orders = orders;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public OrderVo getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(OrderVo selectedOrder) {
        this.selectedOrder = selectedOrder;
    }
}
