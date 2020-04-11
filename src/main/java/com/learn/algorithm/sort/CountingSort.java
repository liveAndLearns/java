package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 * 
 *  计数排序
 * 
 *  类型：非比较类排序
 *  
 *  平均: O(n+k)
 *  
 *  经典型 稳定
 */
public class CountingSort {
	public static void main (String[] args)
	{
				
		int[] arrayToBeSorted = Utils.generateRandomPositiveIntArray(10);
		Utils.printArray(arrayToBeSorted);
		countingSort(arrayToBeSorted);
		Utils.printArray(arrayToBeSorted);

		
	}

	public static void countingSort(int[] arr) {
        int n = arr.length; 
        
        // The output character array that will have sorted arr 
        int output[] = new int[n]; 
  
        // Create a count array to store count of inidividul 
        // characters and initialize count array as 0 
        int count[] = new int[256]; 
        for (int i=0; i<256; ++i) 
            count[i] = 0; 
  
        // store count of each array element
        // in java ,  ++i simple expression in loop is same as ++i.  
        // in c/c++, it based on the compiler optimization option. !! 
        for (int i=0; i<n; ++i) 
            ++count[arr[i]]; 
  
        int sortedIndex = 0;
        for (int i = 0; i<256; ++i)
        	while(count[i]-- > 0)
        	{
        		arr[sortedIndex] = i; 
        		sortedIndex ++;
        	}
	}
}
