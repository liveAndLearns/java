package com.learn.algorithm.stack;

import com.learn.algorithm.queue.SimpleQueue;

public class StackUsingTwoQueues {
	SimpleQueue queue1;
	SimpleQueue queue2;
	
	StackUsingTwoQueues()
	{
		queue1=new SimpleQueue(50);
		queue2=new SimpleQueue(50);
	}
 
 
	// Remove value from the beginning of the list for demonstrating behaviour of stack
	public void push(int i){
		if(queue1.size()==0)
			queue1.enqueue(i);
		else{
			int sizeOfQueue1 = queue1.size();
			// Copy elements of Queue1 to Queue2
			for(int j=0 ; j<sizeOfQueue1 ; j++)
				queue2.enqueue(queue1.dequeue());
			queue1.enqueue(i);
			// Copy elements for Queue2 to Queue1
			for(int k=0 ; k<sizeOfQueue1 ; k++)
				queue1.enqueue(queue2.dequeue());
		}
	}
 
	public int pop(){
		if(queue1.size()==0)
			{
			System.out.println("stack is empty now!");
			
			}
		return queue1.dequeue();
	}
 
	public static void main(String[] args) {
		StackUsingTwoQueues stack = new StackUsingTwoQueues();
		stack.push(20);
		stack.push(40);
		stack.push(70);
		stack.push(50);
		stack.push(90);
		stack.push(110);
		stack.push(30);
		System.out.println("Removed element : "+ stack.pop());
		stack.push(170);
		System.out.println("Removed element : "+ stack.pop());
	}
}