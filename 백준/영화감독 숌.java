/*
 * 백준 1436번: 영화감독 숌
 * 알고리즘 분류: #브루트포스
 */
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int count=1;
		int num=666;
		
		while(N!=count) {
			num++;
			if(String.valueOf(num).contains("666")) {
				count++;
			}
		}
		System.out.println(num);
	}
}