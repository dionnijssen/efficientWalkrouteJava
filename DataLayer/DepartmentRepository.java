package DataLayer;

import Logic.Models.Department;

import java.util.ArrayList;

public class DepartmentRepository {
    private ArrayList<Department> departments;
    public DepartmentRepository() {
        this.departments = new ArrayList<Department>();

//        ArrayList<Department> departments = new ArrayList<>();
//        ArrayList<Article> articles = new ArrayList<Article>();
//
//        departments.add(
//                new Department(
//                        1,
//                        "Groente",
//                        1,
//                        articles
//                ));
//
//        departments.add(
//                new Department(
//                        2,
//                        "Fruit",
//                        2,
//                        articles
//                ));
//
//        departments.add(
//                new Department(
//                        3,
//                        "Drank",
//                        3,
//                        articles
//                ));
    }

    public ArrayList<Department> get() {
        return this.departments;
    }

    public Department show(int id){
        for (Department department :  (get())) {
            if (department.id == id) {
                return department;
            }
        }

        return null;
    }

    public boolean create(Department department){
        return this.departments.add(department);
    }

    public boolean update(Department department){
        for (int i = 0; i < this.departments.size(); i++) {
            if (departments.get(i).id == department.id){
                departments.set(i, department);

                return true;
            }
        }

        return false;
    }

    public boolean delete(Department department){
        for (int i = 0; i < this.departments.size(); i++) {
            if (departments.get(i).id == department.id){
                departments.remove(i);

                return true;
            }
        }

        return false;
    }
}
