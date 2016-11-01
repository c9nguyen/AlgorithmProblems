
class UglyNumber {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] dp = new boolean[999999999];
		int[] array = new int[1500 + 1];
		array[1] = 1;
		array[2] = 2;
		array[3] = 3;
		array[4] = 4;
		array[5] = 5;
		int index = 6;
		
		dp[1] = true;
		dp[2] = true;
		dp[3] = true;
		dp[4] = true;
		dp[5] = true;
		
		for (int i = 6; index <= 1500; i++) {
		//	System.out.println(i);
		//	System.out.println("count = " + index);
			if (i % 2 == 0) {
				int small = i / 2;
				dp[i] = dp[small];
			} else {
				if (i % 3 == 0) {
					int small = i / 3;
					dp[i] = dp[small];
				}
				
				if (!dp[i] && i % 5 == 0) {
					int small = i / 5;
					dp[i] = dp[small];
				}
			}
			if (dp[i]) {
				array[index] = i;
				index++;
		//		System.out.println(i);
			}
		}
		
		System.out.println("The 1500'th ugly number is " + array[1500] + "." );
 	}
	
	

}
