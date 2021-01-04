import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class Tutorial extends JPanel implements ActionListener
{
	//Goeey version of sleep method
	ArrayList<Body> planets = new ArrayList();
	int timMillisecond = 5;
	Timer tm = new Timer(timMillisecond, this); //milllisecond, actionlsitener

	//calling upon class asks for lists
	public Tutorial(ArrayList<Body> b){
		for(int i = 0; i < b.size(); i++){
			this.planets.add(b.get(i));
		}
	}

	//lists draws all planets at once since list in class itself is the only way to have all planets
	//appear on the frame
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		for(int i = 0; i < this.planets.size(); i++){
			this.planets.get(i).draw(g);
		}

		
		
		//start timer for gravitational orbit
		tm.start(); 
	}

	public void actionPerformed(ActionEvent e)
	{
		//adds gravitational movement 
		//should be creating animation
		//makes the planets move in one direction instead
		for(int i = 0; i < planets.size(); i++){
			if(i != 0){
				planets.get(i).addForce(planets.get(0));
				planets.get(i).update(0.000001);
			}
		}

		repaint(); //paints rectaing every millisecond
	}

}