package org.example;

import java.util.Calendar;

public class WorkDays {
    static Calendar calendar = Calendar.getInstance();

    private int holidayDays;
    private int weekendDays;
    private int leaveDays;
    private int workingDaysPerWeek;
    private int workDays;

    public WorkDays() {

        this.holidayDays = 0;
        this.weekendDays = 0;
        this.workDays = 0;
        this.leaveDays = 0;
        this.workingDaysPerWeek = 0;
    }

    public int calculateWorkDays(int year, int month, int companyWorkingDays, int holidayDays, int leaveDays) {
        int totalDaysInMonth = getTotalDaysInMonth(year, month);

        this.holidayDays = holidayDays;
        this.weekendDays = getWeekendDays(year, month, companyWorkingDays);
        this.workDays = totalDaysInMonth - this.holidayDays - weekendDays - leaveDays;
        return  workDays;
    }

    private int getTotalDaysInMonth(int year, int month) {
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    private int getWeekendDays(int year, int month, int workingDaysPerWeek) {
        int weekendDays = 0;
        int totalDaysInMonth = getTotalDaysInMonth(year, month);

        for (int day = 1; day <= totalDaysInMonth; day++) {
            calendar.set(year, month - 1, day);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            boolean isWeekend = false;

            if (workingDaysPerWeek == 6) {
                isWeekend = (dayOfWeek == Calendar.SUNDAY);
            }
            else if (workingDaysPerWeek == 5) {
                isWeekend = (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
            }
            else if (workingDaysPerWeek == 4) {
                isWeekend = (dayOfWeek == Calendar.FRIDAY ||dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
            }

            if (isWeekend) {
                weekendDays++;
            }
        }
        return weekendDays;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkingDaysPerWeek(int workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

}