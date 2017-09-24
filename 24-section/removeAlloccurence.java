import java.util.Scanner;

/**
 * purpose: removes all occurrences of the character ch from the string str
 * @author Matthew Jin
 * @version 1.0
 */
public class removeAlloccurence {
	
	public static String removeAlloccurence(String s, char ch) {
		String s1 = "";
		int len = s.length();
		for(int i = len - 1; i >= 0; i--) {
			if (s.charAt(i) != ch) {
				s1 = s.charAt(i) + s1;		
			}
		}
		return s1;
	}
	
	public static void main(String[] args) {
		String s = "";
		String s1 = "";
		char ch = 0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Please enter a string(0 to quit): ");
			s = sc.nextLine();
			if (s.equals("0")) break;
			System.out.println("Please enter the char you want to remove: ");
			ch = sc.nextLine().charAt(0);
			s1 = removeAlloccurence(s, ch);
			System.out.println(s1);
		}
	}
}
