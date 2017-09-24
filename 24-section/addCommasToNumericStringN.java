import java.util.Scanner;

/**
 * Purpose: new method to add comma to String numbers
 * @author Matthew Jin
 * @version V1.0
 */
public class addCommasToNumericStringN {

	public static String addCommasToNumericStringN(String s) {
		String result = "";
		int len = s.length();
		int digits = 0;

		for (int i = len - 1; i >= 0; i--) {			
			result = s.charAt(i) + result;
			digits++;
			if (digits % 3 == 0 && i > 0) {
				result = "," + result;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String number = null;
		String result = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Please enter a number(0 to quit): ");
			number = sc.next();
			if (number.equals("0")) break;
			result = addCommasToNumericStringN(number);
			System.out.println(result);			
		}
	}
}
