/*
    프로그래머스 Lv2
    Title: 숫자 카드 나누기
 */
import java.util.Arrays;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int GCD_A = arrayA[0];
        int GCD_B = arrayB[0];

        // 각 배열의 최대 공약수 구하기 (유클리드 호제법 사용)
        for(int i = 1; i < arrayA.length; i++){
            GCD_A = findGCD(arrayA[i], GCD_A);
            GCD_B = findGCD(arrayB[i], GCD_B);
        }

        // 배열 A의 최대 공약수로 배열 B의 모든 수에 대해, 나눌 수 있는지 확인
        if(!canDivide(arrayB, GCD_A)){
            answer = Math.max(answer, GCD_A);
        }
        // 배열 B의 최대 공약수로 배열 A의 모든 수에 대해, 나눌 수 있는지 확인
        if(!canDivide(arrayA, GCD_B)){
            answer = Math.max(answer, GCD_B);
        }

        return answer;
    }

    public static int findGCD(int a, int b){
        if(b == 0) {
            return a;
        } else {
            return findGCD(b, a % b);
        }
    }

    public static boolean canDivide(int[] array, int GCD){
        for(int num : array){
            if(num % GCD == 0){
                return true;
            }
        }

        return false;
    }
}