/**
 * 
 */
package edu.cmu.heinz.ij95713.Shapes;

/**
 * Purpose: class Square can draw and erase square
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public final class Square extends Shape {
	
	/**
	 * constructor1
	 * @param x1
	 * @param x2
	 * @param y1
	 * @param y2
	 */
	public Square(int x1, int x2, int y1, int y2){
		point1 = new Point(x1, y1);  //initialize coordinate for point1
		point2 = new Point(x2, y1);  //initialize coordinate for point2
		point3 = new Point(x1, y2);  //initialize coordinate for point3
		point4 = new Point(x2, y2);  //initialize coordinate for point4
	}
	
	/**
	 * constructor2
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public Square(Point p1, Point p2, Point p3, Point p4) {
		point1 = p1;	//initialize coordinate for point1
		point2 = p2;	//initialize coordinate for point2
		point3 = p3;	//initialize coordinate for point3
		point4 = p4;	//initialize coordinate for point4
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
	 * @return the point4
	 */
	public Point getPoint4() {
		return point4;
	}

	/**
	 * @param point4 the point4 to set
	 */
	public void setPoint4(Point point4) {
		this.point4 = point4;
	}
	
	/**
	 * draw square
	 */
	@Override
	public void draw() {
		System.out.println("Drawing square at points " + getPoint1() + ", "
				+ getPoint2() + ", " + getPoint3() + ", " + getPoint4());
	}

	/**
	 * erase square
	 */
	@Override
	public void erase() {
		System.out.println("Erasing square at points " + getPoint1() + ", "
				+ getPoint2() + ", " + getPoint3() + ", " + getPoint4());
	}
	
	/**
	 * output information of a square object
	 * @return example Square at points (10,10), (20,10), (10,20) and (20,20)
	 */ 
	@Override
	public String toString() {
		return "Square at point " + getPoint1() + ", " + getPoint2() + ", "
		+ getPoint3() + ", " + getPoint4();
	}

	/*
	 * instance variable
	 */
	private Point point1;	// the point1 of the square
	private Point point2;	// the point2 of the square
	private Point point3;	// the point3 of the square
	private Point point4;	// the point4 of the square
}
