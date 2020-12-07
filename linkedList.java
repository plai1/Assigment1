import java.io.*;

public class linkedList
{
	Node head;

	//Node class
	static class Node
	{
		String data;
		Node next;

		Node(String d)
		{
			data=d;
			next=null;
		}
	}

	//insert new node
	public static linkedList insert(linkedList list, String data)
	{
		Node newNode = new Node(data);
		newNode.next = null;

		if(list.head == null)
			list.head = newNode;
		else{
			Node last = list.head;
			while(last.next != null)
				last=last.next;
			last.next = newNode;
		}

		return list;

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

	public static String getHeadData(linkedList list)
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
			return nextNode.data;
		} else{
			return "There is no next node.";
		}
	}

	public static boolean hasNext(linkedList list){
		Node currNode = list.head;
		return (currNode.next != null);
	}

	public static String isNode(linkedList list){
		Node currNode = list.head;
		return (currNode.data);
	}

};