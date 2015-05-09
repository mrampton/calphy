
public class Energy {
	private double value;
	private String units;
	
	public Energy(double value){
		this.value = value;
		this.units = "_J";
	}
	
	public Energy(double value, String units){
		switch(units){
			case "_nJ": this.value = (double) (value * Math.pow(10, -9));
			break;
			
			case "_uJ": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "_mJ": this.value = (double) (value * Math.pow(10, -3));
			break;					
			
			case "_J": this.value = value;
			break;			
			
			case "_KJ": this.value = (double) (value * Math.pow(10, 3));
			break;			
			
			case "_MJ": this.value = (double) (value * Math.pow(10, 6));
			break;
			
			case "_GJ": this.value = (double) (value * Math.pow(10, 9));
			break;
		}
		this.units = "_J";
	}
}
