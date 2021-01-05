import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class Tutorial extends JPanel implements ActionListener
{
	//Goeey version of sleep method
	arrayLister planets1 = null;
	linkedList planets2 = null;
	int timMillisecond = 5;
	Timer tm = new Timer(timMillisecond, this); //milllisecond, actionlsitener

	//calling upon class asks for lists
	public Tutorial(arrayLister b){

		this.planets1 = new arrayLister();
		System.out.println(planets1.size());

		this.planets1.setCounter(1);

		for(int i = 0; i < b.size(); i++){
			this.planets1.add(b.get(i));
		}

	}

	public Tutorial(linkedList b){

		planets2 = b;

		linkedList temp = b;

		planets2.printList(planets2);

	}

	//lists draws all planets at once since list in class itself is the only way to have all planets
	//appear on the frame
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			
			
			if(planets1 == null){ //if using a Linked list

				Boolean nextNodia = true;

				planets2.resetHead(planets2);
				
				
				while(nextNodia == true){
					nextNodia = planets2.hasNext(planets2);
					planets2.getHeadData(planets2).draw(g);
					planets2.nextHead(planets2);
				}

			}
			else{// if using an Array list
				for(int i = 0; i < this.planets1.size(); i++){
					this.planets1.get(i).draw(g);
				}
				tm.start();
			}
	
			
			
			//start timer for gravitational orbit
			tm.start(); 
		}
	
		public void actionPerformed(ActionEvent e)
		{
			//adds gravitational movement 
			//should be creating animation
			//makes the planets move in one direction instead
			if(planets1 == null){//ArrayList Planet

				Boolean nextNode = true;
				while(nextNode){
					nextNode = planets2.hasNext(planets2);
					this.planets2.getHeadData(planets2).addForce(planets2.first.data);
					this.planets2.getHeadData(planets2).update(0.0001);
					planets2.nextHead(planets2);
				}

			} else{ //ArrayList Planet
				for(int i = 0; i < planets1.size(); i++){
					if(i != 0){
						planets1.get(i).addForce(planets1.get(0));
						planets1.get(i).update(0.00001);
					}
				}
			}
	
			repaint(); //paints rectaing every millisecond
		}


}