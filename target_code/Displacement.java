class Displacement extends PhysicsVectorType {
	
	public Displacement(double x, double y){
	  	this.x = x;
	  	this.y = y;
		this.units = "_m";
	}
	
	public Displacement(double x, double y, String units){
		this.units = "_m";
		this.x = toSI(x, units);
		this.y = toSI(y, units);
	}

	public Displacement(Displacement d) {
		this.x = d.x;
		this.y = d.y;
		this.units = d.units;
	}	
	private double toSI(double value, String units) {
		switch(units) {
			case "_nm": return (double) (value * Math.pow(10, -9));
			case "_um": return (double) (value * Math.pow(10, -6));
			case "_mm": return (double) (value * Math.pow(10, -3));
			case "_km": return (double) (value * Math.pow(10, 3));
			default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);
		}
		return value; //else return value [m]
	}

}

