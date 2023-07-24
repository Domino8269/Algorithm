/*
 * ���� 1541��: �Ҿ���� ��ȣ
 * �˰��� �з�: #���� #���ڿ� #�׸���
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		String[] arr = str.split("\\-");		// '-'�� �������� ���ڿ��� �и�
		int[] sumArr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			String[] tempArr = arr[i].split("\\+");		// ������ �и��� ���ڿ��� �ٽ� '+'�� �������� �и�
			
			int num = 0;
			for(String s : tempArr) {
				num += Integer.parseInt(s);	// �и��� �� ������ ���� ('+' ���곢���� ��� ����)
			}
			
			sumArr[i] = num;	// �ӽ� �迭�� ����
		}
		
		int result = sumArr[0];
		for(int i=1; i<sumArr.length; i++) {	// '-' ������ �������� ������ �� �������� ���� ���������� �� 
			result -= sumArr[i];
		}
		
		System.out.println(result);
	}
}
