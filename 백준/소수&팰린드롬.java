/*
 * ���� 1747��: �Ҽ�&�Ӹ����
 * �˰��� �з�: #���� #���Ʈ���� #������ #�Ҽ� ����
 */
import java.util.Scanner;

public class Main {
	public static final int MAX = 10000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		boolean[] arr = new boolean[MAX+1];
		// �����佺�׳׽��� ü �˰����� �̿��� �Ҽ� �Ǻ�
		for(int i=2; i<=MAX;i++) {
			if(arr[i]==false) {
				for(int j=2;i*j<=MAX;j++) {
					arr[i*j]=true;
				}
			}
		}
		// �Ҽ��̸鼭 �Ӹ������ �� ���
		for(int i=N;i<=MAX;i++) {
			if(arr[i]==false && i!=1 && palindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	// �Ӹ���� �Ǻ�
	public static boolean palindrome(int num) {
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