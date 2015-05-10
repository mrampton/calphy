public class CalphyMethods extends PhysicsMethods {

	public static PhysicsScalarType _ADD(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		String cls = lhs.getClass().toString();
		switch(cls) {
			case "Mass": System.out.println("CLASS MASS");
		}
		return Mass.class.cast(lhs);
	}
	// public static Mass _ADD(double lhs, Mass rhs) {
	// 	return (_ADD(new Mass(lhs), rhs));
	// }
	// public static Mass _ADD(Mass lhs, double rhs) {
	// 	return (_ADD(lhs, new Mass(rhs)));
	// }
	
}