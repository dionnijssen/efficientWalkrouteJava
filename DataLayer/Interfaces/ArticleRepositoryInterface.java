package DataLayer.Interfaces;

import java.util.ArrayList;

//TODO: Is this good?
public interface ArticleRepositoryInterface<Model> extends RepositoryInterface<Model> {
    public ArrayList<Model> get();
    /*

     */
}
