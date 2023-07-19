/*
 * 백준 9935번: 문자열 폭발
 * 알고리즘 분류: #자료구조 #문자열 #스택
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int p=0;	// 스택 포인터
		int cnt=0;
		String s = br.readLine();	
		String c4 = br.readLine();
		char[] arr = new char[s.length()];
		
		for(int i=0; i<s.length(); i++) {
			arr[p]=s.charAt(i);
			if(p>=c4.length()-1) {	// 스택 포인터가 폭발 문자열의 길이를 넘어선다면 폭발 문자열을 포함하는지 검사
				for(int k = 0; k<c4.length();k++) {
					if(arr[p-k]==c4.charAt(c4.length()-(k+1))) {
						cnt++;	// 폭발 문자열과 일치할 때 마다 cnt 증가
					}
				}
				if(cnt==c4.length()) {	// 폭발 문자열의 길이와 cnt가 일치하면 폭발 문자열이 존재하는 것이기 때문에
					p-=c4.length();		// 스택 포인터를 폭발 문자열의 길이만큼 뺌
				}
				cnt=0;
			}
			p++;
		}
		StringBuilder sb = new StringBuilder();
	 
		if(p==0) {
			System.out.println("FRULA");	// 스택 포인터가 0을 가리키면 문자열이 비어있는 것이므로 "FRULA" 출력
		}
		else {
			for(int i=0;i<p;i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		}
				
	}
}



