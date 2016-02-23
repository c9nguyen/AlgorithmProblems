import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a, b, c, d, e ,f;
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		f = sc.nextInt();
		
		int negative = -1;
		
		negative = Math.min(negative, a + e + d);
		negative = Math.min(negative, a + b + c +d);
		negative = Math.min(negative, a + b + f);
		
		System.out.println(negative);
	}

}
