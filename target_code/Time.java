
public class Time {
	public double value;
	public String units;
	
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
			
			case "_min": this.value = (double) (value * 60);
			break;

			case "_hr": this.value = (double) (value * 3600);
			break;
	
			case "_s": this.value = value;
			break;

			default: System.out.println("Error. Invalid unit. Exiting."); System.exit(0);	
		}
		this.units = "_s";
	}
	
	public Time(Time t) {
		this.value = t.value;
		this.units = t.units;
	}

	public display() {
                System.out.println(this.value+" "+this.units);
        }
}
