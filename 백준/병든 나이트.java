/*
 * ���� 1783��: ���� ����Ʈ
 * �˰��� �з�: #���� #�׸��� �˰���
 */

import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int result = 0;
		// 4���� �̵������ ��� ����� �� �ִ� �ּ����� ũ�⸦ �ѱ� ���
		if(N>=3 && M>=7) {
			result = 5 + M-7;
		}
		else {
			// ���ΰ� 1ĭ�� ���
			if(N==1) {
				result = 1;
			}
			// ���ΰ� 2ĭ�� ���
			else if(N==2) {
				result = (M-1)/2+1;
			}
			// ���ΰ� 3ĭ �̻��� ���
			else if(N>=3) {
				result = M;
			}
			// 4���� �̵������ ��� ������� ������ 4ĭ �̻� �̵��� �� ���� ������ max���� 4
			if(result >= 4) {
				result = 4;
			}
		}
		
		System.out.println(result);
	}
}


