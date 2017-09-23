/**
 * 
 */
package edu.cmu.heinz.ij95713.Shapes;

import java.util.ArrayList;

/**
 * Purpose: test class Circle, class Square, class Triangle
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */
public class Homework2_2 {

	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Shape objects that are created are: ");
		Point point1 = new Point(10, 10);	//create an object of class Point
		Point point2 = new Point(20, 10);   //create an object of class Point
		Point point3 = new Point(10, 20);   //create an object of class Point
		Point point4 = new Point(20, 20);   //create an object of class Point
		Point point5 = new Point(30, 30);   //create an object of class Point
		
		Circle circle1 = new Circle(10, 20, 5.0);  //create an object of class Circle
		Circle circle2 = new Circle(point3, 5.0);  //create an object of class Circle
		
		Square square1 = new Square(10, 20, 10, 20);  //create an object of class Square
		Square square2 = new Square(point1, point2, point3, point4);  //create an object of class Square
		
		Triangle triangle1 = new Triangle(point1, point4, point5);  //create an object of class Triangle
		Triangle triangle2 = new Triangle(10, 20, 30, 10, 20, 30);  //create an object of class Triangle
		
		//output
		System.out.println(circle1);  
		System.out.println(circle2);
		System.out.println(square1);
		System.out.println(square2);
		System.out.println(triangle1);
		System.out.println(triangle2);
		System.out.println();  //blank line
		
		//Start drawing circle, square, triangle
		System.out.println("Drawing the shape objects: ");
		ArrayList<Shape> mylist = new ArrayList<Shape>();
		mylist.add(circle1);   //add circle1 to list
		mylist.add(circle2);   //add circle2 to list
		mylist.add(square1);   //add square1 to list
		mylist.add(square2);   //add square2 to list
		mylist.add(triangle1); //add triangle1 to list
		mylist.add(triangle2); //add triangle2 to list
		
		for(Shape shape : mylist) {
			shape.draw();
		}

		//Start erasing circle, square, triangle
		System.out.println();  //blank line
		System.out.println("Erasing the shape objects: ");
		for(Shape shape : mylist) {
			shape.erase();
		}
	}

}
