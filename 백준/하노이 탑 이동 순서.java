/*
 * ���� 11729��: �ϳ��� ž �̵� ����
 * �˰��� �з�: #���
 */
import java.util.Scanner;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sb.append((int) (Math.pow(2, N) - 1)).append('\n');	//�ű� Ƚ�� �߰�
		hanoi(N, 1, 3, 2);
		System.out.println(sb);
		
	}
	public static void hanoi(int N, int start, int end, int temp) {	//����Լ��� �̿��� ������� ���
		if (N==1) {
			sb.append(start + " " + end + "\n");
			return;
		}
		hanoi(N-1,start,temp,end);
		sb.append(start + " " + end + "\n");
		hanoi(N-1,temp,end,start);
	}
}