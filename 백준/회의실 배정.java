/*
 * 백준 1931번: 회의실 배정
 * 알고리즘 분류: #정렬 #그리디 알고리즘
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2]; // time[N][0] -> 시작시간 / time[N][1] -> 종료시간
				
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (start, end) -> start[1] == end[1] ? start[0] - end[0] : start[1] - end[1]);	// 끝나는 시간 기준으로 오름차순 정렬
        int end = -1;																					// 끝나는 시간이 같으면 시작 시간 기준으로 오름차순 정렬
        int cnt = 0;
        for (int i = 0; i < time.length; i++) {
            if (end <= time[i][0]) {	// 회의 시작시간이 마지막 회의 종료시간(end)보다 크거나 같으면(회의 시작이 가능하면)
                end = time[i][1];		// 마지막 회의 종료시간(end)을 현재 회의 종료시간으로 변경
                cnt++;					// 회의 횟수(cnt) 증가
            }
        }
        System.out.println(cnt);
	}
}