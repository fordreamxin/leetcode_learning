package com.leetcode.queue;

import java.util.ArrayList;
import java.util.List;


//循环队列里，对于数组而言，可以用“取余”来实现“循环”。这是“循环”得以实现的关键。
class MyCircularQueue extends Queue{

    private List<Integer> mQueue;
    private int mHead;
    private int mTail;
    private int mSize;
	private int mCount;//多增加了一个mCount变量，可以方便的实现isEmpty和isFull
    private static final int INVALID = -1;
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        mHead = INVALID;
        mTail = INVALID;
        mSize = k;
        mQueue = new ArrayList<Integer>(k);
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
		if(mHead == INVALID){
			mHead++;
		}
        mTail++;
		mTail = mTail % mSize;
		mCount++;
        mQueue.add(mTail, value);
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(mHead == mTail){
			mHead = mTail = INVALID;
			mCount--;
			return true;
        }
        mHead++;
		mHead = mHead % mSize;
		mCount--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return INVALID;
        }
        return mQueue.get(mHead);
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return INVALID;
        }
        return mQueue.get(mTail);
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return (mHead == INVALID);
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (mCount == mSize);
    }
}



/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */