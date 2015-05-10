public class Tester extends CalphyMethods {
	public static void main(String[] args) {
		Force f = new Force(10,0);
		Acceleration a = new Acceleration(10,0);
		Mass m = getMass(f,a);
		Mass m1 = new Mass(10);
		Mass m2 =(Mass)_ADD(m,m1);
		System.out.println(m.value);
		System.out.println(m1.value);
		System.out.println(m2.value);
	}

}
