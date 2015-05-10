class Force extends PhysicsVectorType {

	public Force(double x, double y) {
		this.x = x;
		this.y = y;
		this.units = "_N";
	}

	public Force(double x, double y, String units) {
		switch(units) {
			case "_kN": 
				this.x = x*1000;
				this.y = y*1000;
				break;
			case "_N":
				this.x = x;
				this.y = y;
				break;
			default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);
		}
		this.units = "_N";
	}
	
	public Force(Force f) {
		this.x = f.x;
		this.y = f.y;
		this.units = f.units;
	}
	
}
