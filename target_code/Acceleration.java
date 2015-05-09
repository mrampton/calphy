import java.util.*;
import java.io.*;
import java.lang.*;
class Acceleration {
	  double x;
	  double y;
	  String units;
	 
	  Acceleration(double x, double y) {
	  	this.x = x;
	  	this.y = y;
	  	this.units = "_m/s^2";
	  }
	 
	  Acceleration(double x, double y, String units) {
	  	String [] unitlist = units.split("/");
	 
	  	switch(unitlist[0]) {
	  		case "_nm":
	  			this.x = x*Math.pow(10,-9);
	  			this.y = y*Math.pow(10,-9);
	  			break;
	  		case "_mm":
	  			this.x = x*Math.pow(10,-3);
	  			this.y = y*Math.pow(10,-3);
	  			break;
	  		case "_cm":
	  			this.x = x*Math.pow(10,-2);
	  			this.y = y*Math.pow(10,-2);
	  			break;
	  		case "_m":
	  			this.x = x;
	  			this.y = y;
	  			break;
	  		case "_km":
	  			this.x = x*1000;
	  			this.y = y*1000;
	  			break;
	  		default:
	  			System.out.println("error\n");
	  	}
	 
	  	unitlist[1] = unitlist[1].substring(0, unitlist[1].length() - 2);		 //trim trailing '^2'
	  	switch(unitlist[1]) {
	  		case "ns":
	  			this.x = x/(Math.pow(10,-9)*Math.pow(10,-9));
	  			this.y = y/(Math.pow(10,-9)*Math.pow(10,-9));
	  			break;
	  		case "ms":
	  			this.x = x/(Math.pow(10,-3)*Math.pow(10,-3));
	  			this.y = y/(Math.pow(10,-3)*Math.pow(10,-3));
	  			break;
	  		case "s":
	  			this.x = x;
	  			this.y = y;
	  			break;
	  		case "h":
	  			this.x = x/(60*60);
	  			this.y = y/(60*60);
	  			break;
	  		default:
	  			System.out.println("error\n");
	  	}
	 
	  	this.units = "_m/s^2";
	}

	public Acceleration(Acceleration a) {
		this.x = a.x;
		this.y = a.y;
		this.units = a.units;
	}
}
