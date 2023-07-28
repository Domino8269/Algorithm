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
		// '-'�� �������� ���ڿ��� �и�
		String[] arr = str.split("\\-");	
		int[] sumArr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			// ������ �и��� ���ڿ��� �ٽ� '+'�� �������� �и�
			String[] tempArr = arr[i].split("\\+");
			
			int num = 0;
			for(String s : tempArr) {
				// �и��� �� ������ ���� ('+' ���곢���� ��� ����)
				num += Integer.parseInt(s);
			}
			// �ӽ� �迭�� ����
			sumArr[i] = num;
		}
		
		int result = sumArr[0];
		// '-' ������ �������� ������ �� �������� ���� ���������� �� 
		for(int i=1; i<sumArr.length; i++) { 
			result -= sumArr[i];
		}
		
		System.out.println(result);
	}
}
