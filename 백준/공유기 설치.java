/*
    백준 2110번: 공유기 설치
    알고리즘 분류: #이분 탐색 #매개변수 탐색
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 이분 탐색을 위해 배열을 정렬
        Arrays.sort(arr);

        int lo = 1; // 최소거리 -> 1
        int hi = arr[N-1] - arr[0]; // 최대거리 -> 양쪽 끝 집 사이의 거리

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            // mid 거리를 기준으로 설치 가능한 공유기 개수가 M 보다 작을 때는 hi를 줄임
            if(InstallCnt(mid) < M) {
                hi = mid - 1;
            } else {
                // 설치 가능한 공유기 개수가 M 보다 크거나 같으면
                // 거리를 늘리면서 공유기 사이의 최대거리를 찾음
                lo = mid + 1;
            }
        }
        // lo는 탐색 값을 초과하는 첫 번째 값을 가리키므로,
        // 1을 빼준 값이 조건식을 만족하는 최댓값이 됨
        System.out.println(lo - 1);
    }

    // mid 거리를 기준으로 설치 가능한 공유기 개수를 찾아 반환하는 함수
    public static int InstallCnt(int mid) {
        // 첫 번째 집에 공유기를 설치 (1로 초기화)
        int count = 1;
        // lastNum을 첫 번째 집 좌표로 초기화
        int lastNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curNum = arr[i];

            /*
             *  현재 탐색하는 집(curNum)과 직전에 설치했던(lastNum) 집 사이의 거리가
             *  mid 보다 크거나 같을 때(설치가 가능할 때) 공유기 설치 개수를 늘려주고
             *  마지막 설치 위치(lastNum)를 갱신
             */
            if (curNum - lastNum >= mid) {
                lastNum = curNum;
                count++;
            }
        }
        // 설치 가능한 공유기의 개수를 반환
        return count;
    }
}