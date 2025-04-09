package org.example;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
@Entity
@Data
public class Employee {
    @Id
    @Getter
    private int id;
    private String name;
    @Getter
    private double salary;
    private int departmentId;
    private String surname;
    private double birthDate;
    private int positionId;
    private LocalDateTime startingDate;
    private int addressId;
    private int staffId;
    private String email;
    @Getter
    public int leaveDays;


    public Employee(int id, double salary){
        this.id = id;
        this.salary = salary;
    }

    public Employee (int id){
        this.id = id;
    }

    public Employee(String name, double salary, int departmentId, String surname, double birthDate, int positionId, Gender gender, LocalDateTime startingDate, int addressId, int staffId, String email, Status status) {
        this.name = name;
        this.id = setEmployeeId() ;
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

    private int setEmployeeId(){

        return 1;
    }

    public double getSalaryByEmployeeId(int employeeId){
        return salary;
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

}
