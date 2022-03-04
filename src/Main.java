import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // File Reader
        List<String> listOfEachLine = readLinesFromFile("input1.txt"); // Calls readLinesFromFile function

        // Create a list of the object Schedule Employee
        List<ScheduleEmployee> scheduleEmployeeList = getListOfEmployees(listOfEachLine);

        // Print my list in the Console to Verify Functionality
        printListOfEmployeesWithSchedule(scheduleEmployeeList);

        // Compare All items in the List
        Map<String, Integer> result = compareListOfEmployees(scheduleEmployeeList);

        printItems(result);

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
            System.out.print(name);

            String[] scheduleAsArray = nameAndSchedule[1].split(","); // Split schedule as array
            System.out.println(Arrays.toString(scheduleAsArray));

            Map<String, TimeWorked> schedule = convertScheduleToMap(scheduleAsArray); // Calls convertScheduleToMap Function

            ScheduleEmployee scheduleEmployee = new ScheduleEmployee(name, schedule); // Create a new object each loop

            scheduleEmployeeList.add(scheduleEmployee); // Add Object to the Schedule Employee List
        }

        return scheduleEmployeeList;
    }

    public static Map<String, TimeWorked> convertScheduleToMap (String[] days){
        Map<String, TimeWorked> daysTimeMap = new LinkedHashMap<>(); // Saves entries in order

        for(String day : days){
            String dayName = day.substring(0, 2); // MO TU WE TH FR SA SU
            String[] times = day.substring(2).split("-"); // 10:00-12:00

            LocalTime startTime = LocalTime.parse(times[0]); // 10:00
            LocalTime endTime = LocalTime.parse(times[1]); // 12:00

            TimeWorked timeWorked = new TimeWorked(startTime, endTime); // Create new Object each loop

            daysTimeMap.put(dayName, timeWorked); // Key: MO, Value=10:00-12:00
        }

        return daysTimeMap;
    }

    public static void printListOfEmployeesWithSchedule(List<ScheduleEmployee> scheduleEmployeeList){
        for(ScheduleEmployee scheduleEmployee: scheduleEmployeeList){ // Verify functionality of Schedule Employee List
            System.out.println(scheduleEmployee.toString());
        }
    }

    public static Map<String, Integer> compareListOfEmployees(List<ScheduleEmployee> scheduleEmployeeList){
        Map<String, Integer> employeesMatchTimes = new HashMap<>();

        for(int i = 0; i < scheduleEmployeeList.size(); i++){
            //System.out.println("Value of i: " + scheduleEmployeeList.get(i).getName());
            for(int j = i+1; j < scheduleEmployeeList.size(); j++){
                //System.out.println("Value of j: " + scheduleEmployeeList.get(j).getName());
                int daysWorkedTogether = compareTimesAndDays(scheduleEmployeeList.get(i).getSchedule(), scheduleEmployeeList.get(j).getSchedule());
                employeesMatchTimes.put(scheduleEmployeeList.get(i).getName() + "-" + scheduleEmployeeList.get(j).getName(), daysWorkedTogether);
            }
        }

        return employeesMatchTimes;
    }

    public static int compareTimesAndDays(Map<String, TimeWorked> schedule1, Map<String, TimeWorked> schedule2){
        System.out.println("Employee 1: " + schedule1);
        System.out.println("Employee 2: " + schedule2);
        int counter = 0;

        for(Map.Entry<String, TimeWorked> entry : schedule1.entrySet()){
            String currentKey = entry.getKey(); // KEY dayName: MO
            if(schedule2.containsKey(currentKey)){
                boolean haveWorkedTogether = haveTheyWorkedInTheSameDay(schedule1.get(currentKey), schedule2.get(currentKey));
                counter += haveWorkedTogether ? 1 : 0;
            }
        }

        return counter;
    }

    public static boolean haveTheyWorkedInTheSameDay(TimeWorked timeWorkedEmployee1, TimeWorked timeWorkedEmployee2){
        return timeWorkedEmployee1.getStartTime().isBefore(timeWorkedEmployee2.getEndTime()) && timeWorkedEmployee1.getEndTime().isAfter(timeWorkedEmployee2.getStartTime());
    }

    public static void printItems(Map<String, Integer> result){
        for(Map.Entry<String, Integer> entry : result.entrySet()){
            String currentKey = entry.getKey();
            int currentValue = entry.getValue();
            System.out.println(currentKey + ": " + currentValue);
        }
    }
}
