package com.linkedlist;

class Link{
	public int iData;			//data item(key)
	public double dData;		//data item
	public Link next;			//next link in the list
//----------------------------------------------------------------
	public Link(int iData,double dData){
		this.iData=iData;
		this.dData=dData;
	}
//--------------------------------------------------------------------
	public void displayLink(){
			System.out.println("{"+iData+","+dData+"}");
	}
}//end of class Link
/////////////////////////////////////////////////////////////////
class LinkList{
	private Link first;				//ref to first link on list
	
//--------------------------------------------------------------------
	public LinkList(){		//constructor
		first=null;			//no item in the list yet
	}
//------------------------------------------------------------------
	public boolean isEmpty(){
		return (first==null);
	}
//------------------------------------------------------------------
	public void insertFirst(int iData,double dData){	//insert at first if list
		Link newLink=new Link(iData, dData);
		if(first!=null)
			{
			newLink.next=first;
			first=newLink;
			}
		else{
			first=newLink;
		}
		
	}
//-------------------------------------------------------------------
	public Link deleteFirst(){						//delete from first of list
		if(first==null){
			return null;					//if first node is null return null
		}
		else{
			Link temp=first;			//return the first node and update first node
			first=first.next;
			return temp;
		}
	}
//-------------------------------------------------------------------
	public void displayList(){
		System.out.println("List (first-->last):");
		Link current=first;
		while(current!=null){
			current.displayLink();	//print data
			current=current.next;	//move to next link
		}
		System.out.println("");
	}
	
}//end class LinkList
//------------------------------------------------------------------

public class LinkListApp {

	public static void main(String[] args) {
		
		LinkList theList=new LinkList();
		theList.insertFirst(22, 256);
		theList.insertFirst(12, 320);
		theList.insertFirst(25, 780);
		theList.insertFirst(4, 452);
		
		theList.displayList();
		
		while( !theList.isEmpty() ) // until it’s empty,
		{
		Link aLink = theList.deleteFirst(); // delete link
		System.out.print("Deleted "); // display it
		aLink.displayLink();
		System.out.println("");
		}
		theList.displayList();
	}

}
