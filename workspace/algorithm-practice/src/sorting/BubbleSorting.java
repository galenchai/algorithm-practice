package sorting;

import testdata.Data;


public class BubbleSorting {
	
	public final static int[] SORT_ARRAY = new int[] {22, 97, 35, 19, 20, 10, 9, 3, 39, 56, 88, 19};
	
	public final static int[] FIBONACCI_ARRAY = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
	
	public static void printArray(int[] array, boolean printArray) {
		if (printArray) {
			for (int i : array) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Original bubble sorting
	 * The worst time complexity: O(n^2)
	 * @param array
	 */
	public static void bubbleSorting(int[] array, boolean printArray) {
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
		printArray(array, printArray);
		System.out.println("ButtleSorting time elapsed: " + (end - start));
	}
	
	/**
	 * The sorting has been finished if no data exchange occurs
	 * The best time complexity: O(1), the worst: O(n^2)
	 * @param array
	 */
	public static void bubbleSortingEnhanced(int[] array, boolean printArray) {
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
		printArray(array, printArray);
		System.out.println("ButtleSortingEnhanced time elapsed: " + (end - start));
	}
	
	/**
	 * 
	 * @param array
	 */
	public static void bubbleSortingPartialSeq(int[] array, boolean printArray) {
		
	}
	
	public static int fibonacci(int seq) {
		if (1 == seq || 2 == seq) {
			return 1;
		} else {
			return fibonacci(seq - 1) + fibonacci(seq - 2);
		}
	}
	
	public static void insertionSorting(int[] array, boolean printArray) {
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
		printArray(array, printArray);
		System.out.println("InsertionSorting time elapsed: " + (end - start));
	}
	
	public static void mergeSorting(int[] array, boolean printArray) {
		long start = System.currentTimeMillis();
		mergeSortInner(array, 0, array.length - 1); 
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("MergeSorting time elapsed: " + (end - start));
	}
  
    private static void mergeSortInner(int[] data, int left, int right) {  
        if (left >= right)  
            return;  
        int center = (left + right) / 2;  
        mergeSortInner(data, left, center);  
        mergeSortInner(data, center + 1, right);  
        merge(data, left, center, right);  
    }  
  
    private static void merge(int[] data, int left, int center, int right) {  
        int[] tmpArr = new int[data.length];  
        int mid = center + 1;  
        int third = left;  
        int tmp = left;  
        while (left <= center && mid <= right) {  
            if (data[left] <= data[mid]) {  
                tmpArr[third++] = data[left++];  
            } else {  
                tmpArr[third++] = data[mid++];  
            }  
        }  
        while (mid <= right) {  
            tmpArr[third++] = data[mid++];  
        }  
        while (left <= center) {  
            tmpArr[third++] = data[left++];  
        }  
        while (tmp <= right) {  
            data[tmp] = tmpArr[tmp++];  
        }  
    }  
	
	public static void compareCmmonValues(int[] array1, int[] array2, boolean printArray) {
		long start = System.currentTimeMillis();
		int array[] = new int[array1.length < array2.length ? array1.length : array2.length];
		int count = 0;
		for (int i : array1) {
			for (int j : array2) {
				if (i == j) {
					array[count ++] = i;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("CommonValues time elapsed: " + (end - start));
	}
	
	public static void compareCommonValuesWithSorting(int[] array1, int[] array2, boolean printArray) {
		long start = System.currentTimeMillis();
		int array[] = new int[array1.length < array2.length ? array1.length : array2.length];
		int i = 0, j = 0, r = 0;
		mergeSortInner(array1, 0, array1.length - 1);
		mergeSortInner(array2, 0, array2.length - 1);
		for (; i < array1.length; i ++) {
			for (; j < array2.length; ) {
				if (array1[i] == array2[j]) {
					array[r ++] = array1[i ++];
					j ++;
				} else if (array1[i] > array2[j]) {
					j ++;
				} else {
					break;
				}
			}
		}
		long end = System.currentTimeMillis();
		printArray(array, printArray);
		System.out.println("CommonValuesWithSorting time elapsed: " + (end - start));
	}
	
	public static void sortingCommonValues(int[] array1, int[] array2, boolean printArray) {
		long start = System.currentTimeMillis();
		
	}
	
	public static void main(String args[]) {
		bubbleSorting(Data.SORT_TEST_ARRAY, false);
		bubbleSortingEnhanced(Data.SORT_TEST_ARRAY, false);
		insertionSorting(Data.SORT_TEST_ARRAY, false);
		mergeSorting(Data.SORT_TEST_ARRAY, false);
		//System.out.println("Fibonacci, input: 11: result: " + fibonacci(11));
	}
	
	
}
