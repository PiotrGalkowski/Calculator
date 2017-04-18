package pl.akademiakodu;

import java.util.Scanner;
import java.util.regex.Pattern;
import static pl.akademiakodu.CalculatorMenu.*;

public class Main {

    public static void main(String[] args) {
        byte number = 0;
        int numberOne = 0;
        int numberTwo = 0;

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println();
            showMenu();
            System.out.println();
            System.out.print("Please choice the one of the options(1-6): ");
            number = sc.nextByte();
            System.out.println();
            if(number==6){
                System.out.println("Goodbye ;)");
                break;
            }else if(number<1 || number>6){
                System.out.println("WRONG!!!");
                continue;
            }
            String temp = null;

            do {
                System.out.print("Please input two numbers(with comma): ");
                temp = sc.next();
            }while(!Pattern.matches("[0-9]+,[0-9]+", temp));

            String[] twoNumbers = temp.split(",");

            numberOne = Integer.parseInt(twoNumbers[0]);
            numberTwo = Integer.parseInt(twoNumbers[1]);

            System.out.println();
            switch (number) {
                case 1:
                    System.out.println(numberOne + " + " + numberTwo + " = " + Math.addExact(numberOne, numberTwo));
                    break;
                case 2:
                    System.out.println(numberOne + " - " + numberTwo + " = " + Math.subtractExact(numberOne, numberTwo));
                    break;
                case 3:
                    System.out.println(numberOne + " * " + numberTwo + " = " + Math.multiplyExact(numberOne, numberTwo));
                    break;
                case 4:
                    try {
                        System.out.println(numberOne + " / " + numberTwo + " = " + Math.floorDiv(numberOne, numberTwo));
                    } catch (ArithmeticException e) {
                        System.out.println("Division by zero!!!");
                    }
                    break;
                case 5:
                    try {
                        System.out.println(numberOne + " % " + numberTwo + " = " + Math.floorMod(numberOne, numberTwo));
                    } catch (ArithmeticException e) {
                        System.out.println("Division by zero!!!");
                    }
                    break;
            }
        }while(number!=6);
    }
}
