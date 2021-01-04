import java.awt.*;
import java.util.Random;

public class Body {

  private static final double G = 6.673e-11;   // gravitational constant

  public String name;
  public double mass;         // mass
  public double rx, ry;       // holds the cartesian positions
  public double vx, vy;       // velocity components 
  public double fx, fy;        // force components
  public double siz;          // size of the planet in pixels
  public Color color;         //Color of the planet
  Random rand = new Random(); //random number generator for color

  // create and initialize a new Body
  public Body(String name, double mass, double rx, double ry, double vx, double vy, double siz) {
    this.name  = name;
    this.mass  = mass;
    this.rx    = rx;
    this.ry    = ry;
    this.vx    = vx;
    this.vy    = vy;
    this.siz   = siz;
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    this.color = new Color(r, g, b);
  }
  
  // update the velocity and position using a timestep dt
  public void update(double dt) {
    this.vx += dt * this.fx / this.mass;
    this.vy += dt * this.fy / this.mass;
    this.rx += dt * this.vx;
    this.ry += dt * this.vy;
    
  }
  
  // returns the distance between two bodies
  public double distanceTo(Body b) {
    double dx = rx - b.rx;
    double dy = ry - b.ry;
    return Math.sqrt(dx*dx + dy*dy);
  }
  
  // set the force to 0 for the next iteration
  public void resetForce() {
    fx = 0.0;
    fy = 0.0;
  }
  
  // compute the net force acting between the body a and b, and
  // add to the net force acting on a
  public void addForce(Body b) {
    Body a = this;
    double dx = b.rx - a.rx;
    double dy = b.ry - a.ry;
    double dist = Math.sqrt(dx*dx + dy*dy);
    double F = (G * a.mass * b.mass) / (dist*dist);
    a.fx += F * dx / dist;
    a.fy += F * dy / dist;
  }

  public void draw(Graphics g){
    g.setColor(this.getColor());
    g.fillOval(this.getX(), this.getY(), this.getSize(), this.getSize());
  }
  
  // convert to string representation formatted nicely
  public String toString() {
    return "" + name + ", "+ rx + ", "+ ry+ ", "+  vx+ ", "+ vy+ ", "+ mass;
  }

  public int getMass(){
    return (int)this.mass;
  }

  public int getX(){
    return (int)this.rx;
  }

  public int getY(){
    return (int)this.ry;
  }

  public int getVX(){
    return (int)this.vx;
  }

  public int getVY(){
    return (int)this.vy;
  }

  public int getSize(){
    return (int)this.siz;
  }

  public Color getColor(){
    return this.color;
  }
}