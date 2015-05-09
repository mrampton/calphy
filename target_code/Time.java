
public class Time {
	private double value;
	private String units;
	
	public Time(double value){
		this.value = value;
		this.units = "_s";
	}
	
	public Time(double value, String units){
		switch(units){
			
			case "_ns": this.value = (double) (value * Math.pow(10, -9));
			break;			
			
			case "_um": this.value = (double) (value * Math.pow(10, -6));
			break;			
			
			case "_ms": this.value = (double) (value * Math.pow(10, -3));
			break;			
			
			case "_s": this.value = value;
			break;	
			
		}
		this.units = "_s";
	}
	
}
