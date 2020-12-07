import java.util.*;

public class listToBody
{
	public String [] data;

	public arrayToBody(String list){
		this.data = list.split(",");
	}

	public Body Bodify(){
		String name = this.data[0];
		Double mass = Double.parseDouble(this.data[1]);
		Double rx = Double.parseDouble(this.data[2]);
		Double ry = Double.parseDouble(this.data[3]);
		Double vx = Double.parseDouble(this.data[4]);
		Double vy = Double.parseDouble(this.data[5]);
		Double size = Double.parseDouble(this.data[6]);

		Body res = new Body(name, mass, rx, ry, vx, vy ,size);

		return res;
	}
	
};