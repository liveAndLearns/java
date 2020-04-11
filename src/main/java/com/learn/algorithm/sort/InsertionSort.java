package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 * 
 * 简单插入排序
 * 
 *  类型：比较类排序
 *  子类型： 插入排序
 *  
 *  平均: O(n^2)  最好 O(n)
 *  
 *  稳定
 */
public class InsertionSort {

	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);
		Utils.printArray(arrayToBeSorted);
		insertionSort(arrayToBeSorted);
		Utils.printArray(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
	}

	public static void insertionSort(int[] arrayToBeSorted) {
		Utils.initCount();
		int len = arrayToBeSorted.length;

		// 插入len-1 次
		for (int i = 1; i < len; i++) {
			int toBeInsertElement = arrayToBeSorted[i]; // 从1 到 len-1,依次插入
			for (int j = 0; j < i; j++) {
				if (Utils.increaseCompareCount() && toBeInsertElement < arrayToBeSorted[j]) {
					Utils.swapArrayElement(j, i, arrayToBeSorted);
				}

			}

		}



	}

}
