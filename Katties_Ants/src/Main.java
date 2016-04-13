import java.util.Scanner;

public class Main{
    public static void main(String[] arg) {
        int cases, ants, pole, min = 0, max = 0, mid;
        
        Scanner sc = new Scanner(System.in);
        
        cases = sc.nextInt();
        
        while (cases > 0) {
        	pole = sc.nextInt();
        	mid = pole / 2;
        	min = 1000000;
        	max = 0;
        	ants = sc.nextInt();
        	
        	while (ants > 0) {
        		int num = sc.nextInt();
  //      		System.out.println("mid: " + Math.abs(mid - num));
        		if (Math.abs(mid - num) < Math.abs(mid - min)){
        			min = num;

        		}
        		
        		if (pole - num > max || num > max) {
        			max = Math.max(pole - num, num);
        		}
        		
        		ants--;
        	}
        	System.out.println(Math.min(min, pole - min) + " " + max);
        	
        	cases--;
        }
    }
}