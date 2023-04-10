package Logic.Controllers;

import DataLayer.OrderRepository;
import Logic.Helpers.Helpers;
import Logic.Interfaces.OrderControllerInterface;
import Logic.Models.Order;
import Logic.Models.Orderrule;
import Logic.Models.Shoppinglist;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderController implements OrderControllerInterface {
    OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order create() {
        return new Order(
                ((this.orderRepo.get()).size() + 1),
                LocalDate.now(),
                new ArrayList<Orderrule>()
        );
    }

//    public Order create(Shoppinglist shoppinglist) {
//        int id = ((this.orderRepo.get()).size() + 1);
//        ArrayList<Orderrule> orderrules = new ArrayList<Orderrule>();
//
//        Order order = new Order(
//                id,
//                shoppinglist.date,
//                orderrules
//        );
//
//        //TODO: implement
//        order = this.orderRepo.create(order);
//
//        return order;
//    }

    public boolean delete(Order order) {
        return false;
    }
}
