package DataLayer;

import Logic.Models.Article;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles;

    public ArticleRepository() {
        ArrayList<Article> articles = new ArrayList<>();

        articles.add(
                new Article(
                        1,
                        "apple",
                        "Elstar Apple"
                ));

        articles.add(
                new Article(
                        2,
                        "cola",
                        "Coca Cola"
                ));

        articles.add(
                new Article(
                        3,
                        "fanta",
                        "Fanta Orange"
                ));

        this.articles = articles;
    }

    public ArrayList<Article> get() {
        return this.articles;
    }

    public Article show(int articleId) {
        ArrayList<Article> articles = this.get();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == articleId) {
                return articles.get(i);
            }
        }

        return null;
    }
}
