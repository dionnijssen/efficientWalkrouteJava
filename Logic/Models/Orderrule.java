package Logic.Models;

public class Orderrule {

    private int id;
    private Article article;
    private int amount;

    public Orderrule(Article article, int amount) {
        this.article = article;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public Article getArticle() {
        return this.article;
    }

    public int getAmount() {
        return this.amount;
    }
}
