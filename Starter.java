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
		ArrayList<Body> planets = new ArrayList<Body>();

		//determiens if wanted list is to be ArrayList or LinkedList
		if(linesArray[0].equals("LinkedList")){ //LinkedList
			linkedList listed = new linkedList();
			for(int i = 2; i < linesArray.length; i++){
				listed = listed.insert(listed, linesArray[i]);
			};
			//System.out.println("LinkedList");
			//listed.printList(listed);

			// System.out.println(listed.getHeadData(listed));
			// System.out.println(listed.nextHeadData(listed));
			Boolean nextNode = true;
			while(nextNode){
				nextNode = listed.hasNext(listed);
				listToBody bodier = new listToBody(listed.getHeadData(listed));
				Body planet = bodier.Bodify();
				planets.add(planet);
				listed.nextHead(listed);
			};	

		} else{ //ArrayList
			String[] listed = linesArray;
			System.out.println("ArrayList");
			System.out.println(listed[3]);
			System.out.println(Arrays.toString(listed));
 
			for(int i = 2; i < listed.length; i++){
				listToBody bodier = new listToBody(listed[i]);
				Body planet = bodier.Bodify();
				planets.add(planet);
				System.out.println(planet.toString());
			};

			System.out.println("Planets Size: " + planets.size());
		};




		//set up planet on jframe and shows those planets
		Galaxy t = new Galaxy(planets);
		
		JFrame jf = new JFrame();

		jf.setTitle("Tutorial");
		jf.setSize(768, 768);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
		jf.setVisible(true);
	}
}