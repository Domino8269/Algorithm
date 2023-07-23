/*
 * 백준 1783번: 병든 나이트
 * 알고리즘 분류: #구현 #그리디 알고리즘
 */

import java.util.*;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int result = 0;
		
		if(N>=3 && M>=7) {	// 4번의 이동방법을 모두 사용할 수 있는 최소한의 크기를 넘길 경우
			result = 5 + M-7;
		}
		else {
			if(N==1) {	// 세로가 1칸일 경우
				result = 1;
			}
			else if(N==2) {	// 세로가 2칸일 경우
				result = (M-1)/2+1;
			}
			else if(N>=3) {	// 세로가 3칸 이상일 경우
				result = M;
			}
			if(result >= 4) {	// 4번의 이동방법을 모두 사용하지 않으면 4칸 이상 이동할 수 없기 때문에 max값은 4
				result = 4;
			}
		}
		
		System.out.println(result);
	}
}


