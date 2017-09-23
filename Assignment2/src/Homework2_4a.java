/**
 * 
 */

/**
 * Purpose: print information about Point, Circle, Cylinder Class
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Homework2_4a {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		//create an object of class Point
		Point myPoint = new Point(10, 20);
		//create an object of class Circle
		Circle myCircle = new Circle(3, 6, 4.0);
		//create an object of class Cylinder
		Cylinder myCylinder = new Cylinder(5, 8, 6.0, 12.0);
		
		//print results
		System.out.println("The Point is: " + myPoint);
		System.out.println("The area of circle " + myCircle + "is: " + myCircle.area());
		System.out.println("The area of cylinder" + myCylinder + "is: " + myCylinder.area());
		System.out.println("The volume of cylinder" + myCylinder + "is: " + myCylinder.volume());
	}

}

/**
 * Class point, superclass of Circle Class
 * @author Xiaokai Jin
 * @version 1.0
 */
class Point {
	
	/** 
	 * constructor1
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * constructor2
	 * @param an object of class Point
	 */
	public Point(Point myPoint) {
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
	 * output point's information
	 * @return example (1,1)
	 */
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}

	/*
	 * instance variables
	 */
	protected int x;	//coordinate for x bar
	protected int y;	//coordinate for y bar
}

/**
 * Class Circle, superclass of Cylinder, subclass of Point
 * @author Xiaokai Jin
 * @version 1.0
 */
class Circle extends Point {
	
	/**
	 * constructor1
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(int x, int y, double radius) {
		super(x, y);
		this.radius = radius;
	}
	
	/**
	 * constrcturo2
	 * @param an object of class Point
	 * @param radius
	 */
	public Circle(Point myPoint, double radius) {
		super(myPoint);
		this.radius = radius;
	}
	
	/**
	 * constructor3
	 * @param an object of class Circle
	 */
	public Circle(Circle myCircle) {
		super(myCircle.x, myCircle.y);
		this.radius = myCircle.radius;
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
	 * calculate the area for the circle
	 * @return area
	 */
	public double area() {
		double area = 0.0;	//initialize local variable
		area = Math.PI * getRadius() * getRadius();
		return area;
	}
	
	/**
	 * output circle's information
	 * @return example ((3,6),4.0)
	 */
	@Override
	public String toString() {
		return "(" + super.toString() + "," + getRadius() + ")";
	}

	/*
	 * instance variables
	 */
	protected double radius;	//radius for the circle
}

/**
 * Class Cylinder, subclass of Circle
 * @author Xiaokai Jin
 * @version 1.0
 */
class Cylinder extends Circle {
	
	/**
	 * constructor1
	 * @param x
	 * @param y
	 * @param radius
	 * @param height
	 */
	public Cylinder(int x, int y, double radius, double height) {
		super(x, y, radius);
		this.height = height;
	}
	
	/**
	 * constructor2
	 * @param an object of class Point
	 * @param radius
	 * @param height
	 */
	public Cylinder(Point myPoint, double radius, double height) {
		super(myPoint, radius);
		this.height = height;
	}
	
	/**
	 * constructor3
	 * @param an object of class Circle
	 */
	public Cylinder(Circle myCircle, double height) {
		super(myCircle);
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
	 * Calculate the volume of cylinder
	 * @return volume
	 */
	public double volume() {
		double volume = 0.0;
		volume = super.area() * getHeight();
		return volume;
	}
	
	/**
	 * Override superclass Circle's area method
	 * Calculate the area of cylinder
	 * @return area
	 */
	@Override
	public double area() {
		double area = 0.0;	//initialize local variable
		area = 2 * super.area() + 2 * Math.PI * getRadius() * getHeight();
	    return area;
	}

	/**
	 * output the information of cylinder
	 * @return example (((5,8),6.0),12.0)
	 */
	@Override
	public String toString() {
		return "(" + super.toString() + "," + getHeight() + ")";
	}

	/*
	 * instance variables
	 */
	protected double height;	//height for the cylinder
}

