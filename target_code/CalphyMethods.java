public class CalphyMethods extends PhysicsMethods {

	//// ScalarTypes

	public static PhysicsScalarType _SUB(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		return _ADD(lhs, rhs.value * -1);
	}

	public static PhysicsScalarType _SUB(PhysicsScalarType lhs, double rhs) {
		return _ADD(lhs, rhs * -1);
	}
	
	public static PhysicsScalarType _SUB(double lhs, PhysicsScalarType rhs) {
		PhysicsScalarType flip =  _SUB(rhs, lhs);
		flip.value = flip.value * -1;
		return flip;
	}
	
	public static PhysicsScalarType _SUB(double lhs, String units, PhysicsScalarType rhs) {
		if (rhs instanceof Mass) {
			return _SUB(new Mass(lhs, units), rhs);
		} else if (rhs instanceof Power) {
			return _SUB(new Power(lhs, units), rhs);
		} else if (rhs instanceof Time) {
			return _SUB(new Time(lhs, units), rhs);
		}
		return null;
	}
	
	public static PhysicsScalarType _SUB(PhysicsScalarType lhs, double rhs, String units) {
		if (lhs instanceof Mass) {
			return _SUB(lhs, new Mass(rhs, units));
		} else if (lhs instanceof Power) {
			return _SUB(lhs, new Power(rhs, units));
		} else if (lhs instanceof Time) {
			return _SUB(lhs, new Time(rhs, units));
		}
		return null;
	}
	
	//
	// public static PhysicsScalarType _SUB(PhysicsScalarType lhs, double rhs, String units) {
	// 	System.out.println(lhs.value + "-" + rhs);
	// 	return _SUB(rhs, units, lhs);
	// }
	
	
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

	public static PhysicsScalarType _ADD(PhysicsScalarType lhs, double rhs) {
		if (lhs instanceof Mass) {
			return _ADD(lhs, new Mass(rhs));
		} else if (lhs instanceof Power) {
			return _ADD(lhs, new Power(rhs));
		} else if (lhs instanceof Time) {
			return _ADD(lhs, new Time(rhs));
		}
		return null;
	}

	public static PhysicsScalarType _ADD(double lhs, PhysicsScalarType rhs) {
		return _ADD(rhs, lhs);
	}

	public static PhysicsScalarType _ADD(double lhs, String units, PhysicsScalarType rhs) {
		if (rhs instanceof Mass) {
			return _ADD(new Mass(lhs, units), rhs);
		} else if (rhs instanceof Power) {
			return _ADD(new Power(lhs, units), rhs);
		} else if (rhs instanceof Time) {
			return _ADD(new Time(lhs, units), rhs);
		}
		return null;
	}

	public static PhysicsScalarType _ADD(PhysicsScalarType lhs, double rhs, String units) {
		return _ADD(rhs, units, lhs);
	}
	
	//// vector types

	public static PhysicsVectorType _ADD(PhysicsVectorType lhs, PhysicsVectorType rhs) {
		if (lhs instanceof Acceleration) {
			return new Acceleration(lhs.x + rhs.x, lhs.y + rhs.y);
		} else if (lhs instanceof Displacement) {
			return new Displacement(lhs.x + rhs.x, lhs.y + rhs.y);
		} else if (lhs instanceof Force) {
			return new Force(lhs.x + rhs.x, lhs.y + rhs.y);
		} else if (lhs instanceof Velocity) {
			return new Velocity(lhs.x + rhs.x, lhs.y + rhs.y);
		}
		return null;
	}
	
}