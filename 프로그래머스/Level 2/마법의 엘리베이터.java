/**
 *  프로그래머스 Lv2
 *  Title: 마법의 엘리베이터
 */
class Solution {
    public int solution(int storey) {
        int count = 0;

        while (storey != 0) {
            int num = storey % 10;
            storey /= 10;

            if (num < 5) {
                count += num;
            } else if (num == 5) {
                if (storey % 10 >= 5) {
                    storey++;
                }
                count += num;
            } else {
                count += 10 - num;
                storey++;
            }
        }

        return count;
    }
}