import java.io.*;

public class linkedList
{
	Node head;
	Node first;

	//Node class
	static class Node
	{
		Body data = null;
		Node next = null;

		Node(Body d)
		{
			data=d;
			next=null;
		}

		public String toString(){
			String res = "";
			res += this.data;

			return res;
		}
	}

	//insert new node

	public linkedList(Body data){
		insert(this, data);
	}

	public static void insert(linkedList list, Body data)
	{
		Node newNode = new Node(data);
		newNode.next = null;

		if(list.head == null){
			list.head = newNode;
			list.first = newNode;
		}
		else{
			Node last = list.head;
			while(last.next != null)
				last=last.next;
			last.next = newNode;
		}


	}

	//print linkedlist
	public static void printList(linkedList list)
	{
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.data + " "); 
   
            // Go to
            currNode = currNode.next; 
        } 
	}

	public static Body getHeadData(linkedList list)
	{
		Node currNode = list.head;
		return(currNode.data);
	}

	public static void nextHead(linkedList list)
	{
		Node currNode = list.head;

		if (currNode.next != null)
		{
			list.head = currNode.next;
		} 
	}

	public static String nextHeadData(linkedList list)
	{
		Node currNode = list.head;

		if(currNode.next != null)
		{
			Node nextNode = currNode.next;
			return nextNode.data.toString();
		} else{
			return "There is no next node.";
		}
	}

	public static void resetHead(linkedList list)
	{
		Node currNode = list.head;
		list.head = list.first;
	}

	public static void secondHead(linkedList list)
	{
		Node currNode = list.head;
		list.head = list.first.next;
	}

	public static boolean hasNext(linkedList list){
		Node currNode = list.head;
		return (currNode.next != null);
	}


	public static Body isNode(linkedList list){
		Node currNode = list.head;
		return (currNode.data);
	}


};