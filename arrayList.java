import java.util.*;
import java.awt.Color;

public static class arrayToBody
{
	public String [] data;

	public ArrayToBody(String list){
		this.data = list.split(",");
	}

	public Body bodify(){
		String name = this.data[0];
		Double mass = Double.parseDouble(this.data[1]);
		Double rx = Double.parseDouble(this.data[2])


	}
	
};