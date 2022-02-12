import java.util.List;
import java.util.Map;

public class ScheduleEmployee {
    private String name;
    private Map<String, TimeWorked> schedule;

    public ScheduleEmployee(String name, Map<String, TimeWorked> schedule){
        this.name = name;
        this.schedule = schedule;
    }

    public String getName() {
        return name;
    }

    public Map<String, TimeWorked> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "ScheduleEmployee{" +
                "name='" + name + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}
