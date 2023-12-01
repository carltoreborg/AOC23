import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.*;
import java.lang.*;

public class Day1 {

    private static Character[] numbers = new Character[]{'1', '2', '3', '4','5','6','7','8','9','0'};
    

    public static void main(String[] args) {
        String filePath = "./inputdata.txt";

        int totalSum = 0;

        try {
            Path path = Paths.get(filePath);
            ArrayList<String> lines = new ArrayList<String>(Files.readAllLines(path));
            
            int countLines = 0;

            for (String line : lines) {
                System.out.println(line);

                int i = 0; //Coundter
                Character currentFrontChar = 'a';
                while (!Character.isDigit(currentFrontChar)) {
                    currentFrontChar = (char) line.charAt(i);
                    i++;
                }
                System.out.println(currentFrontChar);

                int j = line.length();
                Character currentBackChar = 'a';
                while (!Character.isDigit(currentBackChar)) {
                    currentBackChar = (char) line.charAt(j-1);
                    j--;
                }

                System.out.println(currentBackChar);

                System.out.println("Front and back: " + currentFrontChar + currentBackChar);

                int currentFrontInt = (int) currentFrontChar;
                currentFrontInt = currentFrontInt *10;
                int currentBackInt = (int) currentBackChar;

                int currentTotalInt = (int) (currentFrontChar + currentBackChar);

                System.out.println("Parce direct: " + currentTotalInt);

                System.out.println("Current ints: " + currentFrontInt + currentBackInt);

                try {
                    //int combinedInt = Character.getNumericValue(currentFrontChar + currentBackChar);
                    totalSum = totalSum + currentFrontInt + currentBackInt;
                    System.out.println("After addititon: " + totalSum);
                    
                } catch (Exception e) {
                    System.out.println("Is not a int. CurrentFrontChar: " + currentFrontChar + " CurrentBackChar: " + currentBackChar);
                }
                

                countLines++;
            
            }

            System.out.println("Total lines: " + countLines);

            System.out.println("Final num: " + totalSum);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
