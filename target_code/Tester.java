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
		// printScalar((_ADD(m1,100, "_g")));
		// printScalar((_ADD(100, "_g", m1)));
		// (_SUB(m2,m1)).display();
		// (_SUB(m1,m2)).display();
		// System.out.println("WTF");
		// m2.display();
		// (_SUB(5,"_kg",m2)).display();
		// System.out.println("WTF");
		// m2.display();
		// (_SUB(m2,5.0,"_kg")).display();
		// m2.value = -5;

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


