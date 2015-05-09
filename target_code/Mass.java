public class Mass {
	private double value;
	private String units;
	
	public Mass(double value){
		this.value = value;
		this.units = "kg";
	}
	
	public Mass(double value, String units){
		switch(units){
		
			case "ng": this.value = (double) (value * Math.pow(10, -12));
			break;
			
			case "ug": this.value = (double) (value * Math.pow(10, -9));
			break;			
			
			case "mg": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "g": this.value = (double) (value * Math.pow(10, -3));
			break;			
			
			case "kg": this.value = value;
			break;			
								
		}
		this.units = "kg";
	}
	
	
}
