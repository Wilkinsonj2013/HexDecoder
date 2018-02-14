import java.util.*;
import java.lang.Math;

public class Main {

    public static String hexInput;
    public static String decOutput;
    public static char[] hexArray;
    public static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        //User enters the hexadecimal number
        System.out.println("Enter a hexadecimal number: ");
        hexInput = input.nextLine();
        hexInput = hexInput.toLowerCase();

        if (hexInput.startsWith("0x")){
            hexInput = hexInput.replaceAll("0x", "");
        }
        hexArray = hexInput.toCharArray();
        converter();

        System.out.println("Your number is " + decOutput + " in decimal");

    }

    public static int alphaToNumeric(char letter) {
        int number;
        switch(letter) {
            case 'a':
                number = 10;
                break;
            case 'b':
                number = 11;
                break;
            case 'c':
                number = 12;
                break;
            case 'd':
                number = 13;
                break;
            case 'e':
                number = 14;
                break;
            case 'f':
                number = 15;
                break;
            default:
                number = Character.getNumericValue(letter);
                break;
        }
        return number;
    }

    //Converter
    public static void converter(){

        int newNum;
        int power = 0;
        double result = 0;

        for(int i=hexArray.length-1; i>=0; i--){
            newNum = alphaToNumeric(hexArray[i]);
            result = result + (newNum * Math.pow(16, power));
            power++;
        }

        decOutput = String.valueOf(Math.round(result));
    }

}