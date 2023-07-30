/*
    프로그래머스 Lv2
    Title: 카펫
 */

import java.util.ArrayList;

class Solution {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sqrt = (int) Math.sqrt(yellow); // yellow의 제곱근을 저장
        ArrayList<Integer> arr = new ArrayList<>(); // 약수를 저장할 ArrayList

        for(int i = 1; i <= sqrt; i++){
            if(yellow % i == 0){
                // 곱해서 yellow가 되는 두 수를 저장
                arr.add(i);
                arr.add(yellow / i);
            }
        }
        // ArrayList를 순회
        for(int i = 0; i < arr.size()/2; i++){
            int h = arr.get(i*2);
            int w = arr.get(i*2+1);
            // brown에 해당되는 가로 세로 길이를 찾으면 해당 값을 저장하고 리턴
            if((w+2)*2+(h*2) == brown) {
                answer[0] = w+2;
                answer[1] = h+2;
                break;
            }
        }

        return answer;
    }
}