import java.util.HashSet;

// AI to solve PlusNo game
// Problem, cant run above 10
// Need a better algorithm

public class Solution {
	static int count;

	static int[][][] dp;
	
	static HashSet<String> hm = new HashSet<String>();
	
	public static void main (String[] args) {
		int[][] table = {{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}};
		int level = 15;
		
		dp = new int[3][3][level];
		
//		print(solve(table, 9));
//		System.out.println("count: " + count);
//		print(table);
		
//		int[][] table2 = solve(table, level);
//		print(table2);
//		System.out.println(toKey(table2));
		System.out.println(check(solve(table, level), level));
//		System.out.println("count: " + count);


	}

	static int[][] solve(int[][] table, int level) {
		int nextX, nextY;
		count++;
		int[][] returnTable;
		count++;

		// Run through every locations to check possible moves
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j] < level) {		//If the location hasn't reached max level
	//				System.out.println("Check");
					
					//Check all location around
					for (int addY = -1; addY <= 1; addY++) {
						for (int addX = - 1; addX <= 1; addX++) {
							if (addY != 0 || addX != 0) {
								

								//For each move
								nextX = j + addX;		// 
								nextY = i + addY;		// Next move
								if (nextX >= 0 && nextX < table.length &&
										nextY >= 0 && nextY < table.length &&
										table[nextY][nextX] + table[i][j] <= level ) {		//Check if next move is legit
									int temp1, temp2;
									
//									returnTable = table.clone();
					
									
									temp1 = table[i][j];
									temp2 = table[nextY][nextX];
									
									table[nextY][nextX] += table[i][j];
									table[i][j]++;	
									
//									print(table);
//									System.out.println();
								
							
									
						
									if (!hm.contains(toKey(table)) && check(solve(table, level), level)) {
										return table;
									} else {
										hm.add(toKey(table));
										table[i][j] = temp1;
										table[nextY][nextX] = temp2;
									}
								}
							}
						}
					}					
				}
			}
		}			

		return table;
	}

	
	static String toKey(int[][] table) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				sb.append(table[i][j]);

			}
		}

		return sb.toString();
	}
	
	static boolean check(int[][] table, int level) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (table[i][j] != level) return false;
			}
		}

		return true;
	}
	
	static void print(int[][] table) {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
