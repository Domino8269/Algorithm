/*
    프로그래머스 Lv2
    Title: 시소 짝꿍
 */
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;

        // 몸무게 목록을 저장할 해시맵
        HashMap<Double, Integer> hm = new HashMap<>();
        Arrays.sort(weights);

        // 몸무게 목록이 담긴 배열을 정렬 후 순서대로 시소 짝꿍이 몇 쌍인지 확인
        for (double num : weights) {
            if (hm.containsKey(num)) {
                answer += hm.get(num);
            }
            if (hm.containsKey(num / 2.0)) {
                answer += hm.get(num / 2.0);
            }
            if (hm.containsKey(num * 2.0 / 3.0)) {
                answer += hm.get(num * 2.0 / 3.0);
            }
            if (hm.containsKey(num * 3.0 / 4.0)) {
                answer += hm.get(num * 3.0 / 4.0);
            }
            hm.put((num), hm.getOrDefault((num), 0)+1);
        }

        return  answer;
    }
}