package org.example.Entity;
import lombok.Getter;

import java.time.LocalDate;

public class LeaveDays {
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    // calculate (endDate-startDate)
    @Getter
    private int durationInDays; // İzin süresi
    private Reason reason;

    // Constructor, Getter ve Setter metodları
    public LeaveDays(int employeeId, int durationInDays, Reason reason) {
        // Burada DB'ye gidip çalışanın izinleri alınmış gibi
        this.employeeId = employeeId;
        this.durationInDays=3;
        this.reason = reason;
    }

}