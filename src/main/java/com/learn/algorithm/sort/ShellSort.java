package com.learn.algorithm.sort;

import com.learn.algorithm.Utils;

/**
 * 
 * @author lihao
 * 
 *  希尔排序
 * 
 *  类型：比较类排序
 *  子类型：插入类排序
 *  
 *  
 *  平均 O(n^1.3) 最坏 O(n^2)  最好 O(n)
 *  不稳定
 * 
 */
public class ShellSort {
	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);
		Utils.printArray(arrayToBeSorted);
		shellSort(arrayToBeSorted);
		Utils.printArray(arrayToBeSorted);
		System.out.printf("compared counts: %s \n" + "swap counts: %s \n", Utils.getCompareCount(),
				Utils.getswapCount());
	}

	public static void shellSort(int[] arrayToBeSorted) {
		Utils.initCount();
		for (int step = arrayToBeSorted.length / 2; step > 0; step = step / 2) {

			System.out.printf("step: %s\n", step);

			// 从第一个step开始。 例如如果step为5， 则将element 0 和 lement 5 作为一组进行简单排序。
			// 如果step为2 ， 则将 element 0 和 element 2 作为一组进行排序
			for (int i = step; i < arrayToBeSorted.length; i++) {

				int nowSequenceIndex = i; // 当前子序列的开始index，第一次时 就是i 而且 i就是step。

				// 如果 当前子序列的开始元素， 和 step之前的元素进行插入排序。
				while (Utils.increaseCompareCount() && nowSequenceIndex - step > 0
						&& arrayToBeSorted[nowSequenceIndex] < arrayToBeSorted[nowSequenceIndex - step]) {

					Utils.swapArrayElement(nowSequenceIndex - step, nowSequenceIndex, arrayToBeSorted);
					nowSequenceIndex = nowSequenceIndex - step; // 如果step之前的元素往前step还有，则继续往前进行插入排序。 while里面有判断
																// nowSequenceIndex -step 后是否还有元素，有才进行再次插入判断，没有就停止。

				}

			}

		}

	}
}
