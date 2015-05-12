public class CalphyMethods extends PhysicsMethods {

	//// ScalarTypes
	//
	
	public static PhysicsScalarType _DIV(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		if (rhs.value == 0) {
			return null;
		} 
		
		if (lhs instanceof Mass) {
			return new Mass(lhs.value / rhs.value);
		} else if (lhs instanceof Power) {
			return new Power(lhs.value / rhs.value);
		} else if (lhs instanceof Energy) {
			return new Energy(lhs.value / rhs.value);
		} else if (lhs instanceof Time) {
			return new Time(lhs.value / rhs.value);
		}
		return null;
	}
	
	public static PhysicsScalarType _DIV(PhysicsScalarType lhs, double rhs) {
		if (lhs instanceof Mass) {
			return _DIV(lhs, new Mass(rhs));
		} else if (lhs instanceof Power) {
			return _DIV(lhs, new Power(rhs));
		} else if (lhs instanceof Energy) {
			return _DIV(lhs, new Energy(rhs));
		} else if (lhs instanceof Time) {
			return _DIV(lhs, new Time(rhs));
		}
		return null;
	}

	public static PhysicsScalarType _DIV(PhysicsScalarType lhs, double rhs, String units) {
		if (lhs instanceof Mass) {
			return _DIV(lhs, new Mass(rhs, units));
		} else if (lhs instanceof Power) {
			return _DIV(lhs, new Power(rhs, units));
		} else if (lhs instanceof Energy) {
			return _DIV(lhs, new Energy(rhs, units));
		} else if (lhs instanceof Time) {
			return _DIV(lhs, new Time(rhs, units));
		}
		return null;
	}

	public static PhysicsScalarType _DIV(double lhs, String units, PhysicsScalarType rhs) {
		if (rhs instanceof Mass) {
			return _DIV(new Mass(lhs, units), rhs);
		} else if (rhs instanceof Power) {
			return _DIV(new Power(lhs, units), rhs);
		} else if (rhs instanceof Energy) {
			return _DIV(new Energy(lhs, units), rhs);
		} else if (rhs instanceof Time) {
			return _DIV(new Time(lhs, units), rhs);
		}
		return null;
	}

	public static PhysicsScalarType _DIV(double lhs, PhysicsScalarType rhs) {
		if (rhs instanceof Mass) {
			return _DIV(new Mass(lhs), rhs);
		} else if (rhs instanceof Power) {
			return _DIV(new Power(lhs), rhs);
		} else if (rhs instanceof Energy) {
			return _DIV(new Energy(lhs), rhs);
		} else if (rhs instanceof Time) {
			return _DIV(new Time(lhs), rhs);
		}
		return null;
	}
	
	public static PhysicsScalarType _MULT(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		if (lhs instanceof Mass) {
			return new Mass(lhs.value * rhs.value);
		} else if (lhs instanceof Power) {
			return new Power(lhs.value * rhs.value);
		} else if (lhs instanceof Energy) {
			return new Energy(lhs.value * rhs.value);
		} else if (lhs instanceof Time) {
			return new Time(lhs.value * rhs.value);
		}
		return null;
	}
	
	public static PhysicsScalarType _MULT(PhysicsScalarType lhs, double rhs) {
		if (lhs instanceof Mass) {
			return _MULT(lhs, new Mass(rhs));
		} else if (lhs instanceof Power) {
			return _MULT(lhs, new Power(rhs));
		} else if (lhs instanceof Energy) {
			return _MULT(lhs, new Energy(rhs));
		} else if (lhs instanceof Time) {
			return _MULT(lhs, new Time(rhs));
		}
		return null;
	}

	public static PhysicsScalarType _MULT(double lhs, PhysicsScalarType rhs) {
		return _MULT(rhs, lhs);
	}
	
	public static PhysicsScalarType _MULT(PhysicsScalarType lhs, double rhs, String units) {
		if (lhs instanceof Mass) {
			return _MULT(lhs, new Mass(rhs, units));
		} else if (lhs instanceof Power) {
			return _MULT(lhs, new Power(rhs, units));
		} else if (lhs instanceof Energy) {
			return _MULT(lhs, new Energy(rhs, units));
		} else if (lhs instanceof Time) {
			return _MULT(lhs, new Time(rhs, units));
		}
		return null;
	}

	public static PhysicsScalarType _MULT(double lhs, String units, PhysicsScalarType rhs) {
		return(_MULT(rhs, lhs, units));
	}
	
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
		} else if (rhs instanceof Energy) {
			return _SUB(new Energy(lhs, units), rhs);
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
		} else if (lhs instanceof Energy) {
			return _SUB(lhs, new Energy(rhs, units));
		} else if (lhs instanceof Time) {
			return _SUB(lhs, new Time(rhs, units));
		}
		return null;
	}
	
	// with two objects
	public static PhysicsScalarType _ADD(PhysicsScalarType lhs, PhysicsScalarType rhs) {
		if (lhs instanceof Mass) {
			return new Mass(lhs.value + rhs.value);
		} else if (lhs instanceof Power) {
			return new Power(lhs.value + rhs.value);
		} else if (lhs instanceof Energy) {
			return new Energy(lhs.value + rhs.value);
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
		} else if (lhs instanceof Energy) {
			return _ADD(lhs, new Energy(rhs));
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
			return _ADD(new Energy(lhs, units), rhs);
		} else if (rhs instanceof Power) {
			return _ADD(new Energy(lhs, units), rhs);
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
	
	public static PhysicsVectorType _SUB(PhysicsVectorType lhs, PhysicsVectorType rhs) {
		if (lhs instanceof Acceleration) {
			return new Acceleration(lhs.x - rhs.x, lhs.y - rhs.y);
		} else if (lhs instanceof Displacement) {
			return new Displacement(lhs.x - rhs.x, lhs.y - rhs.y);
		} else if (lhs instanceof Force) {
			return new Force(lhs.x - rhs.x, lhs.y - rhs.y);
		} else if (lhs instanceof Velocity) {
			return new Velocity(lhs.x - rhs.x, lhs.y - rhs.y);
		}
		return null;
	}

	public static PhysicsVectorType _MULT(PhysicsVectorType lhs, double rhs) {
		if (lhs instanceof Acceleration) {
			return new Acceleration(lhs.x * rhs, lhs.y * rhs);
		} else if (lhs instanceof Displacement) {
			return new Displacement(lhs.x * rhs, lhs.y * rhs);
		} else if (lhs instanceof Force) {
			return new Force(lhs.x * rhs, lhs.y * rhs);
		} else if (lhs instanceof Velocity) {
			return new Velocity(lhs.x * rhs, lhs.y * rhs);
		}
		return null;
		
	}
	
	public static PhysicsVectorType _MULT(double lhs, PhysicsVectorType rhs) {
		return _MULT(rhs, lhs);
	}

	public static PhysicsVectorType _DIV(PhysicsVectorType lhs, double rhs) {
		if (rhs == 0) 
			return null;
		if (lhs instanceof Acceleration) {
			return new Acceleration(lhs.x / rhs, lhs.y / rhs);
		} else if (lhs instanceof Displacement) {
			return new Displacement(lhs.x / rhs, lhs.y / rhs);
		} else if (lhs instanceof Force) {
			return new Force(lhs.x / rhs, lhs.y / rhs);
		} else if (lhs instanceof Velocity) {
			return new Velocity(lhs.x / rhs, lhs.y / rhs);
		}
		return null;
		
	}

       public static double norm(PhysicsVectorType a){
	       return Math.sqrt(a.x^2 + a.y^2);

       }	
}
