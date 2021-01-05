import java.util.*;
import java.awt.Color;

public class arrayLister
{
	public Body data[] = new Body[1]; //creates an arrayLister list size of one 
	public int counter = 1;
	public int sizer;


	public Body get(int pos){ //returns object in inputer index position
		sizer = pos;
		return data[pos];

	}

	public void setCounter(int count){ //set the counter of the number of incoming objects
		counter = count;
	}

	public void setSize(int size){ //set the size of the null data list to inputed number
		data = new Body[size];

	}

	public int size(){ //returns the length of the list
		return data.length;
	}

	public void add(Body bod){ //adds element to arraylist
		Body temp[] = new Body[counter + 1];

		if(data[0] == null){ //if the data is empty and adds the first element
			data[0] = bod;
		} else{ //if there is mroe objects to add
			for(int i = 0; i < data.length; i++){
				temp[i] = data[i];
				temp[counter] = bod;
			}
			counter++;
			data = temp;
		}
	}

	public String toString(){ //prints out all the object in its list into a string

		String res = "";

		for(int i = 0; i < data.length; i++){
			res += data[i] + ", ";
		}

		return res;
	}
	
};