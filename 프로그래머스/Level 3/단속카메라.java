/**
 *  프로그래머스 Lv3
 *  Title: 단속카메라
 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        int endPoint = Integer.MIN_VALUE;

        // 진출 지점을 기준으로 routes 배열 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > endPoint) {
                // 현재 차량의 진입 지점이 endPoint보다 큰 경우,
                // 새로운 카메라를 설치하고 endPoint를 업데이트
                endPoint = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}