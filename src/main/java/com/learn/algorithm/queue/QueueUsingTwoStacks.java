package com.learn.algorithm.queue;

import com.learn.algorithm.stack.SimpleStack;

public class QueueUsingTwoStacks {

	SimpleStack inbox ;
	SimpleStack outbox ;
	
	QueueUsingTwoStacks(int size){
		
		inbox = new SimpleStack(size);
		outbox = new SimpleStack(size);
		
	}
	
	
	// Utility function to remove front element from the queue
	public synchronized int dequeue()
	{
		
		if(outbox.isEmpty()) {
			System.exit(-1);
		}
		return  outbox.pop();
		
		
	}

	// enqueue
	public synchronized void enqueue(int item)
	{

		if(outbox.isEmpty()) {
			outbox.push(item);
		}
		
		else {
			
			while(!outbox.isEmpty())
			{
				inbox.push(outbox.pop());
			}
			
			outbox.push(item);
			
			while(!inbox.isEmpty())
			{
				
				outbox.push(inbox.pop());
				
			}
			
			
			
			
		}
		
		
	}
	
	public int size() {
		return outbox.size();
	}
	
	
	public static void main(String[] args)
	{
		QueueUsingTwoStacks newQueue = new QueueUsingTwoStacks(50);
		newQueue.enqueue(10);
		newQueue.enqueue(5);
		newQueue.enqueue(20);
		newQueue.enqueue(50);
		
		while(newQueue.size() >0)
		{
			//System.out.println(newQueue.size());
		   System.out.println(newQueue.dequeue());
		
		}
		
	}
	
}
