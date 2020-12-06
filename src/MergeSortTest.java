import java.security.SecureRandom;
import java.util.Arrays;

public class MergeSortTest {

	public static void main(String[] args) {
		SecureRandom generateRandomNumbers = new SecureRandom();

		int[] data = generateRandomNumbers.ints(4,1,100).toArray();

		System.out.printf("Unsorted array - so the before picture! %s%n%n", Arrays.toString(data));

		mergeSort(data);

		System.out.printf("Sorted array - so the after picture! %s%n%n", Arrays.toString(data));
	}

	private static void mergeSort(int[] data) {
		sortArray(data, 0, data.length - 1);

	}

	private static void sortArray(int[] data, int low, int high) {
		if((high - low) >= 1) {
			int middle1 = (low + high) / 2;
			int middle2 = middle1 + 1;

			System.out.printf("split1 :   %s%n", subarrayString(data, low, high));
			System.out.printf("split2 :   %s%n", subarrayString(data, low, middle1));
			System.out.printf("split3 :   %s%n", subarrayString(data, middle2, high));

			sortArray(data,low,middle1);
			sortArray(data, middle2, high);

			merge(data, low, middle1, middle2, high);

		}

	}

	private static String subarrayString(int[] data, int low, int high) {
		StringBuilder tempBuilder = new StringBuilder();

		for(int i = 0; i < low; i++) {
			tempBuilder.append("     ");
		}

		for(int i = low; i <= high; i++) {
			tempBuilder.append("     "+ data[i]);
		}

		return tempBuilder.toString();
	}

	private static void merge(int[] data, int left, int middle1, int middle2, int right) {
		int leftIndex = left;
		int rightIndex = middle2;
		int combinedIndex = left;
		int[] combined = new int[data.length];

		System.out.printf("merge:     %s%n", subarrayString(data,left,middle1));
		System.out.printf("    %s%n", subarrayString(data,middle2,right));

		while (leftIndex <= middle1 && rightIndex <= right) {
			//place smaller of two current elements into result and move to the next space in arrays
			if(data[leftIndex] <= data[rightIndex]) {
				combined[combinedIndex++] = data[leftIndex++];
			}
			else {
				combined[combinedIndex++] = data[rightIndex++];
			}
		}

		if(leftIndex == middle2) {
			//copy in rest of right array
			while(rightIndex <= right) {
				combined[combinedIndex++] = data[rightIndex++];
			}
		} 
		else {
			while(leftIndex <= middle1) {
				combined[combinedIndex++] = data[leftIndex++];
			}
		}
		
		for(int i = left; i<= right; i++) {
			data[i] = combined[i];
		}
		
		System.out.printf("           %s%n%n", subarrayString(data,left,right));
		
	}

}


