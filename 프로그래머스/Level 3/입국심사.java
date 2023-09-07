/*
    프로그래머스 Lv3
    Title: 입국심사
 */

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // times 배열을 정렬
        Arrays.sort(times);
        // 최소시간 -> 0, 최대시간-> n명 * 가장 긴 심사시간
        long lo = times[0];
        long hi = (long)times[times.length - 1] * n;
        // 이분탐색으로 심사 시간의 최솟값을 찾음
        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            long sum = 0;

            // 심사 시간이 mid일 때 몇 명이 심사받을 수 있는지 구함
            for (int num : times) {
                sum += mid / num;
            }
            /*
             * 심사 받을 수 있는 인원(sum)이 n명보다 적을 경우
             * 심사 시간을 늘려서 탐색 (lo 값을 증가)
             */
            if(sum < n) {
                lo = mid + 1;
            } else {
                /*
                 * 심사 받을 수 있는 인원(sum)이 n명보다 크거나 같을 경우
                 * 심사 시간을 줄이면서 최솟값을 탐색 (hi 값을 감소)
                 */
                hi = mid - 1;
            }
        }
        // 이분탐색이 끝났을 때 lo 값이 최소 심사시간이 됨
        return lo;
    }
}