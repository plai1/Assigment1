import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import javax.swing.Timer;

public class Tutorial extends JPanel implements ActionListener
{
	//Goeey version of sleep method
	ArrayList<Body> planets = new ArrayList();
	Timer tm = new Timer(5, this); //milllisecond, actionlsitener
	int x = 0, velX = 2; //position horizontal, velocity of moving object

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
			g.setColor(planets.get(i).getColor());
			g.fillOval(planets.get(i).getX(), planets.get(i).getY(), planets.get(i).getSize(), planets.get(i).getSize());
		}

		//tm.start(); //start timer
	}

	public void actionPerformed(ActionEvent e)
	{
		if (x < 0 || x > 600)
			velX = -velX; //make sure object in frame

		x = x + velX; //move position in velX speed
		repaint(); //paints rectaing every millisecond
	}

}