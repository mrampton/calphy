public abstract class PhysicsVectorType extends PhysicsType {
	double x, y;

	public void display() {
		System.out.println("<"+this.x+","+this.y+"> "+this.units);
	}
	
}