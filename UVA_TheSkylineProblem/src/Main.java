
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] arg) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input2.txt"));
		int[] coordinate = new int[10000 + 1];
		int last = 0;
		while (sc.hasNextInt()) {
			int count = 0;
			int[] skyline = new int[3];
			while (count < 3) {
				skyline[count] = sc.nextInt();
				count++;
			}
			
			last = Math.max(last, skyline[2]);
			
			for (int i = skyline[0]; i < skyline[2]; i++) {
				if (coordinate[i] < skyline[1]) {
					coordinate[i] = skyline[1];
				} 				
			}

		}
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int current = 0;
		for (int i = 0; i < last && start == 0; i++) {
			if (coordinate[i] > 0) {
				start = i;
				current = coordinate[i];
				sb.append(start + " ");
				sb.append(current);
			}
			
		}

		for (int i = start; i <= last ; i ++) {
			if (coordinate[i] != current) {
				sb.append(" " + i + " ");
				sb.append(coordinate[i]);
				current = coordinate[i];
			}
		}
		System.out.print(sb.toString());
	
	}
}
