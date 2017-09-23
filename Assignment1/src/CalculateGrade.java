/* Date: 20170901 Version: 1.0
 * Program Purpose: 1.	Write a Java program to 
 * calculate the letter grades of students in a class and report them. 
 * Author: Xiaokai Jin
 */


import java.util.*;
import java.math.*;
import java.util.Collections;

public class CalculateGrade {

	// main method
	public static void main (String[] args) {
		System.out.println("Please enter the number of student in the class: ");
		Scanner myScanner = new Scanner(System.in);	
		int studentNum = myScanner.nextInt();

		//declaration score list
		ArrayList<Integer> scoreListA = new ArrayList<Integer>();
		ArrayList<Integer> scoreListB = new ArrayList<Integer>();
		ArrayList<Integer> scoreListC = new ArrayList<Integer>();
		ArrayList<Integer> scoreListD = new ArrayList<Integer>();
		ArrayList<Integer> scoreListF = new ArrayList<Integer>();

		//append student score into score list
		for ( int i = 0; i < studentNum; i++) {
			int studentScore = (int) ( ( Math.random() * 51 ) + 50 );
			if ( studentScore >=90 && studentScore <=100 ) {
				scoreListA.add(studentScore);
			} else if ( studentScore >= 80 && studentScore <= 89 ) {
				scoreListB.add(studentScore);
			} else if ( studentScore >= 70 && studentScore <= 79 ) {
				scoreListC.add(studentScore);
			} else if ( studentScore >= 60 && studentScore <= 69 ) {
				scoreListD.add(studentScore);
			} else {
				scoreListF.add(studentScore);
			}
		}
		
		// sort list value
		Collections.sort(scoreListA);
		Collections.sort(scoreListB);
		Collections.sort(scoreListC);
		Collections.sort(scoreListD);
		Collections.sort(scoreListF);
		
		outPutList(scoreListA, "A");
		outPutList(scoreListB, "B");
		outPutList(scoreListC, "C");
		outPutList(scoreListD, "D");
		outPutList(scoreListF, "F");
	}
	
	//method for output grade
	public static void outPutList ( ArrayList<Integer> array, String letterGrade) {
		for ( int i = 0; i < array.size(); i++ ) {
			if ( i == 0) {
				System.out.print( letterGrade + " " );
			}
			
			System.out.printf("%d ", array.get(i));
			
			// When the last number displays, start a new line
			if ( i == ( array.size() - 1 ) ) {
				System.out.println();
			}
		}
	}
}

