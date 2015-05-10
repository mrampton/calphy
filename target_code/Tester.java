public class Tester extends CalphyMethods {
	static int scount = 1, vcount = 1;
	
	public static void main(String[] args) {
		Force f = new Force(10,0);
		Acceleration a = new Acceleration(10,0);
		Mass m1 = getMass(f,a);
		Mass m2 = new Mass(10);
		Mass m3 =(Mass)_ADD(m1,m2);
		Mass m4 =(Mass)_ADD(m1,m2.value);
		Mass m5 =(Mass)_ADD(m1.value,m2);
		Mass m6 = (Mass)_SUB(0,"_kg",m2);
		Mass m7 = (Mass)_SUB(m2, 15, "_kg");
		System.out.println("+++++ Mass +++++");
		printScalar(m1);
		printScalar(m2);
		printScalar(m3);
		printScalar(m4);
		printScalar(m5);
		printScalar(m6);
		printScalar(m7);
		System.out.println("+++++ Scalar Mult +++++");
		Mass m8 = (Mass)_MULT(m2, m3);
		printScalar(m8);

		System.out.println("+++++ Vector +++++");
		Velocity v1 = new Velocity(0, 5);
		Velocity v2 = new Velocity(5, 10);
		printVector(v1);
		printVector(v2);
		printVector(_ADD(v1,v2));
		Velocity v3 = (Velocity)_SUB(v2, v1);
	}
	
	public static void printScalar(PhysicsScalarType s) {
		System.out.println("s" + scount + ": " + s.value);
		scount++;
	}

	public static void printVector(PhysicsVectorType v) {
		System.out.println("v" + vcount + ": " + v.x + " " + v.y);
		vcount++;
	}
}


