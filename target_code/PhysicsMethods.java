public class PhysicsMethods {
	
	public static Displacement getDisp(Acceleration a, Time t, Velocity v){
		double time = t.value;
		double accel = a.x;
		double vel = v.x;
		double distancex = vel * time + (.5 * accel * (time*time));
		
		accel = a.y;
		vel = v.y;
		double distancey = vel * time + (.5 * accel * (time*time));
		
		
		Displacement answer = new Displacement(distancex, distancey);
		return answer;
	}
	
	public static Displacement getDisp(Velocity vi, Velocity vf, Acceleration a){
		double veli = vi.x;
		double velf = vf.x;
		double accel = a.x;
		double distancex;
		if (accel != 0.0) {
		  distancex = (velf * velf - veli * veli) / (2 * accel);
		} else {
	      distancex = 0.0;
		}
		veli = vi.y;
		velf = vf.y;
		accel = a.y;
		double distancey;
		if (accel != 0.0) {
		  distancey = (velf * velf - veli * veli) / (2 * accel);
		  //System.out.println(velf + " " + veli + " " + accel + distancey);
		} else {
		  distancey = 0.0;
		}
		Displacement answer = new Displacement(distancex, distancey);
		return answer;
		
	}
	
	public static Displacement getDisp(Time t, Velocity vi, Velocity vf){
		double veli = vi.x;
		double velf = vf.x;
		double time = t.value;
		double distancex = time * (veli + velf) / 2;
		
		veli = vi.y;
		velf= vf.y;
		double distancey =  time * (veli + velf) / 2;
		Displacement answer = new Displacement(distancex, distancey);
		return answer;
	}
	
	public static Acceleration getAccel(Displacement d, Velocity v, Time t){
		double disp = d.x;
		double vel = v.x;
		double time = t.value;
		double accelx = (disp - vel * time)/(2 * time * time);
		
		vel = v.y;
		disp = d.y;
		double accely = (disp - vel * time)/(2 * time * time);
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
	}

	public static Acceleration getAccel(Velocity vi, Velocity vf, Displacement d){
		double disp = d.x;
		double veli = vi.x;
		double velf = vf.x;
		double accelx = (veli * veli + velf * velf) / (2*disp);
		
		disp = d.y;
		veli = vi.y;
		velf = vf.y;
		double accely = (veli * veli + velf * velf) / (2*disp);
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
	}
	
	public static Acceleration getAccel(Velocity vi, Velocity vf, Time t){
		double time = t.value;
		double veli = vi.x;
		double velf = vf.x;
		double accelx = (velf - veli) / time;
		
		veli = vi.y;
		velf = vf.y;
		double accely = (velf - veli) / time;
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
	}
	
	public static Time getTime(Velocity vi, Velocity vf, Acceleration a){
		double veli = Math.sqrt((vi.x * vi.x) + (vi.y * vi.y));
		double velf = Math.sqrt((vf.x * vf.x) + (vf.y * vf.y));
		double accel = Math.sqrt((a.x * a.x) + (a.y * a.y));
		double time = (velf - veli) / accel;
		Time answer = new Time(time);
		return answer;
	}
	
	public static Time getTime(Displacement d, Velocity vi, Velocity vf){
		double disp = Math.sqrt((d.x * d.x) + (d.y * d.y));
		double veli = Math.sqrt((vi.x * vi.x) + (vi.y * vi.y));
		double velf = Math.sqrt((vf.x * vf.x) + (vf.y * vf.y));
		double time = (2 * disp) / (veli + velf);
		Time answer = new Time(time);
		return answer;
	}
	
	public static Velocity getinitVel(Displacement d, Acceleration a, Time t){
		double disp = d.x;
		double accel = a.x;
		double time = t.value;
		double vx = (disp - .5 * accel * time * time) / time;
		
		disp = d.y;
		accel = a.y;
		double vy = (disp - .5 * accel * time * time) / time;
		Velocity answer = new Velocity(vx, vy);
		return answer;
		
	}
	
	public static Velocity getinitVel(Velocity v, Acceleration a, Displacement d){
		double accel = a.x;
		double vel = v.x;
		double disp = d.x;
		double vx = Math.sqrt(vel - 2 * accel * disp);
		
		accel = a.y;
		vel = v.y;
		disp = d.y;
		double vy = Math.sqrt(vel - 2 * accel * disp);
		Velocity answer = new Velocity(vx, vy);
		return answer;
		
	}
	
	public static Velocity getinitVel(Velocity v, Acceleration a, Time t){
		double vel = v.x;
		double accel = a.x;
		double time = t.value;
		double vx = vel - accel * time;
		
		vel = v.y;
		accel = a.y;
		double vy = vel - accel * time;
		Velocity answer = new Velocity(vx, vy);
		return answer;
	}
	
	public static Velocity getinitVel(Velocity v, Displacement d, Time t){
		double vel = v.x;
		double disp = d.x;
		double time = t.value;
		double vx = 2 * disp / time - vel;
		
		vel = v.y;
		disp = d.y;
		double vy = 2 * disp / time - vel;
		Velocity answer = new Velocity(vx, vy);
		return answer;
		
	}
	
	public static Velocity getfinalVel(Velocity v, Acceleration a, Displacement d){
		double vel = v.x;
		double accel = a.x;
		double disp = d.x;
		double vx = Math.sqrt(vel * vel + 2 * accel * disp);
		
		vel = v.y;
		accel = a.y;
		disp = d.y;
		double vy = Math.sqrt(vel * vel + 2 * accel * disp);
		Velocity answer = new Velocity(vx, vy);
		return answer;
		
	}
	
	public static Velocity getfinalVel(Velocity v, Acceleration a, Time t){
		double vel = v.x;
		double accel = a.x;
		double time = t.value;
		double vx = vel + accel * time;
		
		vel = v.y;
		accel = a.y;
		double vy = vel + accel * time;
		Velocity answer = new Velocity(vx, vy);
		return answer;
	}
	
	public static Velocity getfinalVel(Velocity v, Displacement d, Time t){
		double vel = v.x;
		double disp = d.x;
		double time = t.value;
		double vx = 2 * disp / time - vel;
		
		vel = v.y;
		disp = d.y;
		double vy = 2 * disp / time - vel;
		Velocity answer = new Velocity(vx, vy);
		return answer;
		
	}
	
	public static Force getForce(Mass m, Acceleration a){
		double mass = m.value;
		double accel = a.x;
		double forcex = mass * accel;
		accel = a.y;
		double forcey = mass * accel;
		Force answer = new Force(forcex, forcey);
		return answer;
		
	}
	
	public static Velocity getVel(Displacement d, Time t){
		double disp = d.x;
		double time = t.value;
		double vx = disp / time;
		
		disp = d.y;
		double vy = disp / time;
		Velocity answer = new Velocity(vx, vy);
		return answer;
	}

	public static Acceleration getAccel(Velocity v, Time t){
		double vel = v.x;
		double time = t.value;
		double accelx = vel / time;
		vel = v.y;
		double accely = vel / time;
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
		
	}
	
	public static Acceleration getAccel(Force f, Mass m){
		double force = f.x;
		double mass = m.value;
		double accelx = force / mass;
		force = f.y;
		double accely = force / mass;
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
		
	}
	
	public static Mass getMass(Force f, Acceleration a){
		double force = Math.sqrt((f.x * f.x) + (f.y * f.y));
		double accel = Math.sqrt((a.x * a.x) + (a.y * a.y));
		double mass = force / accel;
		Mass answer = new Mass(mass);
		return answer;
		
	}
	public static Displacement getDisp(Velocity v, Time t){
		double vel = v.x;
		double time = t.value;
		double dispx = vel * time;
		vel = v.y;
		double dispy = vel * time;
		Displacement answer = new Displacement(dispx, dispy);
		return answer;
	}

	public static double degreesToRadians(double degrees) {
		return degrees*(Math.PI/180);
	}

	public static double radiansToDegrees(double radians) {
		return radians*(180/Math.PI);
	}	

	public static double sin(double degrees) {
		return Math.sin(degrees);
	}
	
	public static double cos(double degrees) {
		return Math.cos(degrees);
	}

	public static double tan(double degrees) {
		return Math.tan(degrees);
	}

	public static double arcsin(double value) {
		return Math.asin(value);
	}
	
	public static double arccos(double value) {
		return Math.acos(value);
	}

	public static double arctan(double value) {
		return Math.atan(value);
	}

	public static void toComponent(Velocity v, double degrees, double magnitude) {
		v.x = magnitude*Math.cos(degrees);
		v.y = magnitude*Math.sin(degrees);
		v.units = "m/s";
	}
	
	public static void toComponent(Acceleration v, double degrees, double magnitude) {
		v.x = magnitude*Math.cos(degrees);
		v.y = magnitude*Math.sin(degrees);
		v.units = "m/s^2";
	}

	public static void toComponent(Force v, double degrees, double magnitude) {
		v.x = magnitude*Math.cos(degrees);
		v.y = magnitude*Math.sin(degrees);
		v.units = "N";
	}

	public static void toComponent(Displacement v, double degrees, double magnitude) {
		v.x = magnitude*Math.cos(degrees);
		v.y = magnitude*Math.sin(degrees);
		v.units = "m";
	}
	
	public static Energy calcElastic(double k, Displacement d){
		double disp = Math.sqrt((d.x * d.x) + (d.y * d.y));
		return new Energy(0.5 * k * disp * disp);
	}
	public static Velocity getVel(Energy e, Mass m){
		double answer =  Math.sqrt(2*e.value/m.value);
		Velocity v = new Velocity(answer,0);
		return v;
	}

	public static void printAccel(Acceleration a, String u) {
		if (u.equals("km/s^2"))
			System.out.println("<"+a.x/1000+","+a.y/1000+"> "+u);
	}

	public static void printMass(Mass a, String u) {
		if (u.equals("g"))
			System.out.println(a.value*1000+" "+u);
		if (u.equals("mg"))
			System.out.println(a.value*1000000+" "+u);
	}

	public static void printEnergy(Energy a, String u) {
		if (u.equals("KJ"))
			System.out.println(a.value/1000+" "+u);
		if (u.equals("MJ"))
			System.out.println(a.value/1000000+" "+u);
		if (u.equals("mJ"))
			System.out.println(a.value*1000+" "+u);
	}

	public static void printPower(Power a, String u) {
		if (u.equals("KW"))
			System.out.println(a.value/1000+" "+u);
		if (u.equals("MW"))
			System.out.println(a.value/1000000+" "+u);
		if (u.equals("mW"))
			System.out.println(a.value*1000+" "+u);
	}

	public static void printVel(Velocity a, String u) {
		if (u.equals("km/h"))
			System.out.println("<"+a.x/(1000*3600)+","+a.y/(1000*3600)+"> "+u);
		if (u.equals("km/s"))
			System.out.println("<"+a.x/1000+","+a.y/1000+"> "+u);
		if (u.equals("m/h"))
			System.out.println("<"+a.x/3600+","+a.y/3600+"> "+u);
	}

	public static void printForce(Force a, String u) {
		if (u.equals("kN")
			System.out.println("<"+a.x/1000+","+a.y/1000+"> "+u);
		if (u.equals("MN")
			System.out.println("<"+a.x/1000000+","+a.y/1000000+"> "+u);
		if (u.equals("mN")
			System.out.println("<"+a.x*1000+","+a.y*1000+"> "+u);
	}

	public static void printTime(Time a, String u) {
		if (u.equals("ms")
			System.out.println(a.value*1000+" "+u);
		if (u.equals("us")
			System.out.println(a.value*1000000+" "+u);
		if (u.equals("ns")
			System.out.println(a.value*Math.pow(10,9)+" "+u);
	
	public static void printDisp(Displacement d, String u) {
	  if (u.equals("km")) {
		System.out.println("<" + d.x/1000 + "," + d.y/1000 + "> " + u);
	  } else if (u.equals("mm")) {
		System.out.println("<" + d.x*1000 + "," + d.y*1000 + "> " + u);
	  } else if (u.equals("um")) {
		System.out.println("<" + d.x*1000000 + "," + d.y*1000000 + "> " + u);
	  } else if (u.equals("nm")) {
		System.out.println("<" + d.x*1000000000 + "," + d.y*1000000000 + "> " + u);
	  } else {
		System.out.println("<" + d.x + "," + d.y + "> " + u);
	  }
	}
}
