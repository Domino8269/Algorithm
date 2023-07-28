/*
 * ���� 1629��: ����
 * �˰��� �з�: #���� #���� ������ �̿��� �ŵ�����
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(findSquare(A, B));
	}
	// ��͸� �̿��� ��������
	public static long findSquare(int a, int b) {
		long result = 0;
		
		if(b == 1) {
			return a % C;
		}
		// �ŵ������� �� ���� ������� ������
		result = findSquare(a, b/2) % C;
		// ������ Ȧ���� ��� a�� �ѹ� �� ����
		if(b%2 != 0) {
			return (result * result % C) * a % C;
		}
		
		return result * result % C;
	}
}