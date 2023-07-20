/*
 * ���� 11404��: �÷��̵�
 * �˰��� �з�: #�׷��� �̷� #�÷��̵�-����
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 1_000_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] ad = new int[n+1][n+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) { 	// �ڱ� �ڽ����� ���� ���� 0
					ad[i][j] = 0;
					continue;
				}
				
				ad[i][j] = MAX;	// �� ���� ���� N���� ��带 ��� ���ļ� ������ �� ū ��
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ad[a][b] = Math.min(c, ad[a][b]);	// �뼱�� �������� ���� �� �����Ƿ� �� ���������� �ʱ�ȭ
		}
		
		for(int mid = 1; mid <= n; mid++) {	// �÷��̵�-���� �˰������� ��� ��尣 �ִܰŸ��� ����
			for(int i = 1; i <=n; i++) {
				for(int j = 1; j <=n; j++) {
					ad[i][j] = Math.min(ad[i][j], ad[i][mid] + ad[mid][j]);
				}
			}
		}
		
		for(int i = 1; i <=n; i++) {
			for(int j = 1; j <=n; j++) {
				if(ad[i][j] == MAX) {
					System.out.print(0+" ");
				}
				else {
					System.out.print(ad[i][j] + " ");
				}
			}
			System.out.println();
		}		
	}
}


