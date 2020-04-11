package com.learn.algorithm.stack;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleStack {
	   private int maxSize;
	   private int[] stackArray;
	   private AtomicInteger top;
	   
	   public SimpleStack(int maxSize) {
	      this.maxSize = maxSize;
	      stackArray = new int[maxSize];
	      top = new AtomicInteger(-1);
	   }
	   public void push(int j) {
	      stackArray[top.incrementAndGet()] = j;
	   }
	   public int pop() {
	      return stackArray[top.getAndDecrement()];
	   }
	   public int peek() {
	      return stackArray[top.get()];
	   }
	   public boolean isEmpty() {
	      return (top.get() == -1);
	   }
	   public boolean isFull() {
	      return (top.get()== ( maxSize - 1));
	   }
	   public int size() {
		   return top.get()+1;
	   }
	   public static void main(String[] args) {
		   SimpleStack theStack = new SimpleStack(10); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	      theStack.push(40);
	      theStack.push(50);
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	    System.out.print("  ");
	      }
	      System.out.println("");
	   }
}
