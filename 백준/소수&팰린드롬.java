/*
 * 백준 1747번: 소수&팰린드롬
 * 알고리즘 분류: #수학 #브루트포스 #정수론 #소수 판정
 */
import java.util.Scanner;

public class Main {
	public static final int MAX = 10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] arr = new boolean[MAX+1];
		
		for(int i=2; i<=MAX;i++) {	//에라토스테네스의 체 알고리즘을 이용한 소수 판별
			if(arr[i]==false) {
				for(int j=2;i*j<=MAX;j++) {
					arr[i*j]=true;
				}
			}
		}
		
		for(int i=N;i<=MAX;i++) {	//소수이면서 팰린드롬인 수 출력
			if(arr[i]==false && i!=1 && palindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean palindrome(int num) {	//팰린드롬 판별
		int tmp=num;
		String s="";
		
		while(tmp!=0) {
			s=s+(tmp%10);
			tmp=tmp/10;
		}
		tmp=Integer.valueOf(s);
		
		if(tmp==num) {
			return true;
		}
		else {
			return false;
		}
	}
}