class Velocity extends PhysicsVectorType {
	  

	  Velocity(){
	      
	  }
	  Velocity(double x, double y) {
	  	this.x = x;
	  	this.y = y;
	  	this.units = "_m/s";
	  }
	 
	  Velocity(double x, double y, String units) {
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

	  		default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);
	  	}
	 
	  	switch(unitlist[1]) {
	  		case "ns":
	  			this.x = x/(Math.pow(10,-9));
	  			this.y = y/(Math.pow(10,-9));
	  			break;
	  		case "ms":
	  			this.x = x/(Math.pow(10,-3));
	  			this.y = y/(Math.pow(10,-3));
	  		case "s":
	  			this.x = x;
	  			this.y = y;
	  			break;
	  		case "h":
	  			this.x = x/(60);
	  			this.y = y/(60);
	  			break;

	  		default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);
	  	}
	 
	  	this.units = "_m/s";
	  }

	Velocity(Velocity v) {
		this.x = v.x;
		this.y = v.y;
		this.units = v.units;
	}

}
