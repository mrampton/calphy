public abstract class PhysicsVectorType extends PhysicsType {
	double x, y;

	public String toString() {
		return "<" + this.x + ", " + this.y + "> " + this.units.replaceAll("_","");
	}
	
}