import java.time.LocalTime;

public class TimeWorked {
    private LocalTime startTime;
    private LocalTime endTime;

    public TimeWorked(LocalTime startTime, LocalTime endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "TimeWorked{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
