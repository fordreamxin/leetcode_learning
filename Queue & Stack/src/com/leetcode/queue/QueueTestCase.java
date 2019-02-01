package com.leetcode.queue;

public class QueueTestCase{

	public static final String[] inputs1 = {
		"MyCircularQueue","enQueue","isFull","enQueue","enQueue","isFull","enQueue","enQueue","enQueue","Front","Front","Rear","enQueue","Rear","enQueue","Rear","Front","enQueue","enQueue","Front","enQueue","enQueue","Rear","enQueue","isEmpty","Rear","Front","Rear","enQueue","Front","enQueue","Rear","isEmpty","Rear","enQueue","Front","Front","deQueue","enQueue","Front","enQueue","enQueue","deQueue","enQueue","isFull","Front","enQueue","deQueue","enQueue","isEmpty","isEmpty","enQueue","Front","Front","Rear","deQueue","Front","enQueue","Rear","enQueue","Rear","Rear","Front","deQueue","enQueue","deQueue","Rear","enQueue","Front","enQueue","enQueue","deQueue","enQueue","Front","enQueue","deQueue","enQueue","Front","Front","enQueue","enQueue","enQueue","Front","enQueue","enQueue","Rear","deQueue","enQueue","Front","enQueue","enQueue","Rear","enQueue","enQueue","Rear","isFull","enQueue","Rear","enQueue","deQueue","Rear","enQueue"
	};

	public static final String[] inputs2 = {
		"30","71","","32","1","","32","8","6","","","","8","","3","","","56","41","","14","6","","25","","","","","44","","84","","","","59","","","","4","","40","11","","94","","","72","","19","","","20","","","","","","58","","54","","","","","65","","","59","","26","10","","14","","2","","37","","","46","63","42","","84","30","","","49","","79","46","","97","83","","","76","","79","","","44"
	};
	
	private static Queue mQueue;
	
	static{
		
		if("MyQueue".equals(inputs1[0])){
			mQueue = new MyQueue(Integer.valueOf(inputs2[0]));
		}else if("MyCircularQueue".equals(inputs1[0])){
			mQueue = new MyCircularQueue(Integer.valueOf(inputs2[0]));
		}else{
			System.out.println("wrong function argument");
		}
	}

	public static void main(String[] args){
		if(inputs1.length != inputs2.length){
			System.out.println("input error");
			return;
		}		
		StringBuilder builder = new StringBuilder("null, ");
		for(int i = 1; i < inputs1.length - 1; i++){
			int arg2 = 0;
			String arg = inputs2[i];
			if(arg != null && !arg.equals("")){
				arg2 = Integer.valueOf(arg);
			}
			builder.append(queueFunction(inputs1[i], arg2)).append(",");
		}
		System.out.println("out = " + builder);
	}
	
	private static String queueFunction(String func, int arg1){
		if(func == null || func.equals("")){
			System.out.println("queueFunction func null!");
			return "error";
		}
		
		if("enQueue".equals(func)){
			boolean result = mQueue.enQueue(arg1);
			if(result){
				return "true";
			}else{
				return "false";
			}
		}else if("deQueue".equals(func)){
			boolean result = mQueue.deQueue();
			if(result){
				return "true";
			}else{
				return "false";
			}
		}else if("Front".equals(func)){
			int result = mQueue.Front();
			return String.valueOf(result);
		}else if("Rear".equals(func)){
			int result = mQueue.Rear();
			return String.valueOf(result);
		}else if("isEmpty".equals(func)){
			boolean result = mQueue.isEmpty();
			if(result){
				return "true";
			}else{
				return "false";
			}
		}else if("isFull".equals(func)){
			boolean result = mQueue.isFull();
			if(result){
				return "true";
			}else{
				return "false";
			}
		}
		return "none match";
	}
}
