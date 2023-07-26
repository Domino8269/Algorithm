/*
 * ���� 9095��: 1, 2, 3 ���ϱ�
 * �˰��� �з�: #dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		dp[1] = 1;	// 1, 2, 3�� �̿��� 1�� ���� �� �ִ� ����� �� 
		dp[2] = 2;	//		''		  2�� ���� �� �ִ� ����� �� 
		dp[3] = 4;	// 		''		  3�� ���� �� �ִ� ����� �� 
			
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(find(n));
		}
	}
	
	public static int find(int n) {	
		if(n <= 3) {
			return dp[n];
		}
		if(dp[n]==0) {									// n�� 1, 2, 3�� ������ ��Ÿ���� ����� ���� 
			dp[n] = find(n-3) + find(n-2) + find(n-1);	// ���� 3���� ����� ���� ���� ���� 
		}
		return dp[n];
	}
}