import java.util.Scanner;

/**
 * purpose: to use commas to separate the digits into groups of three
 * @author Matthew Jin
 * @version 1.0
 */
public class AddCommaToNumericString {

	public static String AddCommaToNumbericString(String number) {
		int count = number.length() / 3;	//indicate how many comma in the number
		int mod = number.length() % 3;
		if (mod == 0) count--;
		String numberNew = number;
		
		//add comma to every three numbers
		for (int i = 1; i <= count; i++) {
			numberNew = numberNew.substring(0, number.length() - 3 * i) + ","
					+ numberNew.substring(number.length() - 3 * i);
		}
		return numberNew;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = null;
		String numberNum = null;
		while(true) {
			System.out.println("Please enter a number(0 to quit): ");
			number = sc.nextLine();
			if ( number.equals("0") ) break;
			numberNum = AddCommaToNumericString.AddCommaToNumbericString(number);
			System.out.println(numberNum);
		}
		sc.close();
		System.out.println("Program ends!");
	}
}


