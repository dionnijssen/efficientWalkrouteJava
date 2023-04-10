package Logic;

import DataLayer.*;
import DataLayer.Interfaces.ArticleRepositoryInterface;

public class RepositoryFactory {
    private ArticleRepository articleRepository;
    private DepartmentRepository departmentRepository;
    private OrderRepository orderRepository;
    private OrderruleRepository orderruleRepository;
    private ShoppinglistRepository shoppinglistRepository;
    private UserRepository userRepository;
    private WalkRouteRepository walkRouteRepository;

    public RepositoryFactory()
    {

    }

    public ArticleRepository getArticleRepository()
    {
        if (null == this.articleRepository) {
            this.articleRepository = new ArticleRepository();
        }

        return this.articleRepository;
    }

    public DepartmentRepository getDepartmentRepository()
    {
        if (null == this.departmentRepository) {
            this.departmentRepository = new DepartmentRepository();
        }

        return this.departmentRepository;
    }

    public OrderRepository getOrderRepository()
    {
        if (null == this.orderRepository) {
            this.orderRepository = new OrderRepository();
        }

        return this.orderRepository;
    }

    public OrderruleRepository getOrderruleRepository()
    {
        if (null == this.orderruleRepository) {
            this.orderruleRepository = new OrderruleRepository();
        }

        return this.orderruleRepository;
    }

    public ShoppinglistRepository getShoppinglistRepository()
    {
        if (null == this.shoppinglistRepository) {
            this.shoppinglistRepository = new ShoppinglistRepository();
        }

        return this.shoppinglistRepository;
    }

    public UserRepository getUserRepository()
    {
        if (null == this.userRepository) {
            this.userRepository = new UserRepository();
        }

        return this.userRepository;
    }

    public WalkRouteRepository getWalkRouteRepository()
    {
        if (null == this.walkRouteRepository) {
            this.walkRouteRepository = new WalkRouteRepository();
        }

        return this.walkRouteRepository;
    }
//    private ArticleRepository articleRepository;
//    private DepartmentRepository departmentRepository;
//    private OrderRepository orderRepository;
//    private OrderruleRepository orderruleRepository;
//    private ShoppinglistRepository shoppinglistRepository;
//    private WalkRouteRepository walkRouteRepository;
//
//    private ArrayList<Article> articles;
//    private ArrayList<Department> departments;
//    private ArrayList<Order> orders;
//    private ArrayList<Shoppinglist> shoppinglists;
//
//    public RepositoryFactory(ArticleRepository articleRepository, DepartmentRepository departmentRepository, OrderRepository orderRepository, OrderruleRepository orderruleRepository, ShoppinglistRepository shoppinglistRepository, WalkRouteRepository walkRouteRepository) {
//        this.articleRepository = articleRepository;
//        this.departmentRepository = departmentRepository;
//        this.orderRepository = orderRepository;
//        this.orderruleRepository = orderruleRepository;
//        this.shoppinglistRepository = shoppinglistRepository;
//        this.walkRouteRepository = walkRouteRepository;
//
//        //TODO: Implement interfaces
//        this.articles = this.articleRepository.get();
//        this.departments = this.departmentRepository.get();
//        this.orders = this.orderRepository.get();
//        this.shoppinglists = this.shoppinglistRepository.get();
//    }
//
//    public ArrayList<Shoppinglist> getShoppinglists() {
//        return this.shoppinglists;
//    }
//
//    public Shoppinglist showShoppinglist(int id) {
//        for (Shoppinglist shoppinglist : getShoppinglists()) {
//            if (id == shoppinglist.id) {
//                return shoppinglist;
//            }
//        }
//
//
//        return null;
//    }
//
//    public Shoppinglist createShoppingList(int id, LocalDate date, ArrayList<Order> orders, WalkRoute walkRoute) {
//        return new Shoppinglist(id, date, orders, walkRoute);
//    }
//
//    public Boolean storeShoppingList(Shoppinglist shoppinglist) {
//        try{
//            this.shoppinglists.add(shoppinglist);
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }
//    }
//
//    public boolean storeOrder(Shoppinglist shoppinglist, Order order) {
//        try{
//            for (Shoppinglist list : this.shoppinglists) {
//                if (list.id == shoppinglist.id) {
////                    if (shoppinglist.orders == null) {
////                        ArrayList<Order> orders = new ArrayList<Order>();
////                        orders.add(order);
////                        shoppinglist.orders = orders;
////                    } else {
//                        shoppinglist.orders.add(order);
////                    }
//                }
//            }
//
//            return true;
//        }
//        catch(Exception e){
//            return false;
//        }
//    }
//
//    public Orderrule createOrderrule(Article article, int amount) {
//        return new Orderrule(article, amount);
//    }
}
