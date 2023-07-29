/*
 * 백준 4948번: 베르트랑 공준
 * 알고리즘 분류: #수학 #소수 판정 #에라토스테네스의 체
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
    		// 0이 입력되면 종료
    		if(N == 0) {
    			break;
    		}
    		
    		boolean[] arr = new boolean[2*N+1];
    		// 에라토스테네스의 체 알고리즘을 이용해 N부터 2N까지의 구간의 소수를 찾음
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