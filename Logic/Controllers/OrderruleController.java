package Logic.Controllers;

import DataLayer.OrderruleRepository;
import Logic.Interfaces.Logic.Controllers.OrderruleControllerInterface;
import Logic.Models.Article;
import Logic.Models.Orderrule;

public class OrderruleController implements OrderruleControllerInterface {

    OrderruleRepository orderruleRepo;

    public OrderruleController(OrderruleRepository orderruleRepository) {
        orderruleRepo = orderruleRepository;
    }

    public Orderrule show(int id) {
        return this.orderruleRepo.show(id);
    }

    public Orderrule create(Article article, int amount) {
        Orderrule newOrderrule = new Orderrule(
                article,
                amount
        );

        return this.orderruleRepo.store(newOrderrule);
    }

    public Orderrule update(Orderrule orderrule) {
        return this.orderruleRepo.update(orderrule);
    }

    public boolean delete(Orderrule orderrule) {
        return this.orderruleRepo.delete(orderrule);
    }
}
