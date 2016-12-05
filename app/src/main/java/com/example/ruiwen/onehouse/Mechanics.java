package com.example.ruiwen.onehouse;



public class Mechanics {

	public String moment() {return "moment is equals to force times distance";}
	public double getMoments(double force, double distance){
		return force*distance;
	}
	
	public double getForce(double moments, double distance){
		return moments/distance;
	}
	
	public double getDistance(double moments, double force){
		return moments/force;
	}

	public String velocity(){return "velocity is equals to changed distance divided by changed time";}
	public double getVeloctiy(double changeDistance, double changeTime){
		return changeDistance/ changeTime;
	}
	
	public double getChangeDistance(double velocity, double changeTime){
		return velocity * changeTime;
	}
	
	public double getChangeTime(double velocity, double changeDistance){
		return changeDistance/velocity;
	}

	public String velocity2(){return "velocity is equals to initial velocity plus acceleration times time";}
	public double getVelocity(double acceleration, double time, double initialVelocity){
		return initialVelocity + (acceleration * time);
	}
	
	public double getAcceleration(double velocity, double time, double initialVelocity){
		return (velocity - initialVelocity)/time;
	}
	
	public double getTime(double velocity, double acceleration, double initialVelocity){
		return (velocity-initialVelocity)/acceleration;
	}
	
	public double getInitialVelocity(double velocity, double time, double acceleration){
		return velocity - acceleration*time;
	}

	public String velocity3(){return "velocity's square is equals to initial velocity's square plus two times acceleration times time";}
	//velocity square = initial velocity square + 2 * acceleration * distance
	//v*v = u*u + 2as
	public double getVelocitySquareRoot(double initialVelocitySquareRoot, double acceleration, double distance){
		return  Math.sqrt(initialVelocitySquareRoot *initialVelocitySquareRoot  + acceleration * distance * 2);
	}

	public double getInitialVelocitySquareRoot(double velocitySquareRoot, double acceleration, double distance){
		return Math.sqrt(velocitySquareRoot * velocitySquareRoot - 2*acceleration*distance);
	}

	public double getDistance3(double velocitySquareRoot, double initialVelocitySquareRoot, double acceleration){
		return (velocitySquareRoot * velocitySquareRoot - velocitySquareRoot * velocitySquareRoot)/2 /acceleration;
	}

	public double getAcceleration3(double velocitySquareRoot, double initialVelocitySquareRoot, double distance){
		return (velocitySquareRoot * velocitySquareRoot - velocitySquareRoot * velocitySquareRoot)/distance/2;
	}

	public String velocity4(){return "acceleration is equals to changed velocity divided by changed time";}
	public double getAcceleration(double changeVelocity, double changeTime){
		return changeVelocity/changeTime;
	}

	public double getChangeVelocity(double acceleration, double changeTime){
		return acceleration * changeTime;
	}
	
	public double getChangeTime2(double acceleration, double changeVelocity){
		return changeVelocity /acceleration;
	}


	public String distance(){return "distance is equals to the sum of initial velocity plus velocity times time divided by two";}
	public double getDistance(double initialVelocity, double velocity, double time){
		return (initialVelocity + velocity) * time /2;
	}
	
	public double getInitalVelocity(double distance, double velocity, double time){
		return distance * 2/time - velocity;
	}
	
	public double getVelocity2(double distance, double initialVelocity, double time){
		return distance*2/time - initialVelocity;
	}
	
	public double getTime2(double distance, double initialVelocity, double velocity){
		return distance * 2/(initialVelocity + velocity);
	}

	public String distance2(){return "distance is equals to initial velocity plus acceleration times time's square divided by two";}
	public double getDistance1(double initialVelocity, double time, double acceleration){
		return initialVelocity + acceleration * time * time/2;
	}
	
	public double getInitialVelocity2(double distance, double time, double acceleration){
		return distance - acceleration * time * time /2;
	}
	
	public double getTime3(double distance, double initialVelocity, double acceleration){
		return Math.sqrt((distance-initialVelocity) * 2/acceleration);
	}
	
	public double getAcceleration2(double distance, double initialVelocity, double time){
		return (distance-initialVelocity) *2/time/time;
	}


	public String force(){return "force is equals to mass plus acceleration";}
	public double getForce2(double mass, double acceleration){
		return mass*acceleration;
	}
	
	public double getMass(double force, double acceleration){
		return force/acceleration;
	}
	
	public double getAcceleration3(double force, double mass){
		return force/mass;
	}

	public String work(){return "work is equals to force times distance times cos theta";}
	public double getWork(double force, double distance, double theta){
		return force * distance*Math.cos(theta);
	}
	
	public double getForce(double work, double distance, double theta){
		return work/distance/Math.cos(theta);
	}
	
	public double getDistance2(double work, double force, double theta){
		return work/force/Math.cos(theta);
	}
	
	public double getTheta(double work, double force, double distance){
		return Math.acos(work / force/distance);
	}

	public String energy(){return "energy of Kinetic is equals to mass times velocity's square divided by two";}
	public double getEnergyOfKinetic(double mass, double velocity){
		return mass * velocity * velocity /2;
	}
	
	public double getMass2(double energyOfKinetic, double velocity){
		return energyOfKinetic *2/velocity/velocity;
	}
	
	public double getVelocity(double energyOfKinetic, double mass){
		return Math.sqrt(energyOfKinetic * 2/mass);
	}

	public String energy2(){return "energy of Potential is equals to mass times hieght changed times gravitation";}
	public double getEnergyOfPotential(double mass, double changeHeight, double gravitation){
		return mass*gravitation * changeHeight;
	}
	
	public double getMass(double energyOfPotential, double changeHeight, double gravitation){
		return energyOfPotential / gravitation/changeHeight;
	}
	
	public double getChangeHeight(double energyOfPotential, double mass, double gravitaion){
		return energyOfPotential / mass/gravitaion;
	}
	
	public double getGravitaion(double energyOfPotential, double mass, double changeHeight){
		return energyOfPotential/mass/changeHeight;
	}

	public String power(){return "power is equals to force times velocity";}
	public double getPower(double force, double velocity){
		return force*velocity;
	}
	
	public double getForce3(double power, double velocity){
		return power/velocity;
	}
	
	public double getVelocity3(double power, double force){
		return power/force;
	}

	public String power2(){return "poweris equals to changed work divided by changed time";}
	public double getPower1(double changeWork, double changeTime){
		return changeWork/changeTime;
	}
	
	public double getChangeWork(double power, double changeTime){
		return power/changeTime;
	}
	
	public double getChangeTime3(double power, double changeWork){
		return power/changeWork;
	}

	public String efficient(){return "efficient is equals to useful output power divided by input power";}
	public double getEfficient(double usefulOutputPower, double inputPower){
		return usefulOutputPower/inputPower;
	}
	
	public double getusefulOutputPower(double efficient, double inputPower){
		return efficient * inputPower;
	}
	
	public double getInputPower(double efficient, double usefulOutputPower){
		return usefulOutputPower/efficient;
	}

}
