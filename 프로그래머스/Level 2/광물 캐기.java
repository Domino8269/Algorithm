/**
 *  프로그래머스 Lv2
 *  Title - 광물 캐기
 */
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalCnt = minerals.length / 5 + (minerals.length % 5 == 0 ? 0 : 1);
        int[][] cost = new int[totalCnt][4];

        for (int i = 0; i < totalCnt; i++) {
            int diamond = 0;
            int iron = 0;
            int stone = 0;
            int sectionCnt = 5;
            if (minerals.length % 5 != 0 && i == totalCnt - 1) {
                sectionCnt = minerals.length % 5;
            }
            for (int j = 0; j < sectionCnt; j++) {
                if (minerals[i * 5 + j].equals("diamond")) {
                    diamond += 1;
                    iron += 5;
                    stone += 25;
                } else if (minerals[i * 5 + j].equals("iron")) {
                    diamond += 1;
                    iron += 1;
                    stone += 5;
                } else {
                    diamond += 1;
                    iron += 1;
                    stone += 1;
                }
            }
            cost[i][0] = diamond;
            cost[i][1] = iron;
            cost[i][2] = stone;
        }

        int picksNum = picks[0] + picks[1] + picks[2];
        if (picksNum < totalCnt) {
            for (int i = picksNum; i < totalCnt; i++) {
                cost[picksNum][3] = -1;
            }
        }
        Arrays.sort(cost, Comparator.comparingInt((int[] o) -> o[2]).reversed());

        for (int i = 0; i < totalCnt; i++) {
            if (cost[i][3] == -1) {
                continue;
            }
            if (picks[0] > 0) {
                answer += cost[i][0];
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += cost[i][1];
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += cost[i][2];
                picks[2]--;
            } else {
                break;
            }
        }

        return answer;
    }
}