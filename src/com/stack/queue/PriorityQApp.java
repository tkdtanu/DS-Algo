package com.stack.queue;

class PriorityQ{
	private int maxSize;
	private long[] queArray;
	private int noOfItems;
	
	PriorityQ(int size){
		maxSize=size;
		queArray=new long[size];		//create the priority queue
		noOfItems=0;
	}
//---------------------------------------------------------------------
	public void insert(long item){		//insert item to queue
		if(isFull()){
			System.out.println("Sorry Queue is full. wait till someone getting dequeued");
		}
		else{
			int j;				//for tarct the position to insert the data
			if(noOfItems==0){
				queArray[noOfItems++]=item;
			}
			else{
				for(j=noOfItems-1;j>=0;j--){
					if(item>queArray[j])		//check if the inserted item is larger
						queArray[j+1]=queArray[j];	//shift data upward
					else
						break;
				}
				queArray[j+1]=item;
				noOfItems++;
			}
		}
		
	}
//---------------------------------------------------------------------------
	public long remove(){					//remove less priority item
		if(isEmpty()){
			System.out.println("There is no item in the queue");
			return -1;
		}
		else{
			return queArray[--noOfItems];			
		}
	}
//----------------------------------------------------------------------------
	public long peekMin(){					//retrive the less priority item
		return queArray[noOfItems-1];
	}
//--------------------------------------------------------------------------
	public boolean isEmpty(){		//check whether the queue is empty or not
		return (noOfItems==0);
		
	}
//-----------------------------------------------------------------------
	public boolean isFull(){		//check whether the queue is full or not
		return (noOfItems==maxSize);
	}
//---------------------------------------------------------------------------
	
}//end of class PriorityQ
////////////////////////////////////////////////////////////////////////////
public class PriorityQApp {

	public static void main(String[] args) {
		PriorityQ thePQ = new PriorityQ(5);
		thePQ.insert(30);
		thePQ.insert(50);
		thePQ.insert(10);
		thePQ.insert(40);
		thePQ.insert(20);
		thePQ.insert(80);
		while( !thePQ.isEmpty() )
		{
		long item = thePQ.remove();
		System.out.print(item + " "); // 10, 20, 30, 40, 50
		} // end while
		System.out.println("");
	}

}
