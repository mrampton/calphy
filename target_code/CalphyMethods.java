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
	
	///// vector types

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