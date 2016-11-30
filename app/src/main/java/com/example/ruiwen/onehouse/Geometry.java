package com.example.ruiwen.onehouse;



public class Geometry {
	
//	double area, circumF, volume, surfaceA, base, height, length, width, radius, theta;
	//A = BR
	
/**
 * @param base -base of triangle
 * @param height - height of triangle
 * @return return the area of the rectangle
 */
	public double getAreaRect(double base, double height){
		return base * height;
	}
	public String AreaRect(){return "The area of the rectangle = base of triangle * height of triangle. ";}
	/**
	 * @param area of rectangle
	 * @param height of rectangle
	 * @return base of rectangle
	 */
	public double getBaseRect(double area, double height){
		return area / height;
	}
	public String BaseRect(){return "The base of rectangle = area of triangle / height of triangle. ";}
	
	/**
	 * @param area of rectangle 
	 * @param base of rectangle
	 * @return height of rectangle
	 */
	public double getHeightRect(double area, double base){
		return area / base;
	}
	//A = .5BR
	/**
	 * @param base of triangle
	 * @param height of triangle
	 * @return area of triangle
	 */
	public double getAreaTri(double base, double height){
		return base * height / 2;
	}
	
	/**
	 * @param area of triangle
	 * @param height of triangle
	 * @return base of triangle
	 */
	public double getBaseTri(double area, double height){
		return area * 2 / height;
	}
	
	/**
	 * @param area of triangle
	 * @param base of triangle
	 * @return height of triangle
	 */
	public double getHeightTri(double area, double base){
		return area * 2 / base;
	}
	//A = PI * R^2
	/**
	 * @param radius of a circle
	 * @return	area of circle
	 */
	public double getAreaC(double radius){
		return Math.PI * radius * radius;	
	}
	
	/**
	 * @param area of a circle
	 * @return radius of a circle, with area known
	 */
	public double getRadiusC(double area){
		return Math.sqrt(area / Math.PI);
	}
	
	//C = 2 * PI * R
	/**
	 * @param radius of a circle
	 * @return	circumference of a circle
	 */
	public double getCircumC(double radius){
		return 2 * radius * Math.PI;
	}
	
	/**
	 * @param circumference	of a circle
	 * @return	radius of a circle , with circumference known
	 */
	public double getRadiusCircum(double circumference){
		return circumference / (2 * Math.PI);
	}
	
	// rectangular solid V = l * w * h
	/**
	 * @param length of rectangular solid
	 * @param width of rectangular solid
	 * @param height of rectangular solid
	 * @return	volumn of rectangular solid
	 */
	public double getVolumeRS(double length, double width, double height){
		return length * width * height;
	}
	
	/**
	 * @param volume of rectangular solid
	 * @param width	of rectangular solid
	 * @param height of rectangular solid
	 * @return length of of rectangular solid
	 */
	public double getLengthRS(double volume, double width, double height){
		return volume / (width * height);
	}
	
	/**
	 * @param volume of rectangular solid
	 * @param length of rectangular solid
	 * @param height of rectangular solid
	 * @return width of rectangular solid
	 */
	public double getWidthRS(double volume, double length, double height){
		return volume / (length * height);
	}
	
	/**
	 * @param volume of rectangular solid
	 * @param width of rectangular solid
	 * @param length of rectangular solid
	 * @return height of of rectangular solid
	 */
	public double getHeightRS(double volume, double width, double length){
		return volume / (width * length);
	}
	
	//Cylinder V  = PI * R^2 * H
	/**
	 * @param radius of a cylinder
	 * @param height of a cylinder
	 * @return volume of a cylinder
	 */
	public double getVolumeCy(double radius, double height){
		return Math.PI * radius* radius * height;
	}
	
	/**
	 * @param volume of a cylinder
	 * @param height of a cylinder
	 * @return radius of of a cylinder with volume known
	 */
	public double getRadiusCyV(double volume, double height){
		return Math.sqrt(volume / ( height * Math.PI));
	}
	
	/**
	 * @param volume of a cylinder
	 * @param radius of a cylinder
	 * @return height of a cylinder with volume known
	 */
	public double getHeightCyV(double volume, double radius){
		return volume /(Math.PI * radius * radius);
	}
	
	//Cylinder S = 2*pi*radius*height + 2 * pi * radius^2
	
	/**
	 * @param radius of a cylinder
	 * @param height of a cylinder
	 * @return total surface area of a cylinder
	 */
	public double getSurfaceAreaCy(double radius, double height){
		return 2* Math.PI* radius * height + 2 * getAreaC(radius);
	}
	
	/**
	 * @param surfaceArea of a cylinder
	 * @param height of a cylinder
	 * @return radius of a cylinder with total surface area known
	 */
	public double getRadiusCyA(double surfaceA, double height){
		return (-2*Math.PI*height + Math.sqrt((2*Math.PI*height)* (2*Math.PI*height)+ 8*Math.PI*surfaceA)) /(4 * Math.PI);
	}
	
	/**
	 * @param surfaceArea of a cylinder
	 * @param radius of a cylinder
	 * @return height of a cylinder with total surface area known
	 */
	public double getHeightCyA(double surfaceA, double radius){
		return (surfaceA - 2 * getAreaC(radius)) / (2 * Math.PI * radius);
	}
	
	//Sphere V = 4/3 * pi * r^3 
	/**
	 * @param radius of a sphere
	 * @return volume of a sphere
	 */
	public double getVolumeS(double radius){
		return 4 / 3 * Math.PI * radius * radius * radius;
	}
	
	/**
	 * @param volume of a sphere
	 * @return radius of a sphere with volume known
	 */
	public double getRadiusSV(double volume){
		return Math.cbrt(volume * 3 / ( 4 * Math.PI));
	}
	
	//Sphere S = 4 * PI * R ^2 
	/**
	 * @param radius of a sphere
	 * @return surface area of a sphere
	 */
	public double getSurfaceAS(double radius){
		return 4 * Math.PI  * radius * radius;
	}
	/**
	 * @param surfaceArea of a sphere
	 * @return radius of a sphere with surface area given.
	 */
	public double getRadiusSS(double surfaceA){
		return Math.sqrt(surfaceA / (4 * Math.PI));
	}
	
	public double getArchLength(double radius, double theta){
		return 2* Math.PI * radius * theta / 360;
	}

}
