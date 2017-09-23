/**
 * Purpose: Abstract the complex numbers and perform some basic arithmetics
 * @version: 1.0
 * @author: Xiaokai Jin Date: 2017/09/15 
 */

public class ComplexNumber {
	
	/**
	 * Constructor1
	 * Initialize realPart = 0.0, imagPart = 0.0
	 */
	public ComplexNumber() {
		realPart = 0.0;
		imagPart = 0.0;
	}

	/**
	 * Constructor2 
	 * @param realPart
	 * @param imagPart
	 */
	public ComplexNumber(double realPart, double imagPart) {
		this.realPart = realPart;
		this.imagPart = imagPart;
	}
	
	/**
	 * Constructor3
	 * @param an object of class ComplexNumber
	 */
	public ComplexNumber(ComplexNumber complexNum) {
		realPart = complexNum.realPart;
		imagPart = complexNum.imagPart;
	}
	
	/**
	 * static add method: perform addition of two complex numbers
	 * @param two objects of class ComplexNumber
	 * @return a new object of class ComplexNumber
	 */
	public static ComplexNumber addNumStatic(ComplexNumber complexNum1, ComplexNumber complexNum2 ) {
		ComplexNumber complexNew = new ComplexNumber();
		complexNew.setRealPart(complexNum1.getRealPart() + complexNum2.getRealPart());
		complexNew.setImagPart(complexNum1.getImagPart() + complexNum2.getImagPart());
		return complexNew;
	}

	/**
	 * static subtract method: perform subtraction of two complex numbers
	 * @param two objects of class ComplexNumber
	 * @return a new object of class ComplexNumber
	 */
	public static ComplexNumber subtractNumStatic(ComplexNumber complexNum1, ComplexNumber complexNum2 ) {
		ComplexNumber complexNew = new ComplexNumber();
		complexNew.setRealPart(complexNum1.getRealPart() - complexNum2.getRealPart());
		complexNew.setImagPart(complexNum1.getImagPart() - complexNum2.getImagPart());
		return complexNew;
	}

	/**
	 * Get real part of complex numbers
	 * @return the realPart
	 */
	public double getRealPart() {
		return realPart;
	}
	
	/**
	 * set real part of complex numbers
	 * @param realPart the realPart to set
	 */
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}
	
	/**
	 * get imaginary part of complex numbers
	 * @return the imagPart
	 */
	public double getImagPart() {
		return imagPart;
	}
	
	/**
	 * set imaginary part of complex numbers
	 * @param imagPart the imagPart to set
	 */
	public void setImagPart(double imagPart) {
		this.imagPart = imagPart;
	}
	
	/**
	 * Add methods: perform addition of two complex numbers
	 * @param an object of class ComplexNumber
	 */
	public ComplexNumber addNum(ComplexNumber complexNum) {
		this.setRealPart(this.getRealPart() + complexNum.getRealPart());
		this.setImagPart(this.getImagPart() + complexNum.getImagPart());
		return this;
	}
	
	/**
	 * Subtract methods: perform subtraction of two complex numbers
	 * @param an object of class ComplexNumber
	 */
	public ComplexNumber subtractNum(ComplexNumber complexNum) {
		this.setRealPart(this.getRealPart() - complexNum.getRealPart());
		this.setImagPart(this.getImagPart() - complexNum.getImagPart());
		return this;
	}

	/**
	 * output complex number's basic information
	 * @return example (4, 4i)
	 */
	@Override
	public String toString() {
		return "(" + this.getRealPart() + ", " + this.getImagPart() + "i" + ")";
	}
	
	/*
	 * Instance Variable Definition
	 */
	private double realPart;		// real part of complex numbers
	private double imagPart;		// imaginary part of complex numbers
}
