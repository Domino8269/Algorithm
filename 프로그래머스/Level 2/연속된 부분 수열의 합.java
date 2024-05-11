/**
 * 프로그래머스 Lv2
 * Title: 연속된 부분 수열의 합
 */

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        while (left <= right) {
            if (sum == k && answer[1] - answer[0] > right - left) {
                answer[0] = left;
                answer[1] = right;
                if (right < sequence.length - 1) {
                    sum += sequence[++right];
                } else {
                    sum -= sequence[left++];
                }
            } else if (sum < k) {
                if (right < sequence.length - 1) {
                    sum += sequence[++right];
                } else {
                    break;
                }
            } else {
                sum -= sequence[left++];
            }
        }

        return answer;
    }
}