package org.example;
import java.time.LocalDate;

public class LeaveDays {
    private int employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int durationInDays; // İzin süresi
    private String reason;

    // Constructor, Getter ve Setter metodları
    public LeaveDays(int employeeId, int durationInDays) {
        // Burada DB'ye gidip çalışanın izinleri alınmış gibi
        this.employeeId = employeeId;
        this.durationInDays=3;
    }

    public int getDurationInDays() {
        // calculate (endDate-startDate)
        return durationInDays;
    }
}