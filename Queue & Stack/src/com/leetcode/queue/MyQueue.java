package com.leetcode.queue;

import java.util.List;
import java.util.ArrayList;

public class MyQueue extends Queue{

	private List<Integer> mQueue;
	private int mStart;

	public MyQueue(int size){
		mQueue = new ArrayList<Integer>();
		mStart = 0;
	}

	public boolean enQueue(int arg){
		mQueue.add(arg);	
		return true;
	}

	public boolean deQueue(){
		if(isEmpty()){
			return false;	
		}
		int result = mQueue.get(mStart);
		mStart++;
		return true;
	}

	public boolean isEmpty(){
		return mQueue.size() <= mStart ;
	}
	
	public int Front(){
		return mQueue.get(mStart);
	}
	
	public int Rear(){
		return -1;
	}
	
	
	public boolean isFull(){
		return true;
	}

}
