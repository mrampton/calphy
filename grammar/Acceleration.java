import java.util.*;
import java.io.*;
class Acceleration {
	// double value_x;
	// double value_y;
	// String units;
	//
	// Acceleration(double value_x, double value_y) {
	// 	this.value_x = value_x;
	// 	this.value_y = value_y;
	// 	this.units = "m/s^2";
	// }
	//
	// Acceleration(double value_x, double value_y, String units) {
	// 	String unitlist = units.split("/");
	//
	// 	switch(unitlist[0]) {
	// 		case "nm":
	// 			this.value_x = value_x*Math.exp(10,-9);
	// 			this.value_y = value_y*Math.exp(10,-9);
	// 			break;
	// 		case "mm":
	// 			this.value_x = value_x*Math.exp(10,-3);
	// 			this.value_y = value_y*Math.exp(10,-3);
	// 			break;
	// 		case "cm":
	// 			this.value_x = value_x*Math.exp(10,-2);
	// 			this.value_y = value_y*Math.exp(10,-2);
	// 			break;
	// 		case "m":
	// 			this.value_x = value_x;
	// 			this.value_y = value_y;
	// 			break;
	// 		case "km":
	// 			this.value_x = value_x*1000;
	// 			this.value_y = value_y*1000;
	// 			break;
	// 		default:
	// 			System.out.println("error\n");
	// 	}
	//
	// 	unitlist[1] = unitlist[1].substring(0, unitlist[1].length - 2);		//trim trailing '^2'
	// 	switch(unitlist[1]) {
	// 		case "ns":
	// 			this.value_x = value_x/(Math.exp(10,-9)*Math.exp(10,-9));
	// 			this.value_y = value_y/(Math.exp(10,-9)*Math.exp(10,-9));
	// 			break;
	// 		case "ms":
	// 			this.value_x = value_x/(Math.exp(10,-3)*Math.exp(10,-3));
	// 			this.value_y = value_y/(Math.exp(10,-3)*Math.exp(10,-3));
	// 			break;
	// 		case "s":
	// 			this.value_x = value_x;
	// 			this.value_y = value_y;
	// 			break;
	// 		case "h":
	// 			this.value_x = value_x/(60*60);
	// 			this.value_y = value_y/(60*60);
	// 			break;
	// 		default:
	// 			System.out.println("error\n");
	// 	}
	//
	// 	this.units = "m/s^2";
	// }
}
