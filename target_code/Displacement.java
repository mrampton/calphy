public class Displacement {
	private double value;
	private String units;
	
	public Displacement(double value){
		this.value = value;
		this.units = "m";
	}
	
	public Displacement(double value, String units){
		switch(units){
			case "nm": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "um": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "mm": this.value = (double) (value * Math.pow(10, -3));
			break;			

			case "m": this.value = value;
			break;			
			
			case "km": this.value = (double) (value * Math.pow(10, 3));
			break;								
		}
		this.units = "m";
	}
	
}

