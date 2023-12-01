import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Day1v2 {
    

    public static void main(String[] args) {
        String filePath = "./inputdata.txt";

        try{
            Path path = Paths.get(filePath);
            ArrayList<String> lines = new ArrayList<String>(Files.readAllLines(path));


        Dictionary numbers = new Hashtable<>();

        numbers.put('1', 1);
        numbers.put('2', 2);
        numbers.put('3', 3);
        numbers.put('4', 4);
        numbers.put('5', 5);
        numbers.put('6', 6);
        numbers.put('7', 7);
        numbers.put('8', 8);
        numbers.put('9', 9);
        numbers.put('0', 0);

        numbers.put("one", 1);
        numbers.put("two", 2);
        numbers.put("three", 3);
        numbers.put("four", 4);
        numbers.put("five", 5);
        numbers.put("six", 6);
        numbers.put("seven", 7);
        numbers.put("eight", 8);
        numbers.put("nine", 9);

        ArrayList<String> numberString = new ArrayList<String>();
        numberString.add("one");
        numberString.add("two");
        numberString.add("three");
        numberString.add("four");
        numberString.add("five");
        numberString.add("six");
        numberString.add("seven");
        numberString.add("eight");
        numberString.add("nine");   


        int totalSum = 0;

        for(String line : lines){

        System.out.println(line);
        System.out.println(" ");

        int i = 0; //Coundter
        Character currentFrontChar = 'a';
        while (!Character.isDigit(currentFrontChar)) {
            currentFrontChar = (char) line.charAt(i);
            i++;
        }
        System.out.println("Before String check: ");
        System.out.println("currentFrontChar: " +currentFrontChar);


        int j = line.length();
        Character currentBackChar = 'a';
        while (!Character.isDigit(currentBackChar)) {
            currentBackChar = (char) line.charAt(j-1);
            j--;
        }

        System.out.println("currentBackChar: " + currentBackChar);
        System.out.println(" ");

        int frontInt = (int) numbers.get(currentFrontChar);

        int backInt = (int) numbers.get(currentBackChar);

        for(String number : numberString){
            if(line.contains(number)){
                int StringIndex = line.indexOf(number);
                
                if(StringIndex < i){frontInt = (int) numbers.get(number);}
                if(StringIndex > j){backInt = (int) numbers.get(number);}
            }

        }

        System.out.println("After String check: ");
        System.out.println("currentFrontChar: " +frontInt);
        System.out.println("currentBackChar: " + backInt);
        System.out.println(" ");

        frontInt = frontInt*10;

        int value = frontInt + backInt;

        System.out.println("Total adding value: " + value);

        totalSum = totalSum + value;
        System.out.println("After addition: " + totalSum);

        System.out.println("----------------------------------------------------------------------------------------------");
    }

    System.out.println("The total sum: " + totalSum);

}catch (IOException e) {
    e.printStackTrace();
}
}
}