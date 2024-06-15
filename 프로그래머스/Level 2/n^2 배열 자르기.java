/**
 * 프로그래머스 Lv2
 * Title - n^2 배열 자르기
 */

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int p = 0;
        for (long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);

            answer[p++] = Math.max(row, col) + 1;
        }

        return answer;
    }
}