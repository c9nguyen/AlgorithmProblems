import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		boolean dry = false;
		int driedStep = 0;
		int steps = 1;
		int[] current = new int[2];
		
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		
		char[][] map = new char[h][w];
		current[0] = h - 1;
		current[1] = 0;
		
		for (int i = 0; i < h; i++) {
			String scan = sc.next();
			map[i] = scan.toCharArray();
		}
		
		if (map[h - 1][0] == '.') {
			dry = true;
			driedStep = steps;
		}
		
		for (int i = 0; i < n; i++) {
			String dir = sc.next();
			int step = sc.nextInt();
			
			switch (dir) {
				case "up":
					for (int j = 0; j < step; j++) {
						current[0]--;
						steps++;
			
						if (map[current[0]][current[1]] == '.' && !dry) {
							driedStep = steps - 1;
						}
					}
					break;
				case "down":
					for (int j = 0; j < step; j++) {
						current[0]++;
						steps++;
						if (map[current[0]][current[1]] == '.' && !dry) {
							driedStep = steps - 1;
						}
					}
					break;
				case "right":
					for (int j = 0; j < step; j++) {
						current[1]++;
						steps++;
						if (map[current[0]][current[1]] == '.' && !dry) {
							driedStep = steps - 1;
						}
					}
					break;
				case "left":
					for (int j = 0; j < step; j++) {
						current[1]--;
						steps++;
						if (map[current[0]][current[1]] == '.' && !dry) {
							driedStep = steps - 1;
						}
					}
					break;
			}
		}

		System.out.println(driedStep);
	}
	

}
