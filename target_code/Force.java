import java.util.*;
class Force {

	double value_x;
	double value_y;
	String units;

	Force(double value_x, double value_y) {
		this.value_x = value_x;
		this.value_y = value_y;
		this.units = "N";
	}

	Force(double value_x, double value_y, String units) {
		switch(units) {
			case "kN": 
				this.value_x = value_x/1000;
				this.value_y = value_y/1000;
				break;
			case "N":
				this.value_x = value_x;
				this.value_y = value_y;
				break;
		}
		this.units = "N";
	}
}
