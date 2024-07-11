/**
 * 프로그래머스 Lv2
 * Title - 요격 시스템
 */

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int endPoint = 0;
        for (int i = 0; i < targets.length; i++) {
            if (endPoint > targets[i][0]) continue;
            endPoint = targets[i][1];
            answer++;
        }

        return answer;
    }
}