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

    public static void main(String[] args) throws IOException, ParseException {
        Main main = new Main();
        main.main();
    }

    public void main() throws IOException, ParseException {
        this.repositoryFactory = new RepositoryFactory();
        this.serviceFactory = new ServiceFactory();
        this.controllerFactory = new ControllerFactory(this.repositoryFactory, this.serviceFactory);
        this.uiFactory = new UiFactory(this.controllerFactory, this.repositoryFactory);

        this.uiFactory.getHomeInterface().home();
    }
}

