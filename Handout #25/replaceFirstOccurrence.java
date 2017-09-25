import java.util.Scanner;

public class replaceFirstOccurrence {
	
	public static String myReplaceFirstOccurrence(String str,
												String orig,
												String repl) {
		int position = str.indexOf(orig);
		str = str.substring(0, position) + repl + str.substring(position + orig.length());
		return str;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str = "";
		String orig = "";
		String repl = "";
		
		while(true) {
			System.out.println("Please enter the string: ");
			str = sc.nextLine();
			System.out.println("Please enter the orig: ");
			orig = sc.nextLine();
			System.out.println("Please enter the repl: ");
			repl = sc.nextLine();
			
			System.out.println(myReplaceFirstOccurrence(str, orig, repl));
		}
		

	}

}
