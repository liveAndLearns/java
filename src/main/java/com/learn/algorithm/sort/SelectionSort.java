package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 *
 *  简单选择排序
 *
 *  类型： 比较类排序
 *  子类型：选择排序
 *  
 *  平均，最坏，最好 O（n^2) 
 *
 *  不稳定
 */
public class SelectionSort {

	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);

		Utils.printArray(arrayToBeSorted);
		selectionSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());

		Utils.printArray(arrayToBeSorted);
	}

	public static void selectionSort(int[] arrayToBeSorted) {


		Utils.initCount();
		int len = arrayToBeSorted.length;

		int minValue;
		int minIndex;

		// 循环length-1次，每次找到一个最小，最后一次剩下的就是最大的
		for (int i = 0; i < len - 1; i++) {
			minValue = arrayToBeSorted[i];
			minIndex = i;

			// 比较当轮的开始元素到最后的最小值
			for (int j = i + 1; j < len; j++) {

				if (Utils.increaseCompareCount() && minValue > arrayToBeSorted[j]) {
					minValue = arrayToBeSorted[j];
					minIndex = j;
				}

			}
			// 找到了最小的值，然后与本轮的第一个元素进行交换

			Utils.swapArrayElement(i, minIndex, arrayToBeSorted);

		}



	}

}
