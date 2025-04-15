package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Department {
    @Id
    private int departmentId;
    private String description;
    private static Company company;

    private List<Employee> employees = new ArrayList<>();
    //static List<Department> allDepartments = company.listAllDepartments();
    static private int nextDepartmentId = 1;

    public Department(String description) {
        this.departmentId = nextDepartmentId++;
        this.description = description;
    }

    public void addEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            employees.add(employee);
        }
        else{
            System.out.println("Mevcut bir çalışanı tekrar ekleyemezsiniz.");
        }
    }
    public void removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
        }
        else{
            System.out.println("Çalışan bulunamadı.");
        }
    }

    public List<Employee> listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Departmanda çalışan bulunamadı.");
            return employees;
        }
        else {
            return employees;
        }
    }


    public String getDescription() {
        return description;
    }

    public int getDepartmentId() {
        return departmentId;
    }


}
