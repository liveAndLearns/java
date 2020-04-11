package com.learn.algorithm.sort;

import java.util.Arrays;

import com.learn.algorithm.Utils;


/**
 * 
 *  @author lihao
 *  
 * 二路归并排序
 * 
 * 类型： 比较类排序
 * 子类型： 归并排序
 * 
 * O(nlog`2`n)
 * 
 * 
 * 稳定
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] arrayToBeSorted = Utils.generateRandomIntArray(10);
		Utils.printArray(arrayToBeSorted);
		arrayToBeSorted = mergeSort(arrayToBeSorted,true);
		Utils.printArray(arrayToBeSorted);
		System.out.printf("compared counts: %s \n", Utils.getCompareCount());

	}

	public static int[] mergeSort(int[] arrayToBeSorted,boolean firstTime) {
		if(firstTime) Utils.initCount();
		int len = arrayToBeSorted.length;
		if (len >= 2) {
			// 如果数组长度大于1，则继续拆分并合并排序
			int middle = len / 2;
			int[] left = Arrays.copyOfRange(arrayToBeSorted, 0, middle);
			int[] right = Arrays.copyOfRange(arrayToBeSorted, middle, len);
			return merge(mergeSort(left,false), mergeSort(right,false));
			
		} else {
			return arrayToBeSorted;
		}
	}

	private static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];

		// 把2个已排序的数组合并

		int leftPointer = 0;
		int rightPointer = 0;
		int resultPointer = 0;

		while (leftPointer < left.length && rightPointer < right.length) {
			if (Utils.increaseCompareCount() && left[leftPointer] <= right[rightPointer]) {
				result[resultPointer] = left[leftPointer];
				resultPointer++;
				leftPointer++;
			}

			else {

				result[resultPointer] = right[rightPointer];
				resultPointer++;
				rightPointer++;

			}

		}

		while (leftPointer < left.length) {
			result[resultPointer] = left[leftPointer];
			resultPointer++;
			leftPointer++;
		}

		while (rightPointer < right.length) {

			result[resultPointer] = right[rightPointer];
			resultPointer++;
			rightPointer++;

		}

		return result;
	}

}
