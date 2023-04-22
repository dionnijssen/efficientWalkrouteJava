package Logic.Controllers;

import DataLayer.ArticleRepository;
import Logic.Interfaces.ArticleControllerInterface;
import Logic.Models.Article;

import java.util.ArrayList;


public class ArticleController implements ArticleControllerInterface {
    ArticleRepository articleRepo;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepo = articleRepository;
    }

    public ArrayList<Article> get() {
        return this.articleRepo.get();
    }

    public Article show(int id) {
        return this.articleRepo.show(id);
    }

    //I think this should receive parameters as well. because the cli class should pass through to this. This should arrange data and pass to Repo.
    public Article create(Article createArticle) {
//        return this.articleRepo.create(createArticle);
        return null;
    }

    public Article update(Article article) {
//        return this.articleRepo.update(article);
        return null;
    }

    public boolean delete(Article article) {
        return this.articleRepo.delete(article);
    }
}
