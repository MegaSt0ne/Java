import java.util.Scanner;

/**
 * purpose: removes all occurrences of the character ch from the string str
 * @author Matthew Jin
 * @version 1.0
 */
public class removeAlloccurenceN {

	public static String removeAlloccurenceN(String s, char ch) {
		while(true) {
			int position = s.indexOf(ch);
			if (position != -1) {
				s = s.substring(0, position) + s.substring(position + 1);		
			} else break;		
		}
		return s;
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
			s1 = removeAlloccurenceN(s, ch);
			System.out.println(s1);
		}
	}
}
