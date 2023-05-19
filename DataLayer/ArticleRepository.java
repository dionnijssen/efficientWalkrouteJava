package DataLayer;

import DataLayer.Interfaces.RepositoryInterface;
import Logic.Models.Article;

import java.util.ArrayList;

/* Vragen:
    - Hoe is het het makkelijkst om data op te slaan. Want het kan toch gedaan worden door het in de repo op te slaan?
    Aangezien de RepositoryFactory de repo in memory houd?
    - Is onderstaand de juiste manier om data op de slaan?
    - Toen ik interface implementeerde zag ik niet de opties erbij zitten?
    - Hoe data toe te voegen in de DepartmentRepository? (Articles nodig)
    - Wat is de correcte manier om de controllerFactory te gebruiken?
    Bij een method als dependency de controller?
    En dan bij aanroepen method de factory gebruiken om die dependency aan te maken?
 */
public class ArticleRepository implements RepositoryInterface<Article> {
    private ArrayList<Article> articles;

    public ArticleRepository() {
        ArrayList<Article> articles = new ArrayList<>();

        articles.add(
                new Article(
                        1,
                        "Apple",
                        "Elstar Apple"
                ));

        articles.add(
                new Article(
                        2,
                        "pear",
                        "Pear"
                ));

        articles.add(
                new Article(
                        3,
                        "Banana",
                        "Banana"
                ));

        this.articles = articles;
    }

    public ArrayList<Article> get(){
        return this.articles;
    }

    public Article show(int articleId){
        ArrayList<Article> articles = this.get();

        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == articleId){
                return articles.get(i);
            }
        }

        return null;
    }

    public Article store(Article article) {
        this.articles.add(article);
        return article;
    }

    public Article update(Article article){
        for (int i = 0; i < this.articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()){
                articles.set(i, article);

                return article;
            }
        }

        return null;
    }

    public boolean delete(Article article){
        for (int i = 0; i < this.articles.size(); i++) {
            if (articles.get(i).getId() == article.getId()){
                articles.remove(i);

                return true;
            }
        }

        return false;
    }
}
