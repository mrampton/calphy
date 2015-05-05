import java.util.*;
class Force {

	double value;
	String units;

	Force(double value) {
		this.value = value;
		this.units = "N";
	}

	Force(double value, String units) {
		switch(units) {
			case "kN": 
				this.value = value/1000;
				break;
			case "N":
				this.value = value;
				break;
		}
		this.units = "N";
	}

	public static void main(String args[]) {}
}
