/*
 * ���� 10844��: ���� ��� ��
 * �˰��� �з�: #dp
 */
import java.io.*;

public class Main { 
	static long[][] dp;
	static int N;
	static long mod = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long result = 0;
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1][10];
		// ���ڸ����� �� 1�� �ʱ�ȭ
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		// ���̰� N�� ���� ���� ù ��° ���� 0~9�϶� ����� ���� ��� ����
		for (int i = 0; i <= 9; i++) {
			result+=stair(N, i);
		}
		
		System.out.println(result%mod);
	}
	
	public static long stair(int N, int i) {
		if(N==1) {
			// ���ڸ����� ��� ����
			return dp[N][i];
		}
		
		if(dp[N][i] == 0) {
			if (i == 0)
				// N�� 0�ϰ�� ���ڸ� ���� 1
				dp[N][i] = stair(N-1,1);
			else if (i == 9)
				// N�� 9�ϰ�� ���ڸ� ���� 8
				dp[N][i] = stair(N-1,8);
			else {
				// �� ���� ���� i-1, i+1 �� �� �ü�����
				dp[N][i] = stair(N-1,i-1)+stair(N-1,i+1);
			}
		}
		
		return dp[N][i]%mod;
	}
}








