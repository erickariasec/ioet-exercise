import java.util.List;

public class ScheduleEmployee {
    private String name;
    private String schedule;

    public ScheduleEmployee(String name, String schedule){
        this.name = name;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }
}
