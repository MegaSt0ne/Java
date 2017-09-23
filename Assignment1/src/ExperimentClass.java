/* Date: 20170901 Version: 1.0
 * Program Purpose: 1.	Write a program to test class String
 * and StringBuffer
 * Author: Xiaokai Jin
 */

public class ExperimentClass {
	public static void main(String[] args) {
		//If the number of command-line arguments is not two, 
		//the main function should return immediately.
		if ( args.length != 2 ) {
			System.out.println("Please input two arguments!");
			return;
		}
		
		//declaration
		String s1 = args[0];
		String s2 = args[1];
		StringBuffer sbuf1 = new StringBuffer(args[0]);
		StringBuffer sbuf2 = new StringBuffer(args[1]);
		MyClass myClass = new MyClass();
		
		//class String
		System.out.println("	Class String Begins");
		//s1.length()
		System.out.printf("s1.length(): %d \n", s1.length());
		
		//s1.charAt()
		for ( int i = 0; i < s1.length(); i++ ) {
			System.out.println(s1.charAt(i));
		}
		
		//s1.equals(s2)
		System.out.printf("s1.equals(s2): %s \n", s1.equals(s2));
		
		//s1.equalsIgnoreCase(s2)
		System.out.printf("s1.equalsIgnoreCase(s2): %s \n", s1.equalsIgnoreCase(s2));
		
		//s1.compareTo(s2)
		System.out.printf("s1.compareTo(s2): %s \n", s1.compareTo(s2));
		
		//s1.regionMatches(int toffset,  s2, int offset, int len)
		System.out.printf("s1.regionMatches( 3, s2, 4, 3): %s \n", s1.regionMatches(3, s2, 4, 3));
		
		//s1.regionMatches(boolean ignoreCase,  int toffset,  s2, int offset, int len) 
		System.out.printf("s1.regionMatches( false, 3, s2, 4, 3): %s \n", s1.regionMatches(false, 3, s2, 4, 3));
		
		//s1.indexOf(c, i) 
		System.out.printf("s1.indexOf(A, 0): %s \n", s1.indexOf(65, 0));
		
		//s1.concat(s2)
		System.out.printf("s1.concat(s2): %s \n", s1.concat(s2));
		
		//s1.replace(c1, c2)
		System.out.printf("s1.replace('a', 'i'): %s \n", s1.replace('a', 'i'));
		
		//s1.upperCase()
		System.out.printf("s1.upperCase(): %s \n", s1.toUpperCase());
		
		//s1.lowerCase()
		System.out.printf("s1.lowerCase(): %s \n", s1.toLowerCase());
		
		//class String
		System.out.println("	Class StringBuffer Begins");
		
		//sbuf1.length()
		System.out.printf("sbuf1.length(): %d \n", sbuf1.length());
		
		//sbuf1.delete(int start, int end)
		System.out.printf("sbuf1.delete(0, 2): %s \n", sbuf1.delete(0, 2));
		
		//sbuf1.deleteCharAt(int index)
		System.out.printf("sbuf1.deleteCharAt(2): %s \n", sbuf1.deleteCharAt(2));
		
		//sbuf1.reverse() 
		System.out.printf("sbuf1.reverse(): %s \n", sbuf1.reverse());
		
		//sbuf1.replace() 
		System.out.printf("sbuf1.replace(): %s \n", sbuf1.replace(0, 1, "aaa"));
		
		//sbuf1.append()
		System.out.printf("sbuf1.append(boolean): %s \n", sbuf1.append(true));
		
		//sbuf1.append()
		System.out.printf("sbuf1.append(sbuf2): %s \n", sbuf1.append(sbuf2));
		
		//sbuf1.append()
		System.out.printf("sbuf1.append(myClass): %s \n", sbuf1.append(myClass));
		
		//sbuf1.insert()
		System.out.printf("sbuf1.insert(boolean): %s \n", sbuf1.insert(0, true));
		
		//sbuf1.insert()
		System.out.printf("sbuf1.insert(sbuf2): %s \n", sbuf1.insert(0, sbuf2));	

		//sbuf1.insert()
		System.out.printf("sbuf1.insert(myClass): %s \n", sbuf1.insert(0, myClass));
	}
}
