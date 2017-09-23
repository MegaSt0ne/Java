/**
 * Purpose: test each method of class ComplexNumber
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */

public class Homework2_1 {
	
	/**
	 * main methods
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create a new object of class ComplexNumber
		// test constructor2
		ComplexNumber complexNum1 = new ComplexNumber(3.0, 2.0);
		System.out.println("The first complex number: " + complexNum1);
		
		// create a new object of class ComplexNumber
		ComplexNumber complexNum2 = new ComplexNumber(4.0, 1.0);
		System.out.println("The second complex number: " + complexNum2);
		System.out.println();	//new line
		
		//test static method addNumStatic
		System.out.println("Add the first complex number to "
				+ "the second complex number with static method: ");
		ComplexNumber complexNum3 = ComplexNumber.addNumStatic(complexNum1, complexNum2);
		System.out.println(complexNum3);
		System.out.println();	//new line
		
		//test method addNum
		System.out.println("Add the first complex number to "
				+ "the second complex number with non-static method: ");
		System.out.println(complexNum1.addNum(complexNum2));
		System.out.println();	//new line

		//test static method subtractNumStatic
		System.out.println("Subtract the second complex number from "
				+ "the first complex number with static method: ");
		complexNum3 = ComplexNumber.subtractNumStatic(complexNum1, complexNum2);
		System.out.println(complexNum3);
		System.out.println();	//new line

		//test method subtractNum
		System.out.println("Subtract the second complex number from "
				+ "the first complex number with non-static method: ");	
		System.out.println(complexNum1.subtractNum(complexNum2));
		System.out.println();	//new line
		
		//test method getRealPart 
		System.out.println("Get the real part of the first complex number: " 
		+ complexNum1.getRealPart());

		//test method getImagPart
		System.out.println("Get the imaginary part of the first complex number: " 
		+ complexNum1.getImagPart() + "i");
		System.out.println(); 	//new line
		
		//test method setRealPart 
		complexNum1.setRealPart(5.0);
		System.out.println("Set the real part of the first complex number to 5.0: ");
		System.out.println("The first complex number: " + complexNum1);
		System.out.println();	//new line
		
		//test method setImagPart 
		complexNum1.setImagPart(8.0);
		System.out.println("Set the imaginary part of the first complex number to 8.0i: ");
		System.out.println("The first complex number: " + complexNum1);
		System.out.println();	//new line
		
		//test default constructor
		System.out.println("Creating a complex number with default constructor: " 
		+ new ComplexNumber());
		System.out.println();	//new line
		
		//test constructor3
		System.out.println("Creating a complex number which is equal to the first complex number: " 
		+ new ComplexNumber(complexNum1));
		System.out.println();	//new line
	}
}
