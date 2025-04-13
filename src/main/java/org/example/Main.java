package org.example;

import java.util.Scanner;

public class Main {
    static Company company = null;
    static Department department = null;
    static WorkDays workDays = new WorkDays();
    static Account account = new Account();
    static Employee employee = new Employee();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("---------- HOŞGELDİNİZ ----------");
        System.out.println("Firma ismi giriniz: (Firma ismi girilmeden devam edilemez. Çıkış için 9 tuşlayabilirsiniz.)");
        String companyName = scanner.nextLine().trim();

        if (companyName.equals("9")) {
            System.out.println("Çıkış yapılıyor...");
        } else {
            company = new Company(companyName);
            System.out.println(companyName + " için ana menüye yönlendiriliyorsunuz . . . ");
            showMenu(company);
        }


    }

    public static void showMenu(Company company) {
        int choice = 0;


            System.out.println("---- Ana Menü ----");
            System.out.println("1. Çalışan Listele");
            System.out.println("2. Prim Hesapla");
            System.out.println("3. Departman Oluştur");
            System.out.println("4. Çalışan Ekle");
            System.out.println("5. Çalışan Departman Değişikliği");
            System.out.println("9. Çıkış");
            System.out.print("Seçiminizi yapın (1-9): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    listEmployees(company);
                    break;
                case 2:
                    calculateBonus(company);
                    break;
                case 3:
                    createDepartment(company);
                    break;
                case 4:
                    addEmployee(company);
                    break;
                case 5:
                    changeDepartment(company);
                    break;
                case 9:
                    System.out.println("Çıkış yapılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
                    break;
            }

    }

    public static void listEmployees(Company company) {
        if (company.listAllEmployees().isEmpty()){
            System.out.println(company.getCompanyName() + " için çalışan bulunamadı. Çalışan eklemek için ana menüye yönlendiriliyorsunuz . . .");
            showMenu(company);
        }
        else {
            for (Employee emp : company.listAllEmployees()) {
                System.out.println(emp.getName() + " " + emp.getSurname() + " " + emp.getDepartment());
            }
        }
        System.out.println("Çalışan listeleme işlemi tamamlandı. \n Ana menüye yönlendiriliyorsunuz . . .");
        showMenu(company);
    }
    public static void calculateBonus(Company company) {
        if(company.listAllEmployees().isEmpty()){
            System.out.println(company.getCompanyName() + " için çalışan bulunamadı. Prim hesaplama yapılamaz. Çalışan eklemek için ana menüye yönlendiriliyorsunuz . . .");
            showMenu(company);
        }
        else {
            System.out.println("Çalışan ID'sini girin:");
            int employeeId = scanner.nextInt();
            if (!company.isEmployeeExist(employeeId)) {
                System.out.println("Çalışan sistemde bulunamadı. \n Ana menüye yönlendiriliyorsunuz . . .");
                showMenu(company);
            } else {
                //burada çalışana ya da departmana göre de ayrıştırma yapılabilir.
                System.out.println(company.getCompanyName() + " için haftada kaç gün çalışılıyor? : ");
                int companyWorkingDays = scanner.nextInt();
                employee = company.findEmployeeById(employeeId);
                System.out.println("Hangi yıl ve ay için hesaplama yapmak istiyorsunuz?: (yyyy boşluk aa) ");
                int year = scanner.nextInt();
                int month = scanner.nextInt();

                System.out.println(year + " yılının " + month + ". ayında resmi tatil olan gün sayısı nedir?:");
                int holidays = scanner.nextInt();
                //çalışanın izin kullandığı günleri burada almak ve setlemek ne kadar mantıklı, bilmiyorum
                System.out.print(year + " yılının " + month + ". ayında çalışanın izin kullandığı gün sayısı nedir?:");
                company.findEmployeeById(employeeId).setLeaveDays(scanner.nextInt());
                int totalWorkingDays = workDays.calculateWorkDays(year, month, companyWorkingDays, holidays, company.findEmployeeById(employeeId).getLeaveDays());
                double primAmount = account.primWizard(totalWorkingDays);
                //currency formatlama yapılabilir.
                System.out.println(year + " yılı, " + month + " nolu ay için ödenen toplam maaş tutarı: " + (company.findEmployeeById(employeeId).getSalary() + primAmount) + " TL");
            }
        }
        System.out.println("Prim hesaplama işlemi tamamlandı. \n Ana menüye yönlendiriliyorsunuz . . .");
        showMenu(company);
    }
    public static void createDepartment(Company company) {
        System.out.println("Kaç departman eklemek istiyorsunuz?");
        int departmentCount = scanner.nextInt();
        for (int i = 0; i < departmentCount; i++) {
            System.out.println("Departman adı girin:");
            String departmentName = scanner.nextLine();
            Department department = new Department(departmentName);
            company.addDepartment(department);
        }
        System.out.println("Departman ekleme işlemi tamamlandı." + company.getCompanyName() + " için eklenen departmanlar: \n");
        for (Department department : company.listAllDepartments()) {
            System.out.println(department.getDescription());
        }
        System.out.println("Ana menüye yönlendiriliyorsunuz . . .");
        showMenu(company);
    }
    public static void addEmployee(Company company) {
        System.out.println("Kaç çalışan eklemek istiyorsunuz?");
        int employeeCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < employeeCount; i++) {
            System.out.println((i+1) + ". çalışan adı:");
            String name = scanner.nextLine();
            System.out.println((i+1) + ". çalışan soyadı:");
            String surname = scanner.nextLine();
            System.out.println((i+1) + ". çalışan maaşı:");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            Employee employee = new Employee(name, surname, salary, company.getCompanyName());
            company.addEmployee(employee);
            System.out.println("--------------------------------------------");
        }
        System.out.println("Çalışan ekleme işlemi tamamlandı.\n" + company.getCompanyName() + " için eklenen yeni çalışanlar: \n");
        for (Employee emp : company.listAllEmployees()){
            System.out.println("ad soyad:" +emp.getName() + " " + emp.getSurname() + " departman: " + emp.getDepartment());
        }
        System.out.println("Ana menüye yönlendiriliyorsunuz . . .");
        showMenu(company);
    }
    public static void changeDepartment(Company company) {
        System.out.println("Çalışan ID'sini girin:");
        int employeeId = scanner.nextInt();
        if (!company.isEmployeeExist(employeeId)){
            System.out.println("Çalışan sistemde bulunamadı. \n Çalışan bilgilerini düzenlemek için ana menüye yönlendiriliyorsunuz . . .");
            showMenu(company);
        }
        else {
            System.out.println("Yeni departman ID'sini girin:");
            int departmentId = scanner.nextInt();

            if (!company.isDepartmentExist(departmentId)) {
                System.out.println("İlgili departman sistemde bulunamadı. \n Departman bilgilerini düzenlemek için ana menüye yönlendiriliyorsunuz . . .");
                showMenu(company);
            } else {
                department = Company.getDepartmentById(departmentId);
                company.findEmployeeById(employeeId).setDepartment(department);
            }
        }
        System.out.println("Departmen degiştirme işlemi tamamlandı." + company.findEmployeeById(employeeId).getName() + " " + company.findEmployeeById(employeeId).getSurname()  + " için yeni departman: " + department.getDescription());
        System.out.println("Ana menüye yönlendiriliyorsunuz . . .");
        showMenu(company);
    }

}