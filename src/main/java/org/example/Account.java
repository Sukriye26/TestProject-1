package org.example;

public class Account {

    public double primWizard(int actualWorkDays) {
        int days = 25;
        int extraDay = Math.max(actualWorkDays - days, 0);
        double additionalAmount = 1000;
        double totalPrimAmount = 0;

        totalPrimAmount += (extraDay> 0) ? extraDay*additionalAmount : 0;
        System.out.println("aylık " + days +"'den fazla çalışılan gün sayısı: " + extraDay + "\naylık prim tutarı: " + extraDay*additionalAmount );
        return totalPrimAmount;
    }
}