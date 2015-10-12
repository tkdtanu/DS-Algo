package com.sort;

//class for Array of Elements---------------------
class ArraySel{
	private long[] elements;
	private int noOfElements;
	
	//constructor to intitialize the array
	public ArraySel(int max) {
		super();
		elements=new long[max];
		noOfElements=0;			//no of elements is zero
	}//end of constructor
	//---------------------------------------
	
	//method for insert element into array
	
	public void insert(long value){
		elements[noOfElements]=value;
		noOfElements++;
		
	}//end of insert()
//--------------------------------------------------------
	//method for displaying the array elements
	public void display(){
		for(int j=0;j<noOfElements;j++){
			System.out.print(" "+elements[j]);
		}
		System.out.println("");		//for new line
	}//end of display()
//---------------------------------------------------------
	//method for selectionSort()
	public void selectionSort(){
		for(int i=0;i<noOfElements-1;i++){
			
			for(int j=i+1;j<noOfElements;j++){
				if(elements[i]>elements[j]){
					swap(i,j);
				}
			}
		}
	}//end of selectioSort()
//---------------------------------------------------------
	//method for swapping two element in array
	public void swap(int one,int two){
		long temp=elements[one];
		elements[one]=elements[two];
		elements[two]=temp;
	}//end of swap()
	
}//end of class Arraysel
//-------------------------------------------------------------------------------

public class SelectionSort {

	public static void main(String[] args) {
		int maxSize=100;
		ArraySel arr;
		arr=new ArraySel(maxSize);
		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);
		
		arr.display();		//display all elements
		
		arr.selectionSort();	//sort the elements 
		
		arr.display();		//display them again
	}//end of main()

}//end of BubbleSort
