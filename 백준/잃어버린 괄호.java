/*
 * 백준 1541번: 잃어버린 괄호
 * 알고리즘 분류: #수학 #문자열 #그리디
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		// '-'를 기준으로 문자열을 분리
		String[] arr = str.split("\\-");	
		int[] sumArr = new int[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			// 위에서 분리된 문자열을 다시 '+'를 기준으로 분리
			String[] tempArr = arr[i].split("\\+");
			
			int num = 0;
			for(String s : tempArr) {
				// 분리된 각 구간을 더함 ('+' 연산끼리는 모두 더함)
				num += Integer.parseInt(s);
			}
			// 임시 배열에 저장
			sumArr[i] = num;
		}
		
		int result = sumArr[0];
		// '-' 연산을 기준으로 나눠진 각 구간들의 합을 순차적으로 뺌 
		for(int i=1; i<sumArr.length; i++) { 
			result -= sumArr[i];
		}
		
		System.out.println(result);
	}
}
