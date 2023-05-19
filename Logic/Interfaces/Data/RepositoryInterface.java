package Logic.Interfaces.Data;

import Logic.Models.Order;

import java.util.ArrayList;


/* <T> is placeholder, in the repositories you can define what Model should be. (Model can be anything.)

 */
public interface RepositoryInterface<Model> {
    public ArrayList<Model> get();

    public Model show(int id);

    public Model store(Model model);

    public Model update(Model model);

    public boolean delete(Model model);
}
