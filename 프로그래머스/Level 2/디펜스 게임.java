/**
 * 프로그래머스 Lv2
 * Title: 디펜스 게임
 */

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int cost = n;
        for (int i = 0; i < enemy.length; i++) {
            if (cost - enemy[i] >= 0) {
                cost -= enemy[i];
                pq.add(enemy[i]);
                answer++;
            } else if (k <= 0) {
                break;
            } else if (pq.isEmpty() || pq.peek() < enemy[i]) {
                k--;
                answer++;
            } else {
                k--;
                answer++;
                cost = cost + pq.poll() - enemy[i];
                pq.add(enemy[i]);
            }
        }

        return answer;
    }
}

