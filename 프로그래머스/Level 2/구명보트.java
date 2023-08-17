/*
    프로그래머스 Lv2
    Title: 구명보트
 */
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;    // 필요한 보트의 개수를 count
        int sp = 0;     // 배열의 start 포인터(start pointer)
        int ep = people.length - 1; // 배열의 end 포인터(end pointer)

        Arrays.sort(people); // 배열을 오름차순으로 정렬
        // start 포인터가 end 포인터보다 커지면 종료
        while(sp <= ep) {
            // start 포인터와 end 포인터가 일치하면 한 명이 남은 것이므로
            // count를 하나 증가시킨 후, 반복문 종료
            if(sp == ep) {
                cnt++;
                break;
            }
            // end 포인터가 가리키는 사람과 start 포인터가 가리키는 사람을 모두 보트에 태울 수 있다면
            else if(people[ep] + people[sp] <= limit) {
                // 보트(cnt) + 1, end 포인터(ep) - 1, start 포인터(sp) + 1
                cnt++;
                ep--;
                sp++;
            }
            // 둘 모두를 태울 수 없다면 end 포인터가 가리키는(가장 오른쪽) 사람만 보트에 태움
            else {
                cnt++;
                ep--;
            }
        }
        // 보트의 수(cnt)를 리턴
        return cnt;
    }
}