package javacore.hello;

import java.util.Arrays;
import java.util.Scanner;

class Example {}
class MountainBike extends Bicycle{
	// new fields and methods defining
	// a mountain bike would go here
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to javacore.net!");
		System.out.println("Learning Java for a better world!");
		// Variables: {DataType} {VariableName}
		
		// DataTypes: String, "int", float, char, boolean
		int a, b;
		a = 1;
		b = 2;
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		double salary = 35.5;
		boolean isValid = false;
		double yearlyIncome;
		char aChar = 'Ã';
		String fullname = "Java Core";
		yearlyIncome = salary * 12;
		System.out.printf("%s\n - Salary Rate: %1.2f\n", fullname, salary);
		System.out.printf("isValid=%b\n ", isValid);
		System.out.printf("Yearly Income=%1.2f\n ", yearlyIncome);
		System.out.printf("%c", aChar);
		
//		// Scanner
//		Scanner myScanner = new Scanner(System.in);
//		System.out.println("Can you you tell me your name? ");
//		String userName = myScanner.nextLine();
//		System.out.printf("Hello %s!\n", userName);
//		System.out.println("--env=production --enable=1");
		// Falsy
		System.out.printf("null is %b\n", null);
		boolean zeroStringTruthy = Boolean.parseBoolean("0");
		boolean zeroTruthy = Boolean.parseBoolean(String.valueOf(0));
		System.out.printf("'0' is %b\n", zeroStringTruthy);
		System.out.printf("0 is %b\n", zeroTruthy);
		
		MountainBike myBicycle = new MountainBike();
		myBicycle.printStates();
		myBicycle.changeCadence(2);
		myBicycle.changeGear(3);
		myBicycle.speedUp(10);
		myBicycle.applyBrakes(5);
		myBicycle.printStates();
		System.out.printf("myBicycle instanceof Bike :%b\n", myBicycle instanceof MountainBike);
		Main.demo();
		Main.demoArray();
		Main.demoMatrix();
	}

	public static void demo() {
		String lessionId = "1";
		System.out.println(lessionId);
	}
	
	public static void demoArray() {
		int[] numbers;
		// convert strings to array
		String aListOfNumber = "1,2,3,4,5,6,7,8,9";
		String[] listNumber = aListOfNumber.split(",");
		System.out.printf("We have this string: %s\n", aListOfNumber);
		// allocate memory for 10 integers
		numbers = new int[listNumber.length];
		for (int i = 0; i < listNumber.length; i++) {
			numbers[i] = Integer.parseInt(listNumber[i]);
			System.out.printf("Index[%d] = %d\n",i, numbers[i]);
		}
		// slice[3,5]
		int[] newSlice = new int[3];
		System.arraycopy(numbers, 3, newSlice, 0, 3);
		Main.printArray(newSlice);
		String[] copyFrom = {
	            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
	            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
	            "Marocchino", "Ristretto" };
		String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9); 
		for(String coffee : copyTo) {
			System.out.printf("%s\n", coffee);
		}
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Index[%d] = %d\n",i, array[i]);
		}
	}
	
	public static void demoMatrix() {
		String[][] boards;
		boards = new String[3][3];
		for (int column = 0; column < boards.length; column++) {
			for (int row = 0; row < boards.length; row++) {
				boards[column][row] = String.valueOf(column) + String.valueOf(row);				
			}			
		}
		for (int column = 0; column < boards.length; column++) {
			for (int row = 0; row < boards.length; row++) {
				System.out.printf("Index[%d][%d] = %s\n", column, row, boards[column][row]);
			}
		}
	}
}
