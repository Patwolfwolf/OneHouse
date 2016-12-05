package com.example.ruiwen.onehouse;
import java.util.Scanner;

public class Electricity {
//	double current, resistance, voltage, time, charge, power, work, energy;

	// current = charge changed/ time changed
	// I = Q/tR
	public String Current(){return "The current running through an object = charge of object / time elapsed";}
	public double getCurrent(double changeTime, double changeCharge){
		return changeCharge/changeTime;
	}

	public double getChangeCharge(double current, double changeTime){
		return current * changeTime;
	}

	public double getChangeTime(double current, double changeCharge){
		return changeCharge/current;
	}

	//voltage = work / charge
	// v = W/Q
	public String Voltage(){return "The voltage of an object = work done / charge of object";}
	public double getVoltage(double work, double charge){
		return work/charge;
	}

	public double getWork(double voltage, double charge){
		return voltage * charge;
	}

	public double getCharge(double voltage, double work){
		return work/voltage;
	}

	//resistence = voltage / current
	//V = R/I
	public String Ohm(){return "The resistance of an object = voltage of an object / current running through object";}
	public double getResistence(double voltage, double current){
		return voltage/current;
	}

	public double getvoltage2(double resistence, double current){
		return resistence * current;
	}

	public double getCurrent2(double resistence, double voltage){
		return voltage/resistence;
	}

	//emf = energy /charge
	// e = E / Q
	public String EMF(){return "The electromotive force of an object = energy of object / charge of object";}
	public double getEMF(double energy, double charge){
		return energy/charge;
	}

	public double getEnergy(double EMF, double  charge){
		return EMF * charge;
	}

	public double getCharge2(double EMF, double energy){
		return energy/EMF;
	}

	//emf = current * (resistance + innerResistance)
	//e = I * (R + r)
	public String EMF2(){return "The electromotive force of an object = current running through object * (resistance + inner resistance)";}
	public double getEMF(double current, double resistance, double innerResistance){
		return current *(resistance + innerResistance);
	}

	public double getCurrent3(double EMF, double resistence, double innerResistence){
		return EMF/(resistence + innerResistence);
	}

	public double getResistence2(double EMF, double current, double innerResistence){
		return EMF/current - innerResistence;
	}

	public double getInnerResistence(double EMF, double current, double resistence){
		return EMF/current - resistence;
	}

	//resistivity = resistance * cross- section area / length
	public String resistivity(){return "The resistivity of an object = resistance of object * cross-section area of object / length of object";}
	public double getResistivity(double resistance, double area, double length){
		return (resistance * area) / length;
	}

	public double getResistance(double resistivity, double area, double length){
		return (resistivity * length) / area;
	}

	public double getArea(double resistivity, double resistance, double length){
		return (resistivity * length) / resistance;
	}

	public double getLength(double resistivity, double resistance, double area){
		return (resistance * area) / resistivity;
	}


	// power = voltage * current
	// p = V * I
	public String power(){return "The power of an object = voltage of an object * current running through an object";}
	public double getPower(double voltage, double current){
		return voltage * current;
	}

	public double getVoltage3(double power, double  current){
		return power/current;
	}

	public double getCurrent3(double power, double voltage){
		return power/voltage;
	}

	//power = current * current * resistance
	//p = I * I * R
	public String power2(){return "The power of an object = current running through an object^2 * resistance of object";}
	public double getPower2(double current, double resistance){
		return current*current*resistance;
	}

	public double getCurrent4(double power, double resistence){
		return Math.sqrt(power/resistence);
	}

	public double getResistence3(double power, double current){
		return power/current/current;
	}

	// power = voltage * voltage * resistance
	// p = V * V * R
	public String power3(){return "The power of an object = voltage of an object^2 * resistance of object";}
	public double getPower3(double voltage, double resistance){
		return voltage*voltage*resistance;
	}

	public double getVoltage1(double power, double resistance){
		return Math.sqrt(power/resistance);
	}

	public double getResistance(double power, double voltage){
		return power/voltage/voltage;
	}

	// alternating current = current / square root of 2
	// AI = I / Math.sqrt(2)
	public String AC(){return "The alternating current running through an object = current running through an object / (sqrt(2))";}
	public double getAlternatingCurrent(double current){
		return current/Math.sqrt(2);
	}

	public double getCurrent(double alternatingCurrent){
		return alternatingCurrent * Math.sqrt(2);
	}

	//alternating voltage = voltage / square root of 2
	// AV = V / Math.sqrt(2)
	public String AV(){return "The alternating voltage of an object = voltage of an object / sqrt(2)";}
	public double getAlternatingVoltage(double voltage){
		return voltage/Math.sqrt(2);
	}

	public double getVoltage(double alternatingVoltage){
		return alternatingVoltage * Math.sqrt(2);
	}

//	public double getSeriesResistance(double resistance){
//		Scanner in = new Scanner(System.in);
//		int i = in.nextInt();
//		
//	}

}
