package org.example;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private final List<Department> departments;
    private final String companyName;

    static List<Employee> allEmployeesList = new ArrayList<>();
    static List<Department> allDepartmentsList = new ArrayList<>();

    public Company(String companyName) {
        this.departments = new ArrayList<>();
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addDepartment(Department department) {
        allDepartmentsList.add(department);
        System.out.println("Departman eklendi: " + department.getDescription());
    }

    public void removeDepartment(Department department) {
        if (departments.contains(department)) {
            if (!department.listEmployees().isEmpty()) {
                for (Employee employee : department.listEmployees()) {
                    employee.setDepartment(null);  // Departman bilgilerini boşaltıyoruz, buradaki -1 geçici bir değer olabilir
                    //System.out.println(employee.getName()  +" " + employee.getSurname() +" için departman bilgisi boşaltıldı.");
                }
            }
            departments.remove(department);
            System.out.println("Departman kaldırıldı: " + department.getDescription());
        } else {
            System.out.println("Departman bulunamadı.");
        }
    }

    public List<Department> listAllDepartments() {

        if (departments.isEmpty()) {
            System.out.println("Hiç departman yok.");
            return this.departments !=null ? this.departments : new ArrayList<>();
        } else {
            return departments;
        }
        //return departments.isEmpty() ? Collections.emptyList() : departments;
    }

    public List<Employee> listAllEmployees() {
        return allEmployeesList;
    }

    public void addEmployee(Employee employee) {
        allEmployeesList.add(employee);
    }

    public boolean isEmployeeExist (int employeeId){
        if (allEmployeesList == null){
            return false;
        }
        for (Employee employee : allEmployeesList) {
            if (employee.getId() == employeeId) {
                return true;
            }
        }
        return false;
    }
    public boolean isDepartmentExist(int departmentId) {
        if (allDepartmentsList == null){
            return false;
        }
        for (Department department: allDepartmentsList){
            if (department.getDepartmentId() == departmentId){
                return true;
            }

        }
        return  false;
    }

    public Employee findEmployeeById(int employeeId) {
        for (Employee emp : allEmployeesList) {
            if (emp.getId() == employeeId) {
                return emp;
            }
        }

        return null;
    }

    public static Department getDepartmentById(int departmentId) {
        for (Department department : allDepartmentsList) {
            if (department.getDepartmentId() == departmentId) {
                return department;
            }
        }
        return null;
    }
}
