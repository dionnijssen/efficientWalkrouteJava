package Logic.Models;

public class Rule {
    private int id;
    private String type;
    private int articleId;
    private int amount;

    public Rule(int id, String type, int articleId, int amount) {
        this.id = id;
        this.type = type;
        this.articleId = articleId;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public int getArticleId() {
        return this.articleId;
    }

    public int getAmount() {
        return this.amount;
    }
}
