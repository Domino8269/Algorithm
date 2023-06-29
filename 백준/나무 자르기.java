/*
 * 백준 2805번: 나무 자르기
 * 알고리즘 분류: #이분 탐색
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();	//나무의 수
		M = sc.nextInt();	//가져갈 나무 길이
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int start=0;
		int end=arr[N-1];
	
		
		//반복문을 이용한 이분 탐색
		while(start<end) {
			int mid = (start+end)/2;
			long sum=0;	
			
			for(int i=0; i<arr.length;i++) {
				if(arr[i]-mid > 0) {
					sum += (arr[i]-mid);
				}
			}

			if (sum<M) {
		        end=mid;
		    }
		    else {
		        start=mid+1;
		    }
		}
		System.out.println(start-1);
	}
}