/*
 * 백준 1629번: 곱셈
 * 알고리즘 분류: #수학 #분할 정복을 이용한 거듭제곱
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(findSquare(A, B));
	}
	// 재귀를 이용한 분할정복
	public static long findSquare(int a, int b) {
		long result = 0;
		
		if(b == 1) {
			return a % C;
		}
		// 거듭제곱을 더 작은 문제들로 분할함
		result = findSquare(a, b/2) % C;
		// 지수가 홀수인 경우 a를 한번 더 곱함
		if(b%2 != 0) {
			return (result * result % C) * a % C;
		}
		
		return result * result % C;
	}
}