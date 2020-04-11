package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 * 
 *  堆排序
 * 
 *  类型：比较类排序
 *  子类型： 选择排序
 *  
 *  平均/最坏/最好 O(nlog_2_n)
 *  
 *  经典型 不稳定
 */
public class HeapSort {
	
	public static void main (String[] args)
	{
		
		
		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);
		Utils.printArray(arrayToBeSorted);
		heapSort(arrayToBeSorted);
		Utils.printArray(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
		
		
	}

	private static void heapSort(int[] arrayToBeSorted) {

		//初始化最大堆，然后将root值和最后的一个进行交换。 然后再进行最大堆的构建，不断的找到本轮构建的最大值，这样完成了排序。 因为要in-place完成排序，所以需要构建最大堆，便于用数组表示堆结构。
		
        int n = arrayToBeSorted.length; 
        
        // Build max heap 
        for (int i = n / 2 - 1; i >= 0; i--) 
            heapify(arrayToBeSorted, n, i); 
  
        Utils.printArray(arrayToBeSorted);
        
        // One by one extract an element from heap 
        for (int i=n-1; i>=0; i--) 
        { 
        	
        	// root 和 数组尾部元素进行交换
        	Utils.swapArrayElement(i, 0, arrayToBeSorted);
  
            // call max heapify on the reduced heap 
            heapify(arrayToBeSorted, i, 0); 
        } 
		
		
		
	}

	private static void heapify(int[] arrayToBeSorted, int n, int i) {

        int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left leaf = 2*i + 1 
        int r = 2*i + 2; // right leaf = 2*i + 2 
  
        // If left child is larger than root 
        if (Utils.increaseCompareCount() && l < n && arrayToBeSorted[l] > arrayToBeSorted[largest]) 
            largest = l; 
  
        // If right child is larger than largest so far 
        if (Utils.increaseCompareCount() &&  r < n && arrayToBeSorted[r] > arrayToBeSorted[largest]) 
            largest = r; 
  
        // If largest is not root 
        if (largest != i) 
        { 
            Utils.swapArrayElement(largest, i, arrayToBeSorted);        
            // 调整后还需要调整自己的子树
            heapify(arrayToBeSorted, n, largest); 
        } 
		
	}

}
