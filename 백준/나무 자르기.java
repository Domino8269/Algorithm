/*
 * ���� 2805��: ���� �ڸ���
 * �˰��� �з�: #�̺� Ž��
 */
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static int N;
	public static int M;
	public static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();	//������ ��
		M = sc.nextInt();	//������ ���� ����
		arr = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int start=0;
		int end=arr[N-1];
	
		
		//�ݺ����� �̿��� �̺� Ž��
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