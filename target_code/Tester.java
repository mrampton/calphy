public class Tester extends PhysicsMethods {
	public static void main(String[] args) {
		Force f = new Force(10,0);
		Acceleration a = new Acceleration(10,0);
		Mass m = getMass(f,a);
		System.out.println(m.value);
	}

}
