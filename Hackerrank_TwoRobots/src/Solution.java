import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	static int[][][] cases;
	static int[][] cases2;
	static int[][] queu;
	static int n;
	static int dup = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int test = Integer.parseInt(br.readLine());
		
		String[] split = new String[2];
		
		while (test > 0) {
			split = br.readLine().split(" ");
			
			int m = Integer.parseInt(split[0]);
			n = Integer.parseInt(split[1]);

			int count = 0;
						
			queu = new int[n][2];
			
			while (count < n) {
				split = br.readLine().split(" ");
				queu[count][0] = Integer.parseInt(split[0]);
				queu[count][1] = Integer.parseInt(split[1]);
				count++;
			}
			cases = new int[m+1][m+1][n];
			cases2 = new int[m+1][n];
			int min = findMin(0, 0, 0);
			
			int r1 = 0, r2 = 0, que = 0;
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				if (cases[r1][r2][i] == 0) {
					if (r1 == 0) {
						sum += Math.abs(queu[que][0] - queu[que][1]);
					} else {
						
					}
					
					
				} else {
					sum += cases[r1][r2][i];
				}
			}
			
			sb.append(min);
			sb.append("\n");
			test--;
		}
		
		System.out.println(sb.toString());
	}
	
	public static int findMin2(int r1, int currentQ) {
		int min = 0;
		int dis1 = 0;
		int dis2 = 0;
		if (currentQ < n) {
			if (cases2[r1][currentQ] == 0) {
				if (r1 == 0) {
					min += findMin2(queu[currentQ][1], currentQ + 1);
			
				} else {
				
					if (r1 == queu[currentQ-1][1]) {
						dis1 += findMin2(queu[currentQ][1], currentQ + 1);	
					}
					
					dis1 += Math.abs(queu[currentQ][0] - r1);
					dis1 += findMin2(queu[currentQ][1], currentQ + 1);				
					
					dis2 += Math.abs(queu[currentQ][0] - queu[currentQ-1][1]);
					dis2 += findMin2(r1, currentQ + 1);
					
					
					min = Math.min(dis1, dis2);
											
				}
				min += Math.abs(queu[currentQ][0] - queu[currentQ][1]);
				cases2[r1][currentQ] = min;
			} else {
//				System.out.println("dup " + dup++);
				return cases2[r1][currentQ];
				
			}
		} else {
			return 0;
		}
		
		return min;
	}
	
	public static int findMin(int r1, int r2, int currentQ) {
		int min = 0;
		int dis1 = 0;
		int dis2 = 0;
		if (currentQ < n) {
			if ((cases[r1][r2][currentQ] == 0)) {
				if (r1 != 0) {
					dis1 += Math.abs(queu[currentQ][0] - r1);
				}
				dis1 += findMin(queu[currentQ][1], r2, currentQ + 1);

				if (r1 != r2) {
					if (r2 != 0) {
						dis2 += Math.abs(queu[currentQ][0] - r2);
					}
					dis2 += findMin(r1, queu[currentQ][1], currentQ + 1);
					
					min = Math.min(dis1, dis2);

				} else {
					min = dis1;
				}
				
				min += Math.abs(queu[currentQ][0] - queu[currentQ][1]);
				
				cases[r1][r2][currentQ] = min;
				cases[r2][r1][currentQ] = min;
			} else {
//				System.out.println("dup " + dup++);
				return cases[r1][r2][currentQ];
			}
		} else {
			return 0;
		}
		
		return min;
	}

}
