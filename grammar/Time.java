
public class Time {
	private double value;
	private String units;
	
	public Time(double value){
		this.value = value;
		this.units = "s";
	}
	
	public Time(double value, String units){
		switch(units){
			
			case "ns": this.value = (double) (value * Math.pow(10, -9));
			break;			
			
			case "um": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "ms": this.value = (double) (value * Math.pow(10, -3));
			break;			
			
			case "s": this.value = value;
			break;	
			
		}
		this.units = "s";
	}
	
}
