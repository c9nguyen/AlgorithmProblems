import java.util.Scanner;

public class Timebom {
	final static String STAR = "*";

	static boolean[][] digits;
	static boolean[][] input;
	
	public static void main(String[] args) {
		int counter = 0;
		digits = new boolean[10][15];
		input = new boolean[8][15];
		
		hardCode();
		
		// printout
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 15; j++) {
//				if (digits[i][j]) System.out.print("*");
//				else System.out.print(" ");
//				if ((j + 1) % 3 == 0) System.out.println();
//			}
//			
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		String c;
		
		while(sc.hasNext()) {
			c = sc.next();
		}
	
	}
	
	public static void hardCode() {
		for (int i = 0; i < 10; i++) {
				if (i != 1) {
					digits[i][0] = true;
				}
				
				if (i != 1 && i != 4) {
					digits[i][1] = true;
				}
				
			
				digits[i][2] = true;
		
				if (i != 1 && i != 2 && i != 3 && i != 7) {
					digits[i][3] = true;
				}
				
				if (i != 5 && i != 6) {
					digits[i][5] = true;
				}
				
				if (i != 1 && i != 7) {
					digits[i][6] = true;
				}
				
				if (i != 0 && i != 1 && i != 7) {
					digits[i][7] = true;
				}
				
				digits[i][8] = true;
				
				if (i == 0 || i == 2 || i == 6 || i == 8) {
					digits[i][9] = true;
				}
				
				if (i != 2) {
					digits[i][11] = true;
				}
				
				
				if (i != 1 && i != 4 && i != 7) {
					digits[i][12] = true;
				}
				
				if (i != 1 && i != 4 && i != 7) {
					digits[i][13] = true;
				}
				
				digits[i][14] = true;
		}

	}

}
