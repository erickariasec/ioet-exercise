import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<String> listOfEachLine = new ArrayList<>();

        try {
            File myObj = new File("input1.txt");
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

        for (String line : listOfEachLine){
            System.out.println(line);
        }
    }
}
