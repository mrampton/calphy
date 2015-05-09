
public class Energy {
	private double value;
	private String units;
	
	public Energy(double value){
		this.value = value;
		this.units = "J";
	}
	
	public Energy(double value, String units){
		switch(units){
			case "nJ": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "uJ": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "mJ": this.value = (double) (value * Math.pow(10, -3));
			break;					
			
			case "J": this.value = value;
			break;			
			
			case "KJ": this.value = (double) (value * Math.pow(10, 3));
			break;			
			
			case "MJ": this.value = (double) (value * Math.pow(10, 6));
			break;
			
			case "GJ": this.value = (double) (value * Math.pow(10, 9));
			break;
		}
		this.units = "J";
	}
}
