package com.leetcode.queue;

public abstract class Queue{
	
	public abstract boolean enQueue(int value);
	
	public abstract boolean deQueue();
	
	public abstract int Front();
	
	public abstract int Rear();
	
	public abstract boolean isEmpty();
	
	public abstract boolean isFull();
}