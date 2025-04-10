package org.example.Entity;

import lombok.Getter;

import java.util.Calendar;

public class WorkDays {

    private int holidayDays; // O ayın tatil günlerinin sayısı
    private int weekendDays; // Haftasonu gün sayısı (Cumartesi ve Pazar)
    private int leaveDays;   //çalışanın izinli olduğu gün sayısı
    @Getter
    private int workDays;    // Hesaplanan çalışma günü sayısı


    public WorkDays() {

        this.holidayDays = 0;
        this.weekendDays = 0;
        this.workDays = 0;
        this.leaveDays =0;
    }

    // Aydaki çalışma günlerini hesaplayan metot
    public int calculateWorkDays(int year, int month, int holidayDays, int leaveDays) {
        int totalDaysInMonth = getTotalDaysInMonth(year, month);

        this.holidayDays = holidayDays;  // Resmi Tatil günleri - şimdilik dışardan almaya karar verdim.
        this.weekendDays = getWeekendDays(year, month);  // Haftasonu günleri

        // Çalışma gününü hesapla
        this.workDays = totalDaysInMonth - this.holidayDays - this.weekendDays- leaveDays;
        return  workDays;
    }

    // Ayın toplam gün sayısını döndüren metot, 31, 30, 28 olabilir.
    private int getTotalDaysInMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    // Haftasonu günlerini hesaplayan metot
    private int getWeekendDays(int year, int month) {
        int weekendDays = 0;
        int totalDaysInMonth = getTotalDaysInMonth(year, month);

        Calendar calendar = Calendar.getInstance();

        // O ayın her gününü kontrol et
        for (int day = 1; day <= totalDaysInMonth; day++) {
            calendar.set(year, month - 1, day);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            weekendDays += (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) ? 1 : 0;
        }
        return weekendDays;
    }

}