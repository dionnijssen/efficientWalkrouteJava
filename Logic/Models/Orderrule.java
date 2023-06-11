package Logic.Models;

public class Orderrule {

    private Article article;
    private int amount;

    public Orderrule(Article article, int amount) {
        this.article = article;
        this.amount = amount;
    }

    public Article getArticle() {
        return this.article;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
