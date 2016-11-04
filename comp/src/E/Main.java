package E;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String word = in.next();
		int n = word.length();
		char[] w = word.toCharArray();
		
		int[] count = new int[n];
		
		ArrayList<Integer> B = new ArrayList<Integer>();
		
		for (int i = 0; i < n ; i++) {
			if (w[i] == 'B') {
				B.add(i);
			} else {
				for (int j = B.size() - 1; j >= 0; j--) {
					int index = i - B.get(j);
					count[index]++;
				}
			}
		}
		
		for (int i = 1; i < count.length; i++) {
			System.out.println(count[i]);
		}
		
//		int[] arr = new int[n];
//		int[] ans = new int[n];
//		int[] bs = new int[n];
//		int a = 0;
//		int b = 0;
//		for(int i = 0; i < n; i++){
//			if(w[i] == 'A'){
//				arr[a] = i;
//				a++;
//			} else {
//				bs[b] = i;
//				b++;
//			}
//		}
//		
//
//		int i;
//		int j;
//		int temp;
//		for(i = 0; i < a; i++){
//			for(j = 0; j < b; j++){
//				temp = arr[i] - bs[j];
//				if(temp > 0){
//					ans[temp] = ans[temp] + 1;
//				}
//			}
//			
//		}
//		
//		
//		
//		for(i = 1; i < n; i++){
//			System.out.println(ans[i]);
//		}
//		

	}
}
