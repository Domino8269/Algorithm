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
		
		if(N>=3 && M>=7) {	// 4���� �̵������ ��� ����� �� �ִ� �ּ����� ũ�⸦ �ѱ� ���
			result = 5 + M-7;
		}
		else {
			if(N==1) {	// ���ΰ� 1ĭ�� ���
				result = 1;
			}
			else if(N==2) {	// ���ΰ� 2ĭ�� ���
				result = (M-1)/2+1;
			}
			else if(N>=3) {	// ���ΰ� 3ĭ �̻��� ���
				result = M;
			}
			if(result >= 4) {	// 4���� �̵������ ��� ������� ������ 4ĭ �̻� �̵��� �� ���� ������ max���� 4
				result = 4;
			}
		}
		
		System.out.println(result);
	}
}


