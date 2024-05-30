/**
 * 프로그래머스 Lv2
 * Title: 롤케이크 자르기
 */

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] checkNum = new int[10001];
        int[] leftToppingNum = new int[topping.length];

        int toppingKind = 0;

        for (int i = 0; i < topping.length; i++) {
            if (checkNum[topping[i]] == 0) {
                toppingKind++;
            }
            checkNum[topping[i]]++;
            leftToppingNum[i] = toppingKind;
        }

        for (int i = 0; i < topping.length; i++) {
            checkNum[topping[i]]--;
            if (checkNum[topping[i]] == 0) {
                toppingKind--;
            }

            if (leftToppingNum[i] == toppingKind) {
                answer++;
            }
        }

        return answer;
    }
}