/*
 * 백준 11729번: 하노이 탑 이동 순서
 * 알고리즘 분류: #재귀
 */
import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');	//옮긴 횟수 추가
		hanoi(N, 1, 3, 2);
		System.out.println(sb);
		
	}
	public static void hanoi(int N, int start, int end, int temp) {	//재귀함수를 이용해 수행과정 출력
		if (N==1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		hanoi(N-1,start,temp,end);
		sb.append(start + " " + end + "\n");
		hanoi(N-1,temp,end,start);
	}
}