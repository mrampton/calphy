
public class Power {
	private double value;
	private String units;
	
	public Power(double value){
		this.value = value;
		this.units = "W";
	}
	
	public Power(double value, String units){
		switch(units){
			case "nW": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "uW": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "mW": this.value = (double) (value * Math.pow(10, -3));
			break;					
			
			case "W": this.value = value;
			break;			
			
			case "KW": this.value = (double) (value * Math.pow(10, 3));
			break;			
			
			case "MW": this.value = (double) (value * Math.pow(10, 6));
			break;
			
			case "GW": this.value = (double) (value * Math.pow(10, 9));
			break;
		}
		this.units = "W";
	}
	
}
