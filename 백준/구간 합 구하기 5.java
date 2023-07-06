/*
 * 백준 11660번: 구간 합 구하기 5
 * 알고리즘 분류: #누적합 #dp
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken())+1;
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		int[][] psum = new int[N][N];
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<N;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + arr[i][j];
			}
		}
	
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			System.out.println(psum[x2][y2]-psum[x2][y1-1]-psum[x1-1][y2]+psum[x1-1][y1-1]);
		}	
	}
}