package sorting;

import testdata.Data;

public class BubbleSorting {
	
public final static int[] SORT_ARRAY = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19};
	
	public final static int[] FIBONACCI_ARRAY = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
	
	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println("");
	}
	
	/**
	 * Original bubble sorting
	 * The worst time complexity: O(n^2)
	 * @param array
	 */
	public static void bubbleSorting(int[] array) {
		long start = System.currentTimeMillis();
		int temp;
		for (int i = 0; i < array.length; i ++) {
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array);
		System.out.println("Time elapsed: " + (end - start));
	}
	
	/**
	 * The sorting has been finished if no data exchange occurs
	 * The best time complexity: O(1), the worst: O(n^2)
	 * @param array
	 */
	public static void bubbleSortingEnhanced(int[] array) {
		long start = System.currentTimeMillis();
		int temp, count;
		for (int i = 0; i < array.length; i ++) {
			count = 0;
			for (int j = 1; j < array.length - i; j ++) {
				if (array[j] < array[j - 1]) {
					temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
					count ++;
				}
			}
			if (count == 0) {
				break;
			}
		}
		long end = System.currentTimeMillis();
		printArray(array);
		System.out.println("Time elapsed: " + (end - start));
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void bubbleSortingPartialSeq(int[] array) {
		
	}
	
	public static void insertionSorting(int[] array) {
		long start = System.currentTimeMillis();
		int i, j, k, temp;
		for (i = 1; i < array.length; i ++) {
			for (j = i - 1; j >= 0; j --) {
				if (array[j] < array[i]) {
					break;
				}
			}
			temp = array[i];
			for (k = i - 1; k > j ; k --) {
				array[k + 1] = array[k];
			}
			array[k + 1] = temp;
		}
		long end = System.currentTimeMillis();
		printArray(array);
		System.out.println("Time elapsed: " + (end - start));
	}
	
	public static void main(String args[]) {
		bubbleSorting(Data.SORT_TEST_ARRAY);
		bubbleSortingEnhanced(Data.SORT_TEST_ARRAY);
		insertionSorting(SORT_ARRAY);
	}
	
	
	
}
