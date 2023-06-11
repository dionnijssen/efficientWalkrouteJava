package DataLayer;

import Logic.Interfaces.Data.RepositoryInterface;
import Logic.Models.Department;

import java.util.ArrayList;

public class DepartmentRepository implements RepositoryInterface<Department> {
    private ArrayList<Department> departments;
    public DepartmentRepository() {
        this.departments = new ArrayList<Department>();

        ArrayList<Department> departments = new ArrayList<>();

        ArrayList<Integer> groentes  = new ArrayList<Integer>();
        groentes.add(1);

        departments.add(
                new Department(
                        1,
                        "Fruit",
                        1,
                        groentes
                ));

        ArrayList<Integer> drinks  = new ArrayList<Integer>();
        drinks.add(2);
        drinks.add(3);
        departments.add(
                new Department(
                        2,
                        "Drinks",
                        2,
                        drinks
                ));

        this.departments = departments;
    }

    public ArrayList<Department> get() {
        return this.departments;
    }

    public Department show(int id){
        for (Department department :  (get())) {
            if (department.getId() == id) {
                return department;
            }
        }

        return null;
    }

    public Department store(Department department){
        this.departments.add(department);
        return department;
    }

    public Department update(Department department){
        for (int i = 0; i < this.departments.size(); i++) {
            if (departments.get(i).getId() == department.getId()){
                departments.set(i, department);

                return department;
            }
        }

        return null;
    }

    public boolean delete(Department department){
        for (int i = 0; i < this.departments.size(); i++) {
            if (departments.get(i).getId() == department.getId()){
                departments.remove(i);

                return true;
            }
        }

        return false;
    }
}
