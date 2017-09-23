/**
 * 
 */
package edu.cmu.heinz.ij95713.Shapes;

/**
 * Purpose: class Circle can draw and erase circle
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public final class Circle extends Shape {
	
	/**
	 * constructor1
	 * @param a
	 * @param b
	 * @param r
	 */
	public Circle(int a, int b, double r) {
		point = new Point(a, b);
		radius = r;			//instantiate radius of Circle
	}
	
	/**
	 * constructor2
	 * @param p
	 * @param r
	 */
	public Circle(Point p, double r) {
		point = p;			//instantiate object Point
		radius = r;		//instantiate radius of Circle
	}
	
	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
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
	 * draw circle
	 */
	@Override
	public void draw() {
		System.out.printf("Drawing circle at point (%d,%d) with radius %.1f. \n", 
				getPoint().getX(), getPoint().getY(), getRadius());
	}

	/**
	 * erase circle
	 */
	@Override
	public void erase() {
		System.out.printf("Erasing circle at point (%d,%d) with radius %.1f. \n", 
				getPoint().getX(), getPoint().getY(), getRadius());
	}

	/**
	 * output information of a circle object
	 * @return example Circle at point (10,20) with radius 5.0
	 */
	@Override
	public String toString() {
		return "Circle at point " + getPoint() + " with radius " + getRadius();
	}

	/*
	 * instance variable
	 */
	private Point point;	// the center of the circle
	double radius;	// the radius of the circle
	
}
