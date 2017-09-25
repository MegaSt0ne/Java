import java.util.Scanner;

public class CountUppercase {
	
	public static int myCountUppercase(String str) {
		int counter = 0;
		char aChar = 0;
		for( int i = 0; i < str.length(); i++ ) {
			aChar = str.charAt(i);
			if (Character.isUpperCase(aChar)) {
				counter++;
			}
		}
		return counter;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = "";
		while(true) {
			System.out.println("Please enter the string(0 to quit): ");
			s = sc.nextLine();
			if (s.equals("0")) break;
			System.out.println(myCountUppercase(s));
		}

	}

}
