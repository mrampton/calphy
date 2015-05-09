import java.util.*;
class Force {

	double x;
	double y;
	String units;

	Force(double x, double y) {
		this.x = x;
		this.y = y;
		this.units = "_N";
	}

	Force(double x, double y, String units) {
		switch(units) {
			case "_kN": 
				this.x = x/1000;
				this.y = y/1000;
				break;
			case "_N":
				this.x = x;
				this.y = y;
				break;
		}
		this.units = "_N";
	}
}
