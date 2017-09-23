/**
 * 
 */
package edu.cmu.heinz.ij95713.Shapes;

/**
 * Purpose: class Triangle can draw and erase triangle
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public final class Triangle extends Shape {

	/**constructor1
	 * 
	 * @param x1
	 * @param x2
	 * @param x3
	 * @param y1
	 * @param y2
	 * @param y3
	 */
	public Triangle(int x1, int x2, int x3, int y1, int y2, int y3){
		point1 = new Point(x1, y1);  //initialize coordinate for point1
		point2 = new Point(x2, y2);  //initialize coordinate for point2
		point3 = new Point(x3, y3);  //initialize coordinate for point3
	}
	
	/**
	 * constructor2
	 * @param p1
	 * @param p2
	 * @param p3
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		point1 = p1;	//initialize coordinate for point1
		point2 = p2;	//initialize coordinate for point2
		point3 = p3;	//initialize coordinate for point3
	}

	
	/**
	 * @return the point1
	 */
	public Point getPoint1() {
		return point1;
	}

	/**
	 * @param point1 the point1 to set
	 */
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}

	/**
	 * @return the point2
	 */
	public Point getPoint2() {
		return point2;
	}

	/**
	 * @param point2 the point2 to set
	 */
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}

	/**
	 * @return the point3
	 */
	public Point getPoint3() {
		return point3;
	}

	/**
	 * @param point3 the point3 to set
	 */
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}

	/**
	 * draw triangle
	 */
	@Override
	public void draw() {
		System.out.println("Drawing triangle at points " + getPoint1() + ", "
				+ getPoint2() + ", " + getPoint3());
	}

	/**
	 * erase triangle
	 */
	@Override
	public void erase() {
		System.out.println("Erasing triangle at points " + getPoint1() + ", "
				+ getPoint2() + ", " + getPoint3());
	}
	
	/**
	 * output information of a triangle object
	 * @return Triangle at points (10,10), (20,20) and (30,30)
	 */
	@Override
	public String toString() {
		return "Triangle at point " + getPoint1() + ", " + getPoint2() + ", "
		+ getPoint3();
	}

	/*
	 * instance variable
	 */
	private Point point1;	// the point1 of the square
	private Point point2;	// the point2 of the square
	private Point point3;	// the point3 of the square
}
