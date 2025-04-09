package org.example;

import org.example.Entity.Account;
import org.example.Entity.Employee;
import org.example.Entity.WorkDays;

import java.util.Scanner;

public class Main {
    static Account account = new Account();
    static Employee employee = new Employee();
    static WorkDays workDays = new WorkDays();

    public static void main(String[] args) {
        int tryCount = 0;
        boolean isEmployeeExist = false;
        int[] calisanlar = {1,2,3};

        Scanner scanner = new Scanner(System.in);
        System.out.println("---------- PRİM HESAPLAMA SİSTEMİNE HOŞGELDİNİZ ----------");
        //System.out.println("Çalışan sicil numaranızı giriniz: ");
        //int employeeId = scanner.nextInt();

        do {
            System.out.println("Çalışan sicil numaranızı giriniz: ");
            int employeeId = scanner.nextInt();
            tryCount++;
            isEmployeeExist = employee.isEmployeeExist(1);
            if (isEmployeeExist) {
                break;
            } else {
                System.out.println("Girilen sicil numarası sistemde bulunamadı. Lütfen");
            }

        }while (!isEmployeeExist && tryCount < 3) ;
        if (!isEmployeeExist) {
            System.out.println("3 kez yanlış giriş yaptınız, sistemden kapatılıyor.");
        }
        //yıl ve ay doğrulaması yapmak gerekiyor xxxx'den küçük ve büyük girilemez yy ve yy arasında olmalı şeklinde
        System.out.println("Hangi yıl ve ay için hesaplama yapmak istiyorsunuz?: (yyyy boşluk aa) ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        System.out.print("Ay içinde kullandığınız izin gün sayısını giriniz: ");
        int leaveDays = scanner.nextInt();
        //ay içinde resmi tatil günü olmadığını varsayıyorum.
        int totalWorkingDays = workDays.calculateWorkDays(year,month,0,leaveDays);
        double primAmount = account.primWizard(totalWorkingDays);
        //currency formatlama yapılabilir.
        System.out.println( year + " yılı, " + month +" nolu ay için ödenen toplam maaş tutarı: " + (employee.getSalary()+primAmount) + " TL");
        scanner.close();
    }
}
