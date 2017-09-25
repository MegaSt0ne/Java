import java.util.Scanner;

/**
 * purpose: test if a string is palindrome
 * @author Matthew Jin
 *
 */
public class isPalindrome {
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = "";
		while(true) {
			System.out.println("Please enter a string(0 to quit): ");
			s = sc.nextLine();
			if (s.equals("0")) {
				break;
			} 
			System.out.println(isPalindrome(s));
		}
	}

}
