import java.util.Scanner;

/**
 * purpose: reverse strings
 * @author Matthew Jin
 * @version 1.0
 */
public class reverseString {
	
	public static String reverseString(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result = s.charAt(i) + result;
		}
		return result;
	}
	
	public static boolean simpleIsPalindrome(String str) {
		return (str.equals(reverseString(str)));
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.println("Please enter a string(0 to quit): ");
			input = sc.nextLine();
			if (input.equals("0")) break;
			System.out.println(reverseString(input));
			
			System.out.println(simpleIsPalindrome(input));
		}

	}

}
