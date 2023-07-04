/*
 * ���� 17609��: ȸ��
 * �˰��� �з�: #���ڿ� #�� ������
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
			
			if(s.equals(String.valueOf(sb))) {	//ȸ���� ��� 0
				System.out.println(0);
			}
			else if (check(0, s.length()-1, 0)) {	//����ȸ���� ��� 1
				System.out.println(1);
			}
			else {	//�� �� �ƴѰ�� 2
				System.out.println(2);
			}
		}	
		
	}
	
	public static boolean check(int left, int right, int cnt) {	//�� �����͸� �̿��� ����ȸ������ �Ǻ�
		if (cnt==2) {	//2���� ���ȣ���� �߻��ϸ� ����ȸ���� �� �� �����Ƿ� false
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