/**
 * 프로그래머스 Lv2
 * Title: 의상
 */

import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hm = new HashMap<>();

        for (String[] clothe : clothes) {
            hm.put(clothe[1], hm.getOrDefault(clothe[1], 0) + 1);
        }

        for (String key : hm.keySet()) {
            answer *= (hm.get(key) + 1);
        }

        return answer - 1;
    }
}