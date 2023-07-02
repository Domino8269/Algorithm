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
		
		for(int i=2; i<=MAX;i++) {	//�����佺�׳׽��� ü �˰����� �̿��� �Ҽ� �Ǻ�
			if(arr[i]==false) {
				for(int j=2;i*j<=MAX;j++) {
					arr[i*j]=true;
				}
			}
		}
		
		for(int i=N;i<=MAX;i++) {	//�Ҽ��̸鼭 �Ӹ������ �� ���
			if(arr[i]==false && i!=1 && palindrome(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static boolean palindrome(int num) {	//�Ӹ���� �Ǻ�
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