/*
 * ���� 4948��: ����Ʈ�� ����
 * �˰��� �з�: #���� #�Ҽ� ���� #�����佺�׳׽��� ü
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
    	while(true) {
    		int N = Integer.parseInt(br.readLine());
    		int cnt = 0;
    		// 0�� �ԷµǸ� ����
    		if(N == 0) {
    			break;
    		}
    		
    		boolean[] arr = new boolean[2*N+1];
    		// �����佺�׳׽��� ü �˰����� �̿��� N���� 2N������ ������ �Ҽ��� ã��
    		for(int i = 2; i <= 2*N; i++) {
    			if(arr[i]==false) {
    				for(int j = 2; i * j <= 2 * N; j++) {
    					arr[i*j]=true;
    				}
    			}
    		}
    		
    		for(int i = N+1; i <= 2*N; i++) {
    			if(arr[i]==false && i!=1) {
    				cnt++;
    			}
    		}
    		
    		System.out.println(cnt);
    	}
    }
}