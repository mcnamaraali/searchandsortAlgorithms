import java.security.SecureRandom;
import java.util.Arrays;

public class InsertionSortTest {

	public static void main(String[] args) { 
		SecureRandom generateRandomNumbers = new SecureRandom();

		int[] data = generateRandomNumbers.ints(5,1,100).toArray();

		System.out.printf("Unsorted array - so the before picture! %s%n%n", Arrays.toString(data));

		insertionSort(data);

		System.out.printf("Sorted array - so the after picture! %s%n%n", Arrays.toString(data));

	}

	public static void insertionSort(int[] data) {

		for(int next = 1; next < data.length; next++) {
			int insert = data[next];
			int moveItem = next;


			while (moveItem > 0 && data[moveItem - 1] > insert) {
				data[moveItem] = data[moveItem - 1];
				moveItem--;

			}
			
			data[moveItem] = insert; //place inserted element
			printPass(data, next, moveItem);
		}

	}

	private static void printPass(int[] data, int pass, int index) {
		System.out.printf("after pass %2d: ", pass);

		for(int i = 0; i < index; i++) {
			System.out.printf("%d ", data[i]);
		}

		System.out.printf("%d* ",data[index]);

		for(int i = index + 1; i < data.length; i++) {
			System.out.printf("%d ", data[i]);
		}

		System.out.printf("%n                    ");

		for(int i = 0; i < pass; i++) {
			System.out.print("--    ");
		}

		System.out.println();

	}

}
