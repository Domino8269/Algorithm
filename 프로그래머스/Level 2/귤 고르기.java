/*
    프로그래머스 Lv2
    Title: 귤 고르기
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 중복되는 귤의 개수를 count하는 변수
        int cnt = 1;
        // 빼야될 귤의 개수
        int num = tangerine.length - k;
        // 중복되는 귤의 개수를 저장할 ArrayList
        ArrayList<Integer> arr = new ArrayList<>();
        // 입력받은 배열을 오름차순으로 정렬
        Arrays.sort(tangerine);
        // 입력받은 배열을 순회
        for(int i = 0; i < tangerine.length; i++) {
            // 인덱스가 배열의 마지막에 도달하면 cnt를 ArrayList에 추가
            if(i == tangerine.length - 1) {
                arr.add(cnt);
            }
            // 현재 귤의 크기와 다음 귤의 크기가 일치하면, cnt를 1만큼 증가
            else if(tangerine[i] == tangerine[i + 1]) {
                cnt++;
            }
            // 현재 귤의 크기가 다음 귤의 크기와 다르면
            // cnt를 ArrayList에 추가 후, cnt를 1로 초기화
            else {
                arr.add(cnt);
                cnt = 1;
            }
        }
        // 중복되는 귤의 개수를 저장한 ArrayList를 오름차순으로 정렬
        Collections.sort(arr);
        // ArrayList를 순회하면서, 빼야되는 귤의 개수(num)에서 중복이 적은 숫자들을 차례로 뺌
        for(int i = 0; i < arr.size(); i++) {
            if(num - arr.get(i) >= 0){
                num -= arr.get(i);
            }
            // 더 이상 뺄 수 없으면 남아있는 귤이 몇 종류 인지 계산 후 종료
            else {
                answer = arr.size() - i;
                break;
            }
        }

        return answer;
    }
}