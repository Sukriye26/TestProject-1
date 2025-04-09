package org.example.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
public class Employee {

    @Id
    public int id;
    private String name;
    private double salary;
    private int departmentId;
    private String surname;
    private double birthDate;
    private int positionId;
    private LocalDateTime startingDate;
    private int addressId;
    private int staffId;
    private String email;
    public int leaveDays;


    public Employee(int id, double salary){
        this.id = id;
        this.salary = salary;
    }

    public Employee(){
        this.id = id;
    }

    public Employee(int id, String name, double salary, int departmentId, String surname, double birthDate, int positionId, Gender gender, LocalDateTime startingDate, int addressId, int staffId, String email, Status status) {
        this.name = name;
        this.id = id ;
        this.salary = salary;
        this.departmentId = departmentId;
        this.surname = surname;
        this.birthDate = birthDate;
        this.positionId = positionId;
        this.gender = gender;
        this.startingDate = startingDate;
        this.addressId = addressId;
        this.staffId = staffId;
        this.email = email;
        this.status = status;
    }

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

    public double getSalary() {
        return 10000;
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

    public boolean isEmployeeExist (int employeeId){
        //employe var mı kodu gelecek
        return true;
    }


}
