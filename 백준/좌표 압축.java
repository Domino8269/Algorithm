/*
 * 백준 18870번: 좌표 압축
 * 알고리즘 분류: #정렬 #값/좌표 압축
 */

import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
	
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			
		}
		int[] temp = arr.clone();	// temp에 배열 복사
		Arrays.sort(arr);	// 입력받은 배열 정렬
		
		for(int i=0;i<n;i++) {	// 배열의 모든 요소 순회
			if(!hm.containsKey(arr[i])) {	// 해시맵에 배열값에 해당하는 키가 존재하지 않으면
				hm.put(arr[i], cnt++);	// 현재 count를 값으로 추가하고 count를 증가시킴
			}							// 해시맵의 특성으로 중복된 키 값은 추가되지 않음
		}
		for(int i=0;i<n;i++) {
			sb.append(hm.get(temp[i])).append(" ");	// 처음 입력받은 순서대로 출력해야 하므로
		}											// temp 배열에 저장된 값 순서대로 StringBuilder에 추가
		System.out.println(sb);	
	}
}


