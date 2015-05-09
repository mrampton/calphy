public class Displacement {
	private double value;
	private String units;
	
	public Displacement(double value){
		this.value = value;
		this.units = "_m";
	}
	
	public Displacement(double value, String units){
		switch(units) {
			case "_nm": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "_um": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "_mm": this.value = (double) (value * Math.pow(10, -3));
			break;			

			case "_m": this.value = value;
			break;			
			
			case "_km": this.value = (double) (value * Math.pow(10, 3));
			break;								
		}
		this.units = "_m";
	}
	
}

