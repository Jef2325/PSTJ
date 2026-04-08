import java.io.*;
import java.util.*;

class Printer {

    // Generic method
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

public class task_9 {

    public static void main(String[] args) {
        Printer myPrinter = new Printer();

        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // Check if more than one method is declared
        int count = 0;
        for (java.lang.reflect.Method method : Printer.class.getDeclaredMethods()) {
            if (method.getName().equals("printArray")) {
                count++;
            }
        }

        if (count > 1) {
            System.out.println("Method overloading is not allowed!");
        }
    }
}
