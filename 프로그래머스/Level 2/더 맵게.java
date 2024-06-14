/**
 * 프로그래머스 Lv2
 * Title - 더 맵게
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }

        while (!pq.isEmpty()) {
            if (pq.peek() < K) {
                if (pq.size() < 2) {
                    pq.poll();
                    break;
                }
                pq.offer(mix(pq.poll(), pq.poll()));
                answer++;
            } else {
                break;
            }
        }

        if (pq.isEmpty()) {
            answer = -1;
        }

        return answer;
    }

    public static int mix(int num1, int num2) {
        return num2 * 2 + num1;
    }
}