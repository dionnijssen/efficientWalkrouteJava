package Logic.Interfaces;

import Logic.Models.Article;
import Logic.Models.Orderrule;

public interface OrderruleControllerInterface {
    Orderrule show(int id);

    Orderrule create(Article article, int amount);

    Orderrule update(Orderrule orderrule);

    boolean delete(Orderrule orderrule);
}
