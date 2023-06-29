/*
 * 백준 14719번: 빗물
 * 알고리즘 분류: #구현 #시뮬레이션
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int W = sc.nextInt();
		int rain_cnt=0;
		int left_max;
		int right_max;
		int max;
		int[] ary = new int[W];
		
		for(int i=0;i<W;i++) {
			ary[i]=sc.nextInt();
		}
		
		for(int i=1;i<W-1;i++) {	//양끝 블록을 제외하고 각 블록의 열을 확인
			left_max=0;
			right_max=0;
			
			for(int j=i-1;j>=0;j--) {	//기준 블록의 왼쪽에서 최대높이 찾기
				left_max = Math.max(ary[j], left_max);
			}
			for(int j=i+1;j<W;j++) {	//기준 블록의 오른쪽에서 최대높이 찾기
				right_max = Math.max(ary[j], right_max);
			}
			
			max=left_max>right_max?right_max:left_max;	//더 낮은 블록을 기준으로 최대높이 설정
			if(max<=ary[i])	//기준 블록보다 높은 블록이 없다면 빗물이 쌓일 수 없으므로 다음 열로 이동
				continue;
			rain_cnt+=H-(H-max)-ary[i];	//빗물 계산
		}
	
		System.out.println(rain_cnt);
	}
	
}