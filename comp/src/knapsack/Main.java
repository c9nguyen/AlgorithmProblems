package knapsack;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		final Scanner in = new Scanner(System.in);
		final int n = in.nextInt();
		final int k = in.nextInt();
		final int[] c = new int[n + 1];
		final int[] v = new int[n + 1];
		final int[] p = new int[k + 1];
		final int[] arr = new int[k + 1];
		
		
		for(int i = 1; i <= n; i++){
			c[i] = in.nextInt();
			v[i] = in.nextInt();
		}
		
//		for(int i = 0; i < n + 1; i++){
//			arr[i][0] = 0;
//		}
//		for(int i = 0; i < k + 1; i++){
//			arr[0][i] = 0;
//		}
		int sum = 0;
		for(int i = 1; i < n + 1; i++){
			sum += c[i];

			for(int j = c[i]; j < k + 1; j++){
//				if (i == 4) {
//					System.out.println("Here");
//				}

				if(j <= sum){
					int max;


					max = arr[j];
					if (j - c[i] >= 0)
						max = Math.max(max, v[i] + p[j - c[i]]);
					arr[j] = max;

					
				} else {

					arr[j] = arr[j - 1];
				}
				
				
//				System.out.print(max + "\t");
//				int max = arr[i - 1][j];
//	
//				
//				if(i - 1 >= 0 && j - c[i] >= 0){
//
//					max = Math.max(max, arr[i - 1][j - c[i]] + v[i]);
//				}
//				arr[i][j] = max;
			}
			for (int j = c[i]; j < k + 1; j++) {
				p[j] = arr[j];
			}
		
		}

		for(int i = 1; i < k + 1; i++){
			System.out.print(arr[i] + " ");
		}

	}

}
