public class CalphyMethods extends PhysicsMethods {

	public static PhysicsScalarType _ADD(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		if (lhs instanceof Mass) {
			return new Mass(lhs.value + rhs.value);
		} else if (lhs instanceof Power) {
			return new Power(lhs.value + rhs.value);
		} else if (lhs instanceof Time) {
			return new Time(lhs.value + rhs.value);
		}
		return null;
	}
	
	// public static PhysicsScalarType _ADD(PhysicsScalarType lhs, double rhs) {
	// 	if (lhs instanceof Mass) {
	// 		return _ADD(lhs, new Mass(rhs));
	// 	} else if (lhs instanceof Power) {
	// 		return _ADD(lhs, new Power(rhs));
	// 	} else if (lhs instanceof Time) {
	// 		return _ADD(lhs, new Time(rhs));
	// 	}
	// 	return null;
	// }
	//
	// public static PhysicsScalarType _ADD(double lhs, PhysicsScalarType rhs) {
	// 	return _ADD(rhs, lhs);
	// }
	
}