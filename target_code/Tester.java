public class Tester extends CalphyMethods {
	static int scount, vcount;
	
	public static void main(String[] args) {
		Force f = new Force(10,0);
		Acceleration a = new Acceleration(10,0);
		Mass m = getMass(f,a);
		Mass m1 = new Mass(10);
		Mass m2 =(Mass)_ADD(m,m1);
		Mass m3 =(Mass)_ADD(m,m1.value);
		Mass m4 =(Mass)_ADD(m.value,m1);
		System.out.println("+++++ Mass +++++");
		printScalar(m);
		printScalar(m1);
		printScalar(m2);
		printScalar(m3);
		printScalar(m4);
		printScalar((_ADD(m,100, "_g")));
		printScalar((_ADD(100, "_g", m)));


		System.out.println("+++++ Velocity +++++");
		Velocity v1 = new Velocity(0, 5);
		Velocity v2 = new Velocity(5, 10);
		printVector(v1);
		printVector(v2);
		printVector(_ADD(v1,v2));
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


