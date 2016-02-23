import java.util.Scanner;

public class Main {

	static int[][][] cases;
	static int[][] queu;
	static int n;
	static int dup = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		
		while (test > 0) {
			int m = sc.nextInt();
			n = sc.nextInt();
			
			int count = 0;
						
			queu = new int[n][2];
			
			while (count < n) {
				queu[count][0] = sc.nextInt();
				queu[count][1] = sc.nextInt();
				count++;
			}
			cases = new int[m+1][m+1][n];
			int min = findMin(0, 0, 0);
			
			System.out.println(min);
			test--;
		}
	}
	
	public static int findMin(int r1, int r2, int currentQ) {
		int min = 0;
		int dis1 = 0;
		int dis2 = 0;
		if (currentQ < n) {
			if ((cases[r1][r2][currentQ] == 0) || (cases[r2][r1][currentQ] == 0)) {
				if (r1 != 0) {
					dis1 += Math.abs(queu[currentQ][0] - r1);
				}
				dis1 += Math.abs(queu[currentQ][0] - queu[currentQ][1]);
				dis1 += findMin(queu[currentQ][1], r2, currentQ + 1);

				if (r2 != 0) {
					dis2 += Math.abs(queu[currentQ][0] - r2);
				}
				dis2 += Math.abs(queu[currentQ][0] - queu[currentQ][1]);
				dis2 += findMin(r1, queu[currentQ][1], currentQ + 1);

				min = Math.min(dis1, dis2);
				
//				if (dis1 < dis2) {
//					System.out.println("r1 " + queu[currentQ][1] + " r2 " + r2);
//				} else {
//					System.out.println("r1 " + r1 + " r2 " + queu[currentQ][1]);
//				}
				
	//			System.out.println("r1 " + r1 + " r2 " + r2);
	//			System.out.println("dis1 " + dis1 + " dis2 " + dis2 + " current: " + currentQ);
				
				cases[r1][r2][currentQ] = min;
				cases[r2][r1][currentQ] = min;
			} else {
				System.out.println("dup " + dup++);
				return cases[r1][r2][currentQ];
				
			}
		} else {
			return 0;
		}
		
		return min;
	}

}
