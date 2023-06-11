package Logic.Interfaces.Logic.Controllers;

import Logic.Models.Article;

import java.util.ArrayList;

public interface ArticleControllerInterface {
    ArrayList<Article> get();

    Article show(int id);
}
