package Logic.Controllers;

import DataLayer.DepartmentRepository;
import Logic.Interfaces.DepartmentControllerInterface;

public class DepartmentController implements DepartmentControllerInterface {
    DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepo = departmentRepository;
    }
}
