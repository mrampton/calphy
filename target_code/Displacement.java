public class Displacement {
	public double x, y;
	public String units;
	
	public Displacement(double x, double y){
	  	this.x = x;
	  	this.y = y;
		this.units = "_m";
	}
	
	public Displacement(double x, double y, String units){
		this.units = "_m";
		this.x = toSI(x);
		this.y = toSI(y);
	}
	
	private double toSI(double value) {
		switch(units) {
			case "_nm": return (double) (value * Math.pow(10, -9));
			case "_um": return (double) (value * Math.pow(10, -6));
			case "_mm": return (double) (value * Math.pow(10, -3));
			case "_km": return (double) (value * Math.pow(10, 3));
		}
		return value; //else return value [m]
	}
}

