/*
 * 백준 1992번: 쿼드트리
 * 알고리즘 분류: #재귀 #분할정복
 */
import java.io.*;

public class Main { 
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		quadTree(N,0,0);
		System.out.println(sb);
	}
	
	public static void quadTree(int N, int row, int column) {
		boolean state = true;
		int color = map[row][column];
		// 0 혹은 1로 압축할 수 있는지 확인
		for(int i=row;i<row+N;i++) {
			for(int j=column;j<column+N;j++) {
				if(map[i][j]!=color) {
					state=false;
				}
			}
		}
		// 압축이 가능하다면 압축한 결과를 추가함
		if(state) {
			sb.append(map[row][column]);
		}
		// 압축이 불가능하다면 각 영역별로 4번 재귀호출
		else {
			sb.append('(');
			quadTree(N/2, row, column);
			quadTree(N/2, row, column+N/2);
			quadTree(N/2, row+N/2, column);
			quadTree(N/2, row+N/2, column+N/2);
			sb.append(')');
		}
		
		return;
	}
}