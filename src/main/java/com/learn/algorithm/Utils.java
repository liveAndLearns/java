package com.learn.algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Utils {

	public static int abs(int x) {

		// System.out.println("before abs: "+x);

		int result = 0;

		if (x == Integer.MIN_VALUE) {
			// 如果是 MIN_VALUE，则直接返回 -x 的值， 此时不适合使用Math.abs方法，否则仍返回最小的负数。
			result = -x;
		} else {
			result = Math.abs(x);
		}

		// System.out.println("after abs: "+result);

		return result;
	}

	public static int[] generateRandomIntArray(int size) {

		Random r = new Random();
		if (size <= 0)
			size = 0;
		int[] integers = new int[size];
		for (int i = 0; i < integers.length; i++) {
			// integers[i] = abs(r.nextInt())%100;
			integers[i] = r.nextInt() % 100;
		}

		// System.out.println(Arrays.toString(integers));

		return integers;
	}

	
	public static int[] generateRandomPositiveIntArray(int size) {

		Random r = new Random();
		if (size <= 0)
			size = 0;
		int[] integers = new int[size];
		for (int i = 0; i < integers.length; i++) {
			 integers[i] = abs(r.nextInt())%20;
			//integers[i] = r.nextInt() % 100;
		}

		// System.out.println(Arrays.toString(integers));

		return integers;
	}
	
	public static void swapArrayElement(int leftElement, int rightElement, int[] arrays) {

		int tmp = arrays[leftElement];
		arrays[leftElement] = arrays[rightElement];
		arrays[rightElement] = tmp;
		increaseswapCount();

	}

	public static void printArray(int[] arrays) {

		System.out.printf("arrays: %s \n", Arrays.toString(arrays));
	}

	private static AtomicInteger compareCounter = new AtomicInteger(0);

	public static boolean increaseCompareCount() {
		compareCounter.getAndIncrement();
		return true;
	}

	public static AtomicInteger getCompareCount() {
		return compareCounter;
	}

	public static void initCompareCount() {
		compareCounter.set(0);
	}

	private static AtomicInteger swapCounter = new AtomicInteger(0);

	public static boolean increaseswapCount() {
		swapCounter.getAndIncrement();
		return true;
	}

	public static AtomicInteger getswapCount() {
		return swapCounter;
	}

	public static void initswapCount() {
		swapCounter.set(0);
	}

	public static void initCount() {
		initCompareCount();
		initswapCount();
	}
}
