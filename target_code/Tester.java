public class Tester extends CalphyMethods {
	static int scount = 1, vcount = 1;
	
	public static void main(String[] args) {
		System.out.println("+++++ Force +++++");
		Force f1 = new Force(10,1);
		Force f2 = new Force(0.01, 0.1, "_kN");
		Force f3 = (Force)_ADD(f1, f2);
		Force f4 = (Force)_SUB(f3, f2);
		Force f5 = (Force)_MULT(f3, 5);
		Force f6 = (Force)_MULT(5, f3);
		Force f7 = (Force)_DIV(f6, 5);
		printVector(f1);
		printVector(f2);
		printVector(f3);
		printVector(f4);
		printVector(f5);
		printVector(f6);
		printVector(f7);
		reset();

		System.out.println("\n+++++ Velocity +++++");
		Velocity v1 = new Velocity(10,1);
		Velocity v2 = new Velocity(0.01, 0.1, "_km/s");
		Velocity v3 = (Velocity)_ADD(v1, v2);
		Velocity v4 = (Velocity)_SUB(v3, v2);
		Velocity v5 = (Velocity)_MULT(v3, 5);
		Velocity v6 = (Velocity)_MULT(5, v3);
		Velocity v7 = (Velocity)_DIV(v6, 5);
		printVector(v1);
		printVector(v2);
		printVector(v3);
		printVector(v4);
		printVector(v5);
		printVector(v6);
		printVector(v7);
		reset();

		System.out.println("\n+++++ Displacement +++++");
		Displacement d1 = new Displacement(10,1);
		Displacement d2 = new Displacement(0.01, 0.1, "_km");
		Displacement d3 = (Displacement)_ADD(d1, d2);
		Displacement d4 = (Displacement)_SUB(d3, d2);
		Displacement d5 = (Displacement)_MULT(d3, 5);
		Displacement d6 = (Displacement)_MULT(5, d3);
		Displacement d7 = (Displacement)_DIV(d6, 5);
		printVector(d1);
		printVector(d2);
		printVector(d3);
		printVector(d4);
		printVector(d5);
		printVector(d6);
		printVector(d7);
		reset();

		System.out.println("\n+++++ Acceleration +++++");
		Acceleration a1 = new Acceleration(10,1);
		Acceleration a2 = new Acceleration(0.01, 0.1, "_km/s^2");
		Acceleration a3 = (Acceleration)_ADD(a1, a2);
		Acceleration a4 = (Acceleration)_SUB(a3, a2);
		Acceleration a5 = (Acceleration)_MULT(a3, 5);
		Acceleration a6 = (Acceleration)_MULT(5, a3);
		Acceleration a7 = (Acceleration)_DIV(a6, 5);
		printVector(a1);
		printVector(a2);
		printVector(a3);
		printVector(a4);
		printVector(a5);
		printVector(a6);
		printVector(a7);
		reset();


		System.out.println("\n============== Scalar Types ==============");
			
		System.out.println("\n+++++ Energy +++++");
		Energy e1 = new Energy(10);
		Energy e2 = new Energy(0.01, "_KJ");
		Energy e3 = (Energy)_ADD(e1, e2);
		Energy e4 = (Energy)_SUB(e3, e2);
		Energy e5 = (Energy)_MULT(e3, 5);
		Energy e6 = (Energy)_MULT(5, e3);
		Energy e7 = (Energy)_DIV(e6, 5);
		printScalar(e1);
		printScalar(e2);
		printScalar(e3);
		printScalar(e4);
		printScalar(e5);
		printScalar(e6);
		printScalar(e7);
		reset();
			
		System.out.println("\n+++++ Mass +++++");
		Mass m1 = new Mass(10);
		Mass m2 = new Mass(100, "_g");
		Mass m3 = (Mass)_ADD(m1, m2);
		Mass m4 = (Mass)_SUB(m3, m2);
		Mass m5 = (Mass)_MULT(m3, 5);
		Mass m6 = (Mass)_MULT(5, m3);
		Mass m7 = (Mass)_DIV(m6, 5);
		printScalar(m1);
		printScalar(m2);
		printScalar(m3);
		printScalar(m4);
		printScalar(m5);
		printScalar(m6);
		printScalar(m7);
		reset();

		System.out.println("\n+++++ Power +++++");
		Power p1 = new Power(10);
		Power p2 = new Power(100, "_mW");
		Power p3 = (Power)_ADD(p1, p2);
		Power p4 = (Power)_SUB(p3, p2);
		Power p5 = (Power)_MULT(p3, 5);
		Power p6 = (Power)_MULT(5, p3);
		Power p7 = (Power)_DIV(p6, 5);
		printScalar(p1);
		printScalar(p2);
		printScalar(p3);
		printScalar(p4);
		printScalar(p5);
		printScalar(p6);
		printScalar(p7);
		reset();

		System.out.println("\n+++++ Time +++++");
		Time t1 = new Time(10);
		Time t2 = new Time(100, "_ms");
		Time t3 = (Time)_ADD(t1, t2);
		Time t4 = (Time)_SUB(t3, t2);
		Time t5 = (Time)_MULT(t3, 5);
		Time t6 = (Time)_MULT(5, t3);
		Time t7 = (Time)_DIV(t6, 5);
		printScalar(t1);
		printScalar(t2);
		printScalar(t3);
		printScalar(t4);
		printScalar(t5);
		printScalar(t6);
		printScalar(t7);
		reset();
	}
	
	public static void printScalar(PhysicsScalarType s) {
		System.out.println("s" + scount + ": " + s);
		scount++;
	}

	public static void printVector(PhysicsVectorType v) {
		System.out.println("v" + vcount + ": " + v);
		vcount++;
	}

	public static void reset() {
		vcount = 1;
		scount = 1;
	}
}


