package src;

import Logic.ControllerFactory;
import Logic.RepositoryFactory;
import Logic.ServiceFactory;
import Logic.UiFactory;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    private ControllerFactory controllerFactory;
    private RepositoryFactory repositoryFactory;
    private ServiceFactory serviceFactory;
    private UiFactory uiFactory;

    /*
        - Voeg test toe van (meerdere) Orders toevoegen aan shoppingList
        - Voeg test toe van Algoritme
     */

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.main();
    }

    public void main() throws IOException, ParseException {
        this.repositoryFactory = new RepositoryFactory();
        this.serviceFactory = new ServiceFactory(this.repositoryFactory);
        this.controllerFactory = new ControllerFactory(this.repositoryFactory, this.serviceFactory);
        this.uiFactory = new UiFactory(this.controllerFactory, this.repositoryFactory, this.serviceFactory);

        this.uiFactory.getHomeInterface().home();
    }
}

