package Logic.Models;

public class Orderrule {

    public int id;
    public Article article;
    public int amount;

    public Orderrule(Article article, int amount) {
        this.article = article;
        this.amount = amount;
    }
}
