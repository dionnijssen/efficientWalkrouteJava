package Logic.Controllers;

import DataLayer.ArticleRepository;
import Logic.Interfaces.Logic.Controllers.ArticleControllerInterface;
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
}
