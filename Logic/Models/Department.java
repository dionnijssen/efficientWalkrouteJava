package Logic.Models;

import java.util.ArrayList;

public class Department {
    private int id;
    private String name;
    private int order;
    private ArrayList<Article> articles;

    public Department(int id, String name, int order, ArrayList<Article> articles) {
        this.id = id;
        this.name = name;
        this.order = order;
        this.articles = articles;
    }

    public int getId() {
        return this.id;
    }
}
