import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		Set<Integer> a = new HashSet<Integer>();
		Set<Integer> b = new HashSet<Integer>();
		
		a.add(2);
		a.add(2);
		b.add(2);
	

		
		HashMap<Set, Integer> hs = new HashMap<Set, Integer>();
		hs.put(a, 2);
		System.out.println(hs.containsKey(b));
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
			
			Combine otherArray = (Combine) other;
			
			for (Integer n : mArray) {
				hs.put(n, n);
			}
				
			for (int i = 0; i < otherArray.mArray.size() && same == true; i++) {
				if (!hs.containsKey(otherArray.mArray.get(i))) {
					same = false;
				}
			}
			
			return same;
		}
	}
}