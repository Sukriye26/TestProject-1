package org.example;
import lombok.Getter;

import java.time.LocalDate;

public class LeaveDays {
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    // calculate (endDate-startDate)

    public int getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }

    private int durationInDays; // İzin süresi
    private LeaveReason reason;

    // Constructor, Getter ve Setter metodları
    public LeaveDays(int employeeId, int durationInDays, LeaveReason reason) {
        // Burada DB'ye gidip çalışanın izinleri alınmış gibi
        this.employeeId = employeeId;
        this.durationInDays=3;
        this.reason = reason;
    }

}