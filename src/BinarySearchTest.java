import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTest {
	
	public static int binarySearch(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		int middle = (low + high + 1) / 2;
		int location = - 1; //return value -1 if not found (sentinel value)
		
		
		do { 
			System.out.print(remainingElements(data,low,high));
		
			for(int i = 0; i < middle; i++) {
				System.out.print("   ");
			}
			System.out.println(" * "); 
			
			if(key == data[middle]) {
				location = middle; //location is the current middle
			}
			else if (key < data[middle]) { // middle is too high
				high = middle - 1; // eliminate the higher half 
			}
			else { // middle element is too low
				low = middle + 1;  // eliminate the lower half
			}
		
			middle = (low + high + 1) / 2; // recalculate the middle
		} while ((low <= high) && (location == -1));
		
		return location;
	}
	
	private static String remainingElements(int[] data, int low, int high) {
		StringBuilder temp = new StringBuilder();
		
		for (int i = 0; i < low; i ++) {
			temp.append("    ");
		}
		
		for (int i = low; i <= high; i++) {
			temp.append(data[i] + " ");
		}
		
		return String.format("%s %n", temp);
	}
	

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom randNum = new SecureRandom();
		
		int[] data = randNum.ints(10,0,100).sorted().toArray();
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		System.out.println("Please enter an int value or type -1 to quit");
		int searchInt = input.nextInt();
		
		while (searchInt != -1) {
			int location = binarySearch(data, searchInt);
			
			if (location == -1) {
				System.out.println("Not found");
			}
			else {
				System.out.printf("%d was found in position %d%n%n", searchInt, location);
			}
			
			System.out.println("Please enter an int value or type -1 to quit");
			searchInt = input.nextInt();
		}

	}

}
