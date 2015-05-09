
public class Power {
	private double value;
	private String units;
	
	public Power(double value){
		this.value = value;
		this.units = "_W";
	}
	
	public Power(double value, String units){
		switch(units){
			case "_nW": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "_uW": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "_mW": this.value = (double) (value * Math.pow(10, -3));
			break;					
			
			case "_W": this.value = value;
			break;			
			
			case "_KW": this.value = (double) (value * Math.pow(10, 3));
			break;			
			
			case "_MW": this.value = (double) (value * Math.pow(10, 6));
			break;
			
			case "_GW": this.value = (double) (value * Math.pow(10, 9));
			break;
		}
		this.units = "_W";
	}
	
}
