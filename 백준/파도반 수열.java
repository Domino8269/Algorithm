/*
 * 백준 9461번: 파도반 수열
 * 알고리즘 분류: #수학 #dp
 */
import java.io.*;

public class Main { 
	static long[] dp = new long[101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			System.out.println(dp(Integer.parseInt(br.readLine())));
		}
		
	}
	
	public static long dp(int n) {
		if(n<=5) {
			dp[n]= n<=3?1:2;
			return dp[n];
		}
		else {
			if(dp[n]>0) {
				return dp[n];
			}
			dp[n] = dp(n-1)+dp(n-5);
			return dp[n];
		}
	}
}








