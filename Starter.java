import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Starter{

	

	public static void main(String args[]) throws Exception
	{
		//reads and convert files to readable array
		File fileText = new File("nBodyInput.txt");
		BufferedReader br = new BufferedReader(new FileReader(fileText));
		String st;
		ArrayList<String> texts = new ArrayList<String>();
		while ((st = br.readLine()) != null){ //adds text to array
		 	texts.add(st);
		};

		//creates string arraylist
		String[] linesArray = texts.toArray(new String[texts.size()]);
		//Body list
		linkedList planets1 = null;
		arrayLister planets2 = null;
		//tutorial calling
		Tutorial t;

		//determiens if wanted list is to be ArrayList or LinkedList
		if(linesArray[0].equals("LinkedList")){ //LinkedList

			ArrayList<String> info = new ArrayList<String>();



			for(int i = 2; i < linesArray.length; i++){
				info.add(i - 2,linesArray[i]);
			};

			ListToBody bodi = new ListToBody(info.get(0));
			Body planeter = bodi.Bodify();
			planets1 = new linkedList(planeter);

			for(int i = 0; i < info.size(); i++){
				ListToBody bodier = new ListToBody(info.get(i));
				Body planet = bodier.Bodify();
				planets1.insert(planets1, planet);
			};	


		} else{ //ArrayList
			String[] listed = linesArray;
			planets2 = new arrayLister();

			//creates array list from own arraylist class
			for(int i = 2; i < listed.length; i++){
				ListToBody bodier = new ListToBody(listed[i]);
				Body planet = bodier.Bodify();
				planets2.add(planet);
			};

			System.out.println(planets2);

		};


		if(planets2 == null){
			t = new Tutorial(planets1);
		} else{
			t = new Tutorial(planets2);
		} 
		//set up planet on jframe and shows those planets
		
		JFrame jf = new JFrame();

		jf.setTitle("Tutorial");
		jf.setSize(768, 768);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.setVisible(true);
	}
}