package Logic.Controllers;

import DataLayer.OrderRepository;
import Logic.Interfaces.OrderControllerInterface;
import Logic.Models.Order;
import Logic.Models.Orderrule;

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
}
