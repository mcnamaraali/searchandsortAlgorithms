import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchTest {

	public static int linearSearch(int data[], int searchKey) {
		//loop through array linearly
		for(int index = 0; index < data.length; index++) {
			if(data[index] == searchKey) {
				return index;
			}
		}
		return -1; 
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom genRandNumbers = new SecureRandom();

		int[] data = new int[10]; //new array length of the array is 10

		for (int i = 0; i < data.length; i++) {
			data[i] = 10 + genRandNumbers.nextInt(90); //populate the array
		}
		
		System.out.printf("%s%n%n", Arrays.toString(data));

		System.out.println("Please enter an integer value (-1 to quit)"); 
		int searchInt = input.nextInt();
		
		while (searchInt != -1) {
			int position = linearSearch(data, searchInt);
			
			if(position == -1) {
				System.out.println("Not found");
			} 
			else {
				System.out.printf("%d was found in position %d%n%n", searchInt, position);
			}
			
			System.out.print("Please enter an integer value (-1 to quit)");
			searchInt = input.nextInt();
			
		}




	}

}
