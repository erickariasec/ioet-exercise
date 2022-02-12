import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> listOfEachLine = readLinesFromFile("input1.txt"); // Calls readLinesFromFile function

        // Create a list of the object Schedule Employee
        List<ScheduleEmployee> scheduleEmployeeList = getListOfEmployees(listOfEachLine);

        for(ScheduleEmployee scheduleEmployee: scheduleEmployeeList){ // Verify functionality of Schedule Employee List
            System.out.println(scheduleEmployee.toString()); 
        }
    }

    // Create function to return list Of Each Line
    public static List<String> readLinesFromFile(String fileName){
        List<String> listOfEachLine = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // Add each line to my list
                listOfEachLine.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Check if the file exists!");
            e.printStackTrace();
        }
        return listOfEachLine;
    }

    public static List<ScheduleEmployee> getListOfEmployees(List<String>listOfEachLine){
        List<ScheduleEmployee> scheduleEmployeeList = new ArrayList<>();

        // Iterate my list to print in console each line
        for (String line : listOfEachLine){
            String[] nameAndSchedule = line.split("="); // Split returns an array

            String name = nameAndSchedule[0];
            System.out.println(name);

            String[] scheduleAsArray = nameAndSchedule[1].split(","); // Split schedule as array
            System.out.println(scheduleAsArray);

            Map<String, TimeWorked> schedule = convertScheduleToMap(scheduleAsArray); // Calls convertScheduleToMap Function

            ScheduleEmployee scheduleEmployee = new ScheduleEmployee(name, schedule); // Create a new object each loop

            scheduleEmployeeList.add(scheduleEmployee); // Add Object to the Schedule Employee List
        }

        return scheduleEmployeeList;
    }

    public static Map<String, TimeWorked> convertScheduleToMap (String[] days){
        Map<String, TimeWorked> daysTimeMap = new LinkedHashMap<>();

        for(String day : days){
            String dayName = day.substring(0, 2); // MO TU WE TH FR SA SU
            String[] times = day.substring(2).split("-"); // 10:00-12:00

            LocalTime startTime = LocalTime.parse(times[0]);
            LocalTime endTime = LocalTime.parse(times[1]);

            TimeWorked timeWorked = new TimeWorked(startTime, endTime); // Create new Object each loop

            daysTimeMap.put(day, timeWorked); // MO10:00-12:00
        }

        return daysTimeMap;
    }
}
