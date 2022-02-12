import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> listOfEachLine = readLinesFromFile("input1.txt"); // Calls readLinesFromFile function

        // Create a list of the object Schedule Employee
        List<ScheduleEmployee> scheduleEmployeeList = getListOfEmployees(listOfEachLine);

        /*for(ScheduleEmployee scheduleEmployee: scheduleEmployeeList){ // Verify functionality of Schedule Employee List
            System.out.println(scheduleEmployee.toString()); 
        }*/
    }

    // Create function to return list Of Each Line
    public static List<String> readLinesFromFile(String fileName){
        List<String> listOfEachLine = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                // add each line to my list
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
            String[] nameAndSchedule = line.split("="); // split returns an array

            String name = nameAndSchedule[0];
            System.out.println(name);

            String[] schedule = nameAndSchedule[1].split(","); // split schedule
            System.out.println(schedule);


//            ScheduleEmployee scheduleEmployee = new ScheduleEmployee(name, schedule); // Create a new object each loop
//            scheduleEmployeeList.add(scheduleEmployee); // Add Object to the Schedule Employee List
        }
        return scheduleEmployeeList;
    }
}
