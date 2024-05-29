package com.example.bilabonnementeksamen.services;

import com.example.bilabonnementeksamen.enums.EmployeeUserDepartment;
import com.example.bilabonnementeksamen.models.EmployeeUser;
import com.example.bilabonnementeksamen.repositories.EmployeeUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeUserService {
    @Autowired
    private EmployeeUserRepository employeeUserRepository;


    public void addEmployee(String username, String password,
                            EmployeeUserDepartment employeeUserDepartment) {
        employeeUserRepository.addEmployee(username, password, employeeUserDepartment);
    }


    public List<EmployeeUser> getAllEmployees() {
        return employeeUserRepository.getAllEmployees();
    }

    public EmployeeUser getEmployee(int employeeId) {
        return employeeUserRepository.getEmployee(employeeId);
    }
}