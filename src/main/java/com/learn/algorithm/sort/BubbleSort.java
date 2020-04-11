package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 * 
 * 冒泡排序
 * 
 *  类型：比较类排序
 *  子类型： 交换排序
 *  
 *  平均: O(n^2)  最好 O(n)
 *  
 *  稳定
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);

		Utils.printArray(arrayToBeSorted);
		revserseBubbleSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
		Utils.printArray(arrayToBeSorted);
		
		
		arrayToBeSorted = Utils.generateRandomIntArray(10);

		Utils.printArray(arrayToBeSorted);
		bubbleSort(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());

		Utils.printArray(arrayToBeSorted);
	}

	public static void revserseBubbleSort(int[] arrayToBeSorted) {
		Utils.initCount();
		// 要循环 arrayToBeSorted.length -1 轮
		for (int i = 0; i < arrayToBeSorted.length - 1; i++) {

			// 从第一个元素开始比较，将最大的放到后面。（反向冒泡算法==沉底算法)
			// 第一轮比较到最后一个元素。 第一轮第一次比较 [0],[1] , 第二次比较 [1],[2] ， 最后比较到
			// [arrayToBeSorted.length-i-2]和 [arrayToBeSorted.length-i-1]， 此处i=0，
			// 则就是[arrayToBeSorted.length-2]和 [arrayToBeSorted.length-1]
			// （即倒数第二个元素和倒数第一个元素）。此时倒数第一个元素是最大的值。
			// 第二轮比较直到倒数第二个元素（因为第一轮已经将最大的放入到数组最后，不需要再进行比较）。第二轮第一次比较[0]和[1]，直到
			// [arrayToBeSorted.length-i-1]和 [arrayToBeSorted.length-i] 即
			// [arrayToBeSorted.length-3]和 [arrayToBeSorted.length-2]

			for (int j = 0; j < arrayToBeSorted.length - i - 1; j++) {

				if (Utils.increaseCompareCount() && arrayToBeSorted[j] > arrayToBeSorted[j + 1]) {

					Utils.swapArrayElement(j, j + 1, arrayToBeSorted);
				}

			}

		}



	}

	public static void bubbleSort(int[] arrayToBeSorted) {

		Utils.initCount();

		// 共需要lenth-1 轮循环
		for (int i = arrayToBeSorted.length - 1; i > 0; i--) {

			// 每一轮从最后一个元素开始比对，第二轮不需要比对第一个元素（因为第一个元素已经冒泡到最上面）。 依次类推， 第三轮不需要比对第二个元素。
			for (int j = arrayToBeSorted.length - 1; j > arrayToBeSorted.length - 1 - i; j--) {

				if (Utils.increaseCompareCount() && arrayToBeSorted[j] < arrayToBeSorted[j - 1]) {

					Utils.swapArrayElement(j, j - 1, arrayToBeSorted);
				}

			}

		}



	}

}
