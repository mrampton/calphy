public class PhysicsScalarType extends PhysicsType {
	double value;

	public String toString() {
    return this.value + " " + this.units.replaceAll("_","");
	}

	
}