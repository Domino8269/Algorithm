/*
    프로그래머스 Lv2
    Title: 두 큐 합 같게 만들기
 */
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 두 입력 배열을 저장할 큐를 생성
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // 각 큐의 요소 합을 저장할 변수
        long q1Sum = 0;
        long q2Sum = 0;
        // 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수
        int answer = 0;

        // 큐를 채우고 각 큐의 요소 합을 계산
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q1Sum += queue1[i];
            q2.offer(queue2[i]);
            q2Sum += queue2[i];
        }

        for (int i = 0; i < queue1.length * 3; i++) {
            // 두 큐의 요소 합이 같다면, 작업 횟수(answer)를 return
            if (q1Sum == q2Sum) {
                return answer;
            }

            // 첫 번째 큐의 요소 합이 더 큰 경우, q1에서 q2로 요소를 이동
            if (q1Sum > q2Sum) {
                int temp = q1.poll();
                q2.offer(temp);
                q1Sum -= temp;
                q2Sum += temp;
                answer++;
            } else {
                // 두 번째 큐의 요소 합이 더 큰 경우, q2에서 q1으로 요소를 이동
                int temp = q2.poll();
                q1.offer(temp);
                q2Sum -= temp;
                q1Sum += temp;
                answer++;
            }
        }

        // 루프를 종료한 후 균형점을 찾지 못한 경우, -1을 return
        return -1;
    }
}