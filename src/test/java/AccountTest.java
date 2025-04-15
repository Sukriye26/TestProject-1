import org.example.Account;
import org.example.Company;
import org.example.Employee;
import org.example.WorkDays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.WorkDays;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Company company;
    private Employee employee;
    private  Account account;
    private WorkDays workDays;

    @BeforeEach
    void setUp() {
        company = new Company("Test Company");
        employee = new Employee("John", "Doe", 5000,company.getCompanyName());
        account = new Account();
        company.addEmployee(employee);
        workDays = new WorkDays();
    }


    @Test
    void testValidEmployeeBonusCalculation() {
        int employeeId = employee.getId();
        int year = 2024;
        int month = 1;
        int holidays = 0; // Resmi tatil günleri
        int leaveDays = 1; // İzin günleri
        int companyWorkingDays = 6; // Haftada 6 gün çalışıyor

        double expectedBonus = 1000;
        company.findEmployeeById(employeeId).setLeaveDays(leaveDays);
        int actualWorkingDays =  workDays.calculateWorkDays(year, month, companyWorkingDays, holidays, company.findEmployeeById(employeeId).getLeaveDays());
        double actualBonus = account.primWizard(actualWorkingDays);
        //System.out.println("expected Bonus: " + expectedBonus + " actual Bonus: " + actualBonus);
        assertEquals(expectedBonus, actualBonus);
    }


    @Test
    void testEmployeeNotFound() {
        /*
        int invalidEmployeeId = 9999;


        assertThrows(EmployeeNotFoundException.class, () -> {
            BonusCalculator.calculateBonus(company, invalidEmployeeId, 2023, 5, 0, 0);
        });

         */
    }
    // Diğer test metotları
}

