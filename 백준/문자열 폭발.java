/*
 * ���� 9935��: ���ڿ� ����
 * �˰��� �з�: #�ڷᱸ�� #���ڿ� #����
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int p=0;	// ���� ������
		int cnt=0;
		String s = br.readLine();	
		String c4 = br.readLine();
		char[] arr = new char[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			arr[p]=s.charAt(i);
			if(p>=c4.length()-1) {	// ���� �����Ͱ� ���� ���ڿ��� ���̸� �Ѿ�ٸ� ���� ���ڿ��� �����ϴ��� �˻�
				for(int k = 0; k<c4.length();k++) {
					if(arr[p-k]==c4.charAt(c4.length()-(k+1))) {
						cnt++;	// ���� ���ڿ��� ��ġ�� �� ���� cnt ����
					}
				}
				if(cnt==c4.length()) {	// ���� ���ڿ��� ���̿� cnt�� ��ġ�ϸ� ���� ���ڿ��� �����ϴ� ���̱� ������
					p-=c4.length();		// ���� �����͸� ���� ���ڿ��� ���̸�ŭ ��
				}
				cnt=0;
			}
			p++;
		}
		StringBuilder sb = new StringBuilder();
	 
		if(p==0) {
			System.out.println("FRULA");	// ���� �����Ͱ� 0�� ����Ű�� ���ڿ��� ����ִ� ���̹Ƿ� "FRULA" ���
		}
		else {
			for(int i=0;i<p;i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}
				
	}
}



