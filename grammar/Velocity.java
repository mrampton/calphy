import java.util.*;
import java.io.*;
class Velocity {
	  double value_x;
	  double value_y;
	  String units;
	 
	  Velocity(double value_x, double value_y) {
	  	this.value_x = value_x;
	  	this.value_y = value_y;
	  	this.units = "m/s";
	  }
	 
	  Velocity(double value_x, double value_y, String units) {
	  	String [] unitlist = units.split("/");
	 
	  	switch(unitlist[0]) {
	  		case "nm":
	  			this.value_x = value_x*Math.pow(10,-9);
	  			this.value_y = value_y*Math.pow(10,-9);
	  			break;
	  		case "mm":
	  			this.value_x = value_x*Math.pow(10,-3);
	  			this.value_y = value_y*Math.pow(10,-3);
	  			break;
	  		case "cm":
	  			this.value_x = value_x*Math.pow(10,-2);
	  			this.value_y = value_y*Math.pow(10,-2);
	  			break;
	  		case "m":
	  			this.value_x = value_x;
	  			this.value_y = value_y;
	  			break;
	  		case "km":
	  			this.value_x = value_x*1000;
	  			this.value_y = value_y*1000;
	  			break;
	  		default:
	  			System.out.println("error\n");
	  	}
	 
	  	switch(unitlist[1]) {
	  		case "ns":
	  			this.value_x = value_x/(Math.pow(10,-9));
	  			this.value_y = value_y/(Math.pow(10,-9));
	  			break;
	  		case "ms":
	  			this.value_x = value_x/(Math.pow(10,-3));
	  			this.value_y = value_y/(Math.pow(10,-3));
	  		case "s":
	  			this.value_x = value_x;
	  			this.value_y = value_y;
	  			break;
	  		case "h":
	  			this.value_x = value_x/(60);
	  			this.value_y = value_y/(60);
	  			break;
	  		default:
	  			System.out.println("error\n");
	  	}
	 
	  	this.units = "m/s";
	  }
}
