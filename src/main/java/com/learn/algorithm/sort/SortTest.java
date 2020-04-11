package com.learn.algorithm.sort;

import java.util.Arrays;

import com.learn.algorithm.Utils;

public class SortTest {

	public static void main(String[] args)
	{
		int [] array = {17, 14, -75, -7, 55, 51, -15, -60, -50, -59, 11, 2, -8, -12, 6, -49, 28, -89, -34, 98, 13, 25, 63, 78, -54, 0, 56, 46, -19, -48, 91, 65, 3, 99, -36, 22, 55, 51, -1, -8, 88, 0, -93, -52, -61, 60, 79, -86, 77, 56, -37, -75, 7, 84, 83, -18, 76, -65, -5, -88, 55, 31, -36, 18, -39, 66, 41, 81, -93, -74, 88, -6, 59, 53, 46, -65, 0, -71, 65, -90, 65, 11, 18, -30, 30, 94, -37, -82, -74, -31, 82, 58, 80, -28, -3, 15, 94, -17, 19, 46};
		
		int [] arrayToBeSorted; 
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);
		
		Utils.printArray(arrayToBeSorted);
		
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);
		BubbleSort.bubbleSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
		Utils.printArray(arrayToBeSorted);
		
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);		
		InsertionSort.insertionSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
		Utils.printArray(arrayToBeSorted);
		
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);		
		Utils.printArray(MergeSort.mergeSort(arrayToBeSorted,true));
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());		
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);
		QuickSort.quickSort(arrayToBeSorted,0,array.length-1,true);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());		
		Utils.printArray(arrayToBeSorted);
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);
		ShellSort.shellSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());		
		Utils.printArray(arrayToBeSorted);
		
		arrayToBeSorted = Arrays.copyOf(array, array.length);		
	    SelectionSort.selectionSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());	    
		Utils.printArray(arrayToBeSorted);		
	}
}
