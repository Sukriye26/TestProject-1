package org.example;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;
    private String surname;
    private double birthDate;
    private LocalDateTime startingDate;
    private String email;
    private int leaveDays;
    private String companyName;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;
    @ManyToOne
    @JoinColumn(name = "positionId")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private Status status;

    private static int nextEmployeeId = 1;

    List<Employee> allEmployees;

    public Employee(String name, String surname, double salary, String companyName) {
        this.id = nextEmployeeId++;
        this.name = name;
        this.surname = surname;
        this.email = generateEmail(name, surname);
        this.salary = salary;
        this.companyName = companyName;
    }
    public Employee(){

    }



    private String generateEmail(String name, String surname) {
        return name.toLowerCase().strip() + "." + surname.toLowerCase().strip() + "@company.com";
    }


    public void setDepartment(Department newDepartment) {
        if (this.department != null) {
            // Mevcut departmanı bul
            Department oldDepartment = this.department;
            if (oldDepartment != null) {
                // Çalışanı eski departmandan çıkar
                oldDepartment.removeEmployee(this);
            }
        }
        // Yeni departmanı ata
        this.department = newDepartment;

        // Yeni departmanı bul
         if (newDepartment != null) {
            // Çalışanı yeni departmana ekle
            newDepartment.addEmployee(this);
        }
    }
    public double setSalary(double newSalary){
        this.salary = newSalary;
        return salary;
    }

    public String getEmail() {

        return email;
    }

    public double getSalary() {
        return salary;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }



}
