/**
 * 
 */
package edu.cmu.heinz.ij95713.Shapes;

/**
 * Purpose: class Point has x ,y coordinate
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Point {
	
	/**
	 * default constructor
	 */
	public Point() {
		x = 0;
		y = 0;
	}
	
	/**
	 * constructor1
	 * @param a
	 * @param b
	 */
	public Point(int a, int b) {
		x = a;
		y = b;
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
	 * output information of a point object
	 * @return a String of the form "(x,y)"
	 */
	@Override
	public String toString() {
		return "(" + getX() + "," + getY() + ")";
	}
	
	/*
	 * instance variable
	 */
	private int x;	//x coordinate
	private int y;	//y coordinate
}
