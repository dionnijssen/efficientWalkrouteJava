package Logic.Controllers;

import DataLayer.OrderruleRepository;
import Logic.Models.Article;
import Logic.Models.Orderrule;

public class OrderruleController {

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

        return this.orderruleRepo.create(newOrderrule);
    }

    public Orderrule update(Orderrule orderrule) {
        return this.orderruleRepo.update(orderrule);
    }

    public boolean delete(Orderrule orderrule) {
        return this.orderruleRepo.delete(orderrule);
    }
}
