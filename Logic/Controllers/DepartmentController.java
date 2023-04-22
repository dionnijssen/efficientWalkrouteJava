package Logic.Controllers;

import DataLayer.DepartmentRepository;
import Logic.Interfaces.DepartmentInterface;

public class DepartmentController implements DepartmentInterface {
    DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepo = departmentRepository;
    }
}
