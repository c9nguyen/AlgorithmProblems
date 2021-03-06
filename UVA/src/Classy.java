import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Classy {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			int num = sc.nextInt();
			sc.nextLine();
			Person[] list = new Person[num];
			int index = 0;
			while (index < num) {
				String line = sc.nextLine();
				String[] level = line.split(" ");
				list[index] = new Person(level);

				index++;
			}
			Arrays.sort(list);

			for (Person person : list) {
				sb.append(person.name);
				sb.append("\n");
			}
		}
		System.out.print(sb.toString());
//		String string = sb.toString();
//		System.out.print(string.substring(0, string.length() - 1));
	}
	
	public static class Person implements Comparable<Person>{
		String name;
		String level;
		int count = 0;
		
		public Person(String[] line) {
			name = line[0].substring(0, line[0].length() - 1);
			level = "";
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < line.length - 1; i++) {
//				level *= 10;
//				int num = line[i].equals("upper") ? 3 : line[i].equals("middle") ? 2 : 1;			
//				level += num;
				count++;
				char c = line[i].equals("upper") ? '3' : line[i].equals("middle") ? '2' : '1';
				sb.append(c);
			}
			level = sb.toString();
		}

		@Override
		public int compareTo(Person other) {
			// TODO Auto-generated method stub
			int compare = 0;
			String stemp1 = this.level;
			String stemp2 = other.level;
			int tempCount1 = this.count;
			int tempCount2 = other.count;
			StringBuilder sb = new StringBuilder();
			while (tempCount1 < tempCount2) {
				sb.append('2');
				tempCount1++;
			}
			stemp1 = sb.toString() + stemp1;
			
			sb = new StringBuilder();
			while (tempCount2 < tempCount1) {
				sb.append('2');
				tempCount2++;
			}
			stemp2 = sb.toString() + stemp2;
			
			for (int i = stemp1.length() - 1; i >= 0 && compare == 0; i--) {
				if (stemp1.charAt(i) > stemp2.charAt(i)) 
					compare = -1;
				else if (stemp1.charAt(i) < stemp2.charAt(i)) 
					compare = 1;
	
			}
			
			
//			while (temp1 > 0 && temp2 > 0 && compare == 0) {
//				if (temp1 % 10 > temp2 % 10) 
//					compare = -1;
//				else if (temp1 % 10 < temp2 % 10)
//					compare = 1;
//				else {
//					temp1 /= 10;
//					temp2 /= 10;
//				}				
//			}
			
//			while (temp1 > 0 && compare == 0) {
//				if (temp1 % 10 > 2) {
//					compare = -1;
//				} else if (temp1 % 10 < 2) {
//					compare = 1;
//				} else {
//					temp1 /= 10;
//				}
//			}
//			
//			while (temp2 > 0 && compare == 0) {
//				if (temp2 % 10 > 2) {
//					compare = 1;
//				} else if (temp2 % 10 < 2) {
//					compare = -1;
//				} else {
//					temp2 /= 10;
//				}
//			}
			
			if (compare == 0) {
				compare = name.compareTo(other.name);
			}
			
			return compare;
		}
		
		
		
	}
	
}
