import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int num = sc.nextInt();
		
		if (num <= 25) {
			sb.append('a');
			sb.append(Character.toChars(num + 'a'));
		} else {
		boolean isOdd = num % 25 == 0;
		
		int numOf25 = num / 25;
		
		int localMin = numOf25 - 1;
		
		int minDigits = numOf25 + ((isOdd) ? 1 : 2);
		
		int secondCharValue = (num - localMin * 25);
			
		int lastCharValue;
		
		if (secondCharValue % 2 == 0) {
			secondCharValue = secondCharValue / 2 + 1;
			lastCharValue = 1;		
		} else {
			secondCharValue = secondCharValue / 2 + 2;
			lastCharValue = 2;	
		}
		
		

		sb.append('a');
		sb.append(Character.toChars(secondCharValue + 'a' - 1));
		for (int i = 2; i < minDigits - 1; i++) {
			sb.append((i % 2 == 0) ? 'a' : 'z');
//			if (i > minDigits / 2) {
//				System.out.println(sb.length());
//				System.out.println(sb);
//			}
		}
		sb.append(Character.toChars(lastCharValue + 'a' - 1));
		
		}

		System.out.println(sb.toString());
	}

}