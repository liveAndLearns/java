package com.learn.algorithm.queue;

import com.learn.algorithm.stack.SimpleStack;

public class QueueUsingTwoStacks {

	SimpleStack inbox ;
	SimpleStack outbox ;
	
	QueueUsingTwoStacks(){
		
		inbox = new SimpleStack(50);
		outbox = new SimpleStack(50);
		
	}
	
	
	// Utility function to remove front element from the queue
	public synchronized int dequeue()
	{
        //TODO
		int dequeueValue = 0;

		return dequeueValue;
	}

	// Utility function to add an item to the queue
	public synchronized void enqueue(int item)
	{
		//TODO
	}
	
	
	
}
