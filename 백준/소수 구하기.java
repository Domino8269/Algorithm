/*
 * 백준 1929번 -> 소수 구하기
 * 알고리즘 분류 -> #수학  #정수론 #소수 판정 #에라토스테네스의 체
 */
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] arr = new boolean[M+1];
		
		for(int i=2; i<=M;i++) {
			if(arr[i]==false) {
				for(int j=2;i*j<=M;j++) {
					arr[i*j]=true;
				}
			}
		}
		
		for(int i=N;i<=M;i++) {
			if(arr[i]==false && i!=1) {
				System.out.println(i);
			}
		}
	}
}