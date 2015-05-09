

public class PhysicsMethods {
	
	public Displacement getDisp(Acceleration a, Time t, Velocity v){
		double time = t.value;
		double accel = a.x;
		double vel = v.x;
		double distancex = vel * time + (.5 * accel * (time*time));
		
		accel = a.y;
		vel = a.y;
		double distancey = vel * time + (.5 * accel * (time*time));
		
		
		Displacement answer = new Displacement(distancex, distancey);
		return answer;
	}
	
	public Displacement getDisp(Velocity vi, Velocity vf, Acceleration a){
		double veli = vi.x;
		double velf = vf.x;
		double accel = a.x;
		double distancex = (velf * velf + veli * veli) / (2 * accel);
		
		veli = vi.y;
		velf = vi.y;
		accel = a.y;
		double distancey = (velf * velf + veli * veli) / (2 * accel);
		Displacement answer = new Displacement(distancex, distancey);
		return answer;
		
	}
	
	public Displacement getDisp(Time t, Velocity vi, Velocity vf){
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
	
	public Acceleration getAccel(Displacement d, Velocity v, Time t){
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

	public Acceleration getAccel(Velocity vi, Velocity vf, Displacement d){
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
	
	public Acceleration getAccel(Velocity vi, Velocity vf, Time t){
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
	
	public Time getTime(Velocity vi, Velocity vf, Acceleration a){
		double veli = Math.sqrt((vi.x * vi.x) + (vi.y * vi.y));
		double velf = Math.sqrt((vf.x * vf.x) + (vf.y * vf.y));
		double accel = Math.sqrt((a.x * a.x) + (a.y * a.y));
		double time = (velf - veli) / accel;
		Time answer = new Time(time);
		return answer;
	}
	
	public Time getTime(Displacement d, Velocity vi, Velocity vf){
		double disp = Math.sqrt((d.x * d.x) + (d.y * d.y));
		double veli = Math.sqrt((vi.x * vi.x) + (vi.y * vi.y));
		double velf = Math.sqrt((vf.x * vf.x) + (vf.y * vf.y));
		double time = (2 * disp) / (veli + velf);
		Time answer = new Time(time);
		return answer;
	}
	
	public Velocity getinitVel(Displacement d, Acceleration a, Time t){
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
	
	public Velocity getinitVel(Velocity v, Acceleration a, Displacement d){
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
	
	public Velocity getinitVel(Velocity v, Acceleration a, Time t){
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
	
	public Velocity getinitVel(Velocity v, Displacement d, Time t){
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
	
	public Velocity getfinalVel(Velocity v, Acceleration a, Displacement d){
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
	
	public Velocity getfinalVel(Velocity v, Acceleration a, Time t){
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
	
	public Velocity getfinalVel(Velocity v, Displacement d, Time t){
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
	
	public Force getForce(Mass m, Acceleration a){
		double mass = m.value;
		double accel = a.x;
		double forcex = mass * accel;
		accel = a.y;
		double forcey = mass * accel;
		Force answer = new Force(forcex, forcey);
		return answer;
		
	}
	
	public Velocity getVel(Displacement d, Time t){
		double disp = d.x;
		double time = t.value;
		double vx = disp / time;
		
		disp = d.y;
		double vy = disp / time;
		Velocity answer = new Velocity(vx, vy);
		return answer;
	}

	public Acceleration getAccel(Velocity v, Time t){
		double vel = v.x;
		double time = t.value;
		double accelx = vel / time;
		vel = v.y;
		double accely = vel / time;
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
		
	}
	
	public Acceleration getAccel(Force f, Mass m){
		double force = f.x;
		double mass = m.value;
		double accelx = force / mass;
		force = f.y;
		double accely = force / mass;
		Acceleration answer = new Acceleration(accelx, accely);
		return answer;
		
	}
	
	public Mass getMass(Force f, Acceleration a){
		double force = Math.sqrt((f.x * f.x) + (f.y * f.y));
		double accel = Math.sqrt((a.x * a.x) + (a.y * a.y));
		double mass = force / accel;
		Mass answer = new Mass(mass);
		return answer;
		
	}
	
}
