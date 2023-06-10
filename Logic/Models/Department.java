package Logic.Models;

import java.util.ArrayList;

public class Department {
    private int id;
    private String name;
    private int order;
    private ArrayList articleIds;

    public Department(int id, String name, int order, ArrayList articles) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.articleIds = articles;
    }

    public int getId() {
        return this.id;
    }

    public int getOrder() {
        return this.order;
    }

    public ArrayList getArticleIds() {
        return this.articleIds;
    }
}
