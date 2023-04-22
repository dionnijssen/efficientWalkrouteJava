package Logic.Interfaces;

import Logic.Models.Article;

import java.util.ArrayList;

public interface ArticleInterface {
    ArrayList<Article> get();

    Article show(int id);

    Article create(Article createArticle);

    Article update(Article article);

    boolean delete(Article article);
}
