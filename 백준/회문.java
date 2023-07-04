/*
 * 백준 17609번: 회문
 * 알고리즘 분류: #문자열 #투 포인터
 */
import java.util.Scanner;

public class Main {
	public static char[] arr;
	public static String s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			s = sc.next();
			StringBuffer sb = new StringBuffer(s).reverse();
			
			if(s.equals(String.valueOf(sb))) {	//회문일 경우 0
				System.out.println(0);
			}
			else if (check(0, s.length()-1, 0)) {	//유사회문일 경우 1
				System.out.println(1);
			}
			else {	//둘 다 아닌경우 2
				System.out.println(2);
			}
		}	
		
	}
	
	public static boolean check(int left, int right, int cnt) {	//투 포인터를 이용해 유사회문인지 판별
		if (cnt==2) {	//2번의 재귀호출이 발생하면 유사회문이 될 수 없으므로 false
			return false;
		}
		while(left<=right) {
			if(s.charAt(left)!=s.charAt(right)) {
				boolean a = check(left+1, right, cnt+1);
				boolean b = check(left, right-1, cnt+1);
				if(!a && !b) {
						return false;
				}
				else {
					break;
				}
			}
			left++;
			right--;
		}
		return true;
	}
}