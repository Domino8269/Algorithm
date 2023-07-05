/*
 * ���� 11659��: ���� �� ���ϱ� 4
 * �˰��� �з�: #������
 */
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] psum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			psum[i]=i!=0?psum[i-1]+arr[i]:arr[i];
		}
	
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(i!=1?psum[j-1]-psum[i-2]:psum[j-1]);
		}	
	}
}