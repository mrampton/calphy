public class CalphyMethods extends PhysicsMethods {

	public static Mass _ADD(Mass lhs, Mass rhs) {
		return lhs.add(rhs);
	}
	public static Mass _ADD(double lhs, Mass rhs) {
		return (_ADD(new Mass(lhs), rhs));
	}
	public static Mass _ADD(Mass lhs, double rhs) {
		return (_ADD(lhs, new Mass(rhs)));
	}
	
}