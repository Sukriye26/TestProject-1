package org.example;

import org.hibernate.jdbc.Work;

public class Account {

    Employee employee = new Employee(2,30000);

    WorkDays workDays = new WorkDays();
    public double salaryWizard(int employeeId, int leaveDays, int year, int month, int holidayDays) {

        int totalWorkDays = workDays.calculateWorkDays(year,month,holidayDays);
        int actualWorkDays = totalWorkDays - leaveDays;
        int extraDay = Math.max(actualWorkDays - 25, 0);
        int primAmount = 1000;

        //double salary = employee.getSalary();
        double salary = getSalaryByEmployeeId(2);

        // 25'ten fazla çalışma günü varsa prim hesaplama
        salary += (extraDay> 0) ? extraDay*1000 : 0;

        System.out.println("aylık fazla çalışılan gün sayısı: " + extraDay + "\naylık prim tutarı: " + extraDay*primAmount );

        return salary;
    }
    public double getSalaryByEmployeeId(int employeeId) {
        Employee employee = new Employee(employeeId);
        return employee.getSalary();
    }

}