/**
 * 
 */

/**
 * Purpose: print information about Point, Circle, Cylinder Class
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Homework2_4b {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		//create objects of class Point
		CPoint myPoint = new CPoint(10, 20);
		
		//create objects of class Circle
		CCircle myCircle = new CCircle(3, 6, 4.0);
		CCircle myCircle1 = new CCircle(5, 8, 6.0);
		
		//create an object of class Cylinder
		CCylinder myCylinder = new CCylinder(myCircle1, 12.0);

		//print results
		System.out.println("The Point is: " + myPoint);
		System.out.println("The area of circle " + myCircle + "is: " + myCircle.area());
		System.out.println("The area of cylinder" + myCylinder + "is: " + myCylinder.area());
		System.out.println("The volume of cylinder" + myCylinder + "is: " + myCylinder.volume());
	}
}

/**
 * Class CPoint can get and set x, y coordinate
 * @author Xiaokai Jin
 * @version 1.0
 */
class CPoint {

	/** 
	 * constructor1
	 * @param x
	 * @param y
	 */
	public CPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * constructor2
	 * @param an object of class Point
	 */
	public CPoint(CPoint myPoint) {
		x = myPoint.x;
		y = myPoint.y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * output the information of CCircle
	 * @return example (10,20)
	 */
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

	/*
	 * instance variables
	 */
	private int x;	//coordinate for x bar
	private int y;	//coordinate for y bar
}

/**
 * Class Circle can calculate the area of the circle
 * @author Xiaokai Jin
 * @version 1.0
 */
class CCircle{

	/**
	 * constrcuctor1
	 * @param an object of class Point
	 * @param radius
	 */
	public CCircle(CPoint myPoint, double radius) {
		cp = myPoint;
		this.radius = radius;
	}
	
	/**
	 * constrcuctor2
	 * @param x, y coordinate
	 * @param radius
	 */
	public CCircle(int x, int y, double radius) {
		cp = new CPoint(x, y);
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * @return the cp
	 */
	public CPoint getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(CPoint cp) {
		this.cp = cp;
	}

	/**
	 * calculate the area for the circle
	 * @return area
	 */
	public double area() {
		double area = 0.0;	//initialize local variable
		area = Math.PI * getRadius()* getRadius();
		return area;
	}
	
	/**
	 * output the information of CCircle
	 * @return example ((3,6),4.0)
	 */
	@Override
	public String toString() {
		return "(" + cp.toString() + "," + getRadius() + ")";
	}

	/*
	 * instance variables
	 */
	private double radius;	//radius for the circle
	private CPoint cp;		//center point for the circle
}

/**
 * Class Cylinder can calculate the area and the volume of cylinder
 * @author Xiaokai Jin
 * @version 1.0
 */
class CCylinder {

	/**
	 * constructor1
	 * @param an object of class CCircle
	 * @param height
	 */
	public CCylinder(CCircle myCircle, double height) {
		cc = myCircle;
		this.height = height;
	}

	/**
	 * constructor2
	 * @param x, y coordinate, radius of the circle
	 * @param height
	 */
	public CCylinder(int x, int y, double radius, double height) {
		cc = new CCircle(x, y, radius);
		this.height = height;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the cc
	 */
	public CCircle getCc() {
		return cc;
	}

	/**
	 * @param cc the cc to set
	 */
	public void setCc(CCircle cc) {
		this.cc = cc;
	}

	/**
	 * Calculate cylinder volume
	 * @return Volume
	 */
	public double volume() {
		double volume = 0.0;
		volume = getCc().area() * getHeight();
		return volume;
	}

	/**
	 * Calculate cylinder area
	 * @return area
	 */
	public double area() {
		double area = 0.0;	//initialize local variable
		area = 2 * getCc().area() + 2 * Math.PI * cc.getRadius() * getHeight();
		return area;
	}

	/**
	 * output information of cylinder
	 * @return example (((5,8),6.0),12.0)
	 */
	@Override
	public String toString() {
		return "(" + cc.toString() + "," + getHeight() + ")";
	}

	/*
	 * instance variables
	 */
	private double height;	//height for the cylinder
	private CCircle cc;		//circle for the cylinder
}