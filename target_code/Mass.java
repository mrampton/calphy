public class Mass<T> extends PhysicsScalarType<Mass> {

	public Mass(double value){
		this.value = value;
		this.units = "_kg";
	}
	
	public Mass(double value, String units){
		switch(units){
		
			case "_ng": this.value = (double) (value * Math.pow(10, -12));
			break;
			
			case "_ug": this.value = (double) (value * Math.pow(10, -9));
			break;			
			
			case "_mg": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "_g": this.value = (double) (value * Math.pow(10, -3));
			break;			
			
			case "_kg": this.value = value;
			break;		

			default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);	
								
		}
		this.units = "_kg";
	}

	public Mass(Mass m) {
		this.value = m.value;
		this.units = m.units;
	}	

	@Override
	public Mass add(Mass rhs) {
		return new Mass(value + rhs.value);
	}

}
