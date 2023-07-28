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
		// temp에 배열 복사
		int[] temp = arr.clone();
		// 입력받은 배열 정렬
		Arrays.sort(arr);
		// 배열의 모든 요소 순회
		for(int i=0;i<n;i++) {
			// 해시맵에 배열값에 해당하는 키가 존재하지 않으면
			if(!hm.containsKey(arr[i])) {
				// 현재 count를 값으로 추가하고 count를 증가시킴(해시맵의 특성으로 중복된 키 값은 추가되지 않음)
				hm.put(arr[i], cnt++);
			}
		}
		for(int i=0;i<n;i++) {
			// 처음 입력받은 순서대로 출력해야 하므로 temp 배열에 저장된 값 순서대로 StringBuilder에 추가
			sb.append(hm.get(temp[i])).append(" ");
		}
		System.out.println(sb);	
	}
}


