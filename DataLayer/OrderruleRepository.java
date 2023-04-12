package DataLayer;

import Logic.Models.Orderrule;

import java.util.ArrayList;

public class OrderruleRepository {
    private final ArrayList<Orderrule> orderrules;

    public OrderruleRepository() {
        this.orderrules = new ArrayList<Orderrule>();
    }

    public ArrayList<Orderrule> get() {
        return this.orderrules;
    }

    public Orderrule show(int id) {
        for (Orderrule orderrule : this.get()) {
            if (orderrule.id == id) {
                return orderrule;
            }
        }

        return null;
    }

    public Orderrule create(Orderrule orderrule) {
        this.orderrules.add(orderrule);

        return orderrule;
    }

    public Orderrule update(Orderrule orderrule) {
        for (int i = 0; i < this.orderrules.size(); i++) {
            if (this.orderrules.get(i).id == orderrule.id) {
                this.orderrules.set(i, orderrule);

                return orderrule;
            }
        }

        return null;
    }

    public boolean delete(Orderrule orderrule) {
        for (int i = 0; i < this.orderrules.size(); i++) {
            if (this.orderrules.get(i).id == orderrule.id) {
                this.orderrules.remove(i);

                return true;
            }
        }

        return false;
    }
}
