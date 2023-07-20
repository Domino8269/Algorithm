/*
 * 백준 11404번: 플로이드
 * 알고리즘 분류: #그래프 이론 #플로이드-워셜
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
				if (i == j) { 	// 자기 자신한테 가는 경우는 0
					ad[i][j] = 0;
					continue;
				}
				
				ad[i][j] = MAX;	// 그 외의 경우는 N개의 노드를 모두 거쳐서 가더라도 더 큰 값
			}
		}
		
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			ad[a][b] = Math.min(c, ad[a][b]);	// 노선이 여러개가 있을 수 있으므로 더 작은값으로 초기화
		}
		
		for(int mid = 1; mid <= n; mid++) {	// 플로이드-워셜 알고리즘으로 모든 노드간 최단거리를 구함
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


