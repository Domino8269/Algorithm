/*
 * 백준 9095번: 1, 2, 3 더하기
 * 알고리즘 분류: #dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;	// 1, 2, 3을 이용해 1을 만들 수 있는 경우의 수 
		dp[2] = 2;	//		''		  2을 만들 수 있는 경우의 수 
		dp[3] = 4;	// 		''		  3을 만들 수 있는 경우의 수 
			
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(find(n));
		}
	}
	
	public static int find(int n) {	
		if(n <= 3) {
			return dp[n];
		}
		if(dp[n]==0) {									// n을 1, 2, 3의 합으로 나타내는 경우의 수는 
			dp[n] = find(n-3) + find(n-2) + find(n-1);	// 이전 3개의 경우의 수를 합한 값임 
		}
		return dp[n];
	}
}