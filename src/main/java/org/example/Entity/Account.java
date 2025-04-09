package org.example.Entity;

public class Account {

    public double primWizard(int actualWorkDays) {
        int days = 10;
        int extraDay = Math.max(actualWorkDays - days, 0);
        double additionalAmount = 1000;
        double totalPrimAmount = 0;
        // 25'den fazla çalışma günü varsa prim hesaplama
        totalPrimAmount += (extraDay> 0) ? extraDay*additionalAmount : 0;
        System.out.println("aylık " + days +"'den fazla çalışılan gün sayısı: " + extraDay + "\naylık prim tutarı: " + extraDay*additionalAmount );
        return totalPrimAmount;
    }
}