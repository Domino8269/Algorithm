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
		
		for (int i = 1; i <= 9; i++) {	// ���ڸ����� �� 1�� �ʱ�ȭ
            dp[1][i] = 1;
        }
		
		for (int i = 0; i <= 9; i++) {	// ���̰� N�� ���� ���� ù ��° ���� 0~9�϶� ����� ���� ��� ����
            result+=stair(N, i);
        }
		System.out.println(result%mod);
	}
	
	public static long stair(int N, int i) {
		if(N==1) {
			return dp[N][i];	// ���ڸ����� ��� ����
		}
		
		if(dp[N][i] == 0) {
			if (i == 0)
                dp[N][i] = stair(N-1,1);	// N�� 0�ϰ�� ���ڸ� ���� 1
            else if (i == 9)
                dp[N][i] = stair(N-1,8);	// N�� 9�ϰ�� ���ڸ� ���� 8
            else
                dp[N][i] = stair(N-1,i-1)+stair(N-1,i+1); // �� ���� ���� i-1, i+1 �� �� �ü�����
		}
		return dp[N][i]%mod;
	}
}








