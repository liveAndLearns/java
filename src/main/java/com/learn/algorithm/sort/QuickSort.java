package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 *
 * 快速排序
 * 
 * 类型：比较类排序
 * 子类型： 交换排序
 *
 * 平均/最好 O(nlog`2`n)  最坏 O(n^2)
 * 
 * 不稳定
 */
public class QuickSort {
	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(100);
		Utils.printArray(arrayToBeSorted);
		quickSort(arrayToBeSorted,0,arrayToBeSorted.length-1,true);
		Utils.printArray(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
	}

	public static void quickSort(int[] arrayToBeSorted, int left , int right, boolean isFirstTime) {
		
        if(isFirstTime) Utils.initCount();
		if(left < right) {
					
			int partitionIndex = partition(arrayToBeSorted,left,right);
			quickSort(arrayToBeSorted,left,partitionIndex-1,false); // partionIndex 为基准值，两侧已经进行了排序所以不需要再进行quicksort 
			quickSort(arrayToBeSorted,partitionIndex+1,right,false); // partionIndex 为基准值，两侧已经进行了排序所以不需要再进行quicksort
		}
		
		
	}

	/**
	 * 
	 * @param arrayToBeSorted
	 * @param left  inclusive 
	 * @param right  inclusive
	 * @return
	 */
	private static int partition(int[] arrayToBeSorted, int left, int right) {

		int pivot = left; // 基准值
		
		int index = pivot + 1;
		
		// 从基准值的下一个元素开始和基准值相比
		for(int i = index ; i <= right ; i ++)
		{
			if( Utils.increaseCompareCount() && arrayToBeSorted[i] < arrayToBeSorted[pivot] ) {
				
				// 只有i不等于index时候才交换（否则没有意义，但是这样就或多一些判断的执行！）
				if(i!=index) {
					
					// 如果比基准值小，则和左侧邻近的最后一次大于基准值的元素进行交换位置
					Utils.swapArrayElement(i, index, arrayToBeSorted);
				}
				index ++;
			}
		}
		
		// 基准值和partition中的最后一个比基准值小的值交换。 则基准值之前全部是小于基准值的。  基准值之后全部是大于基准值的。 
		Utils.swapArrayElement(pivot, index-1,arrayToBeSorted);
		
		//返回基准值所在的元素index
		return index -1;
	}
}
