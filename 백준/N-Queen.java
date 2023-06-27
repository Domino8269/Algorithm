/*
 * 백준 9663번: N-Queen
 * 알고리즘 분류: #백트래킹 #브루트포스
 */
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int N;
	public static int cnt = 0;
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		arr = new int[N];
		
		dfs(0);
		System.out.println(cnt);
	}
	
	public static void dfs(int depth) {
		if(depth==N) {	//마지막 행까지 퀸의 위치가 유효하다면 count를 증가시키고 리턴
			cnt++;
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[depth]=i;
			
			//퀸의 위치가 유효하다면 다음 행으로 이동 (depth는 행을 의미)
			//그렇지 않으면 같은 행의 그 다음 열로 이동
			if(checkQueen(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean checkQueen(int depth) {	//현재 놓인 퀸의 위치가 유효한지 확인
		for(int i=0;i<depth;i++) {
			//같은 열 or 대각선상에 위치하면 false
			if(arr[i]==arr[depth] || Math.abs(arr[depth]-arr[i])== depth-i) {
				return false;
			}
		}
		return true;
	}
}