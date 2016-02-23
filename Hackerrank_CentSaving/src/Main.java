import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int save = 0;

		HashMap<Set, Integer> combination = new HashMap<Set, Integer>();
		
		
		int items, groups;
		int[] price;
		
		
		items = sc.nextInt();
		groups = sc.nextInt() + 1;
		
		price = new int[items];
		Combine[] com = new Combine[groups];
		
		
		for (int i = 0; i < items; i++) {
			price[i] = sc.nextInt();
		}
		
		for (int i = 0; i < items; i++) {
			
		}
	}
	
	public static class Combine {
		ArrayList<Integer> mArray;
		
		public Combine() {
			mArray = new ArrayList<Integer>();
		}
		
		public void add(int n) {
			mArray.add(n);
		}
		
		public void remove(Integer n) {
			mArray.remove(n);
		}
		
		public int save() {
			int sum = 0, save;
			for (int n : mArray) {
				sum += n;
			}
			
			int round = sum % 10;
			
			if (round <= 4) {
				save = round * -1;
			} else {
				save = 10 - round;
			}
			
			return save;
		}
		

		
		@Override
		public boolean equals(Object other) {
			boolean same = true;
			
			HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
			
			ArrayList<Integer> otherArray = (ArrayList<Integer>) other;
			
			for (Integer n : mArray) {
				hs.put(n, n);
			}
				
			for (int i = 0; i < otherArray.size() && same == true; i++) {
				if (!hs.containsKey(otherArray.get(i))) {
					same = false;
				}
			}
			
			return same;
		}
	}

	
}
