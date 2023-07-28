/*
 * ���� 1932��: ���� �ﰢ��
 * �˰��� �з�: #dp
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Integer[][] arr;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new Integer[n+1][n+1];
		dp = new Integer[n+1][n+1];
		
		for(int i=1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<= n; j++) {
				if(st.hasMoreTokens()) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				else {
					arr[i][j] = 0;
				}
			}
		}
		
		int maxSum = -1;
		// �迭�� ������ ��(�ﰢ���� ��������)�� ��ȸ�ϸ鼭 ���� �ִ��� ������ ã��
		for(int i = 1; i <= n; i++) {
			int temp = findMax(n, i);
			if(temp > maxSum) {
				maxSum = temp;
			}
		}
		
		System.out.println(maxSum);
	}
	
	public static int findMax(int row, int col) {	
		if(col == 0) {
			return 0;
		}
		else if (row == 1) {
			return arr[1][1];
		}
		else if(dp[row][col] == null) {
			// �ش� ������ �ִ��� ���ϱ� (���)
			dp[row][col] = Math.max(findMax(row-1, col), findMax(row-1, col-1)) + arr[row][col];
		}
		return dp[row][col];
	}
}