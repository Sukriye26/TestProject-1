package org.example;

import java.util.Scanner;

public class Main {
    static Account account = new Account();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------- PRİM HESAPLAMA SİSTEMİNE HOŞGELDİNİZ ----------");
        System.out.println("Çalışan sicil numaranızı giriniz: ");
        int employeeId = scanner.nextInt();
        /*if (!EmployeeRepository.isEmployeeExist(employeeId)) {
            System.out.println("Bu ID'ye sahip bir çalışan bulunamadı.");
            return;
        }
         */
        System.out.println("Hangi yıl ve ay için hesaplama yapmak istiyorsunuz?: (yyyy boşluk aa) ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        System.out.print("Ay içinde kullandığınız izin gün sayısını giriniz: ");
        int leaveDays = scanner.nextInt();

        account.salaryWizard(employeeId,leaveDays,year,month,0);

        scanner.close();

    }

}
