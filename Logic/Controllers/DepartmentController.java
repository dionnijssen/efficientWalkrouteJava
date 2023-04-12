package Logic.Controllers;

import DataLayer.DepartmentRepository;

public class DepartmentController {
    DepartmentRepository departmentRepo;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepo = departmentRepository;
    }

    //Maybe a setOrder method is required.
}
