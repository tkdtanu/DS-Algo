package com.algo.stack.queue;

class Queue{
	private int maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int noOfItems;
	
//------------------------------------------------------------------
	public Queue(int size){				//constructor
		maxSize=size;
		queArray=new long[size];
		front=0;
		rear=-1;
		noOfItems=0;
		
	}//end of constructor
//------------------------------------------------------------------
	public void insert(long item){		//insert item at the rear of the queue
		if(isFull()){
			System.out.println("Sorry you cant add "+item+" till one item dequeued");
			
		}else{
		if(rear==maxSize-1)
			rear=-1;
		queArray[++rear]=item;			//increment rear and insert
		noOfItems++;					//update the no of items in the queue
		}
	}//end of insert()
//------------------------------------------------------------------
	public long remove(){
		if(isEmpty()){
			System.out.println("Sorry there is no element to remove");
			return 0;
		}else{
		long itemToRemove=queArray[front++];		//get the value and increment the front
		if(front==maxSize)
			front=0;
		noOfItems--;
		return itemToRemove;
		}
	}//end of remove()
//------------------------------------------------------------------
	public long peekFront(){
		long peekItem=queArray[front];			//get the peek item of the queue
		return peekItem;						//return the peek item
	}//end of peekFront()
//-------------------------------------------------------------------
	public boolean isEmpty(){
		return (noOfItems==0);					//true if noOfItem is 0
		}
//------------------------------------------------------------------
	public boolean isFull(){
		return (noOfItems==maxSize);			//true if queue is full
	}
//-----------------------------------------------------------------
	public int size(){
		return noOfItems;
	}
//-----------------------------------------------------------------
}//end of class Queue

public class QueueApp {

	public static void main(String[] args) {
		Queue queue=new Queue(5);
		queue.insert(14);
		queue.insert(20);
		queue.insert(40);
		queue.insert(100);
		queue.insert(34);
		queue.remove(); // remove 3 items
		queue.remove(); 
		queue.remove();
		queue.insert(50); // insert 4 more items
		queue.insert(60); 
		queue.insert(70);
		queue.insert(80);
		while( !queue.isEmpty() ) // remove and display
		{ 
		long n = queue.remove();
		System.out.print(n);
		System.out.print(" ");
		}
		System.out.println("");
		
	}//end of main

}//end of class QueueApp
