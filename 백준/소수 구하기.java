/*
 * ���� 1929�� -> �Ҽ� ���ϱ�
 * �˰��� �з� -> #����  #������ #�Ҽ� ���� #�����佺�׳׽��� ü
 */
import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		boolean[] arr = new boolean[M+1];
		
		for(int i=2; i<=M;i++) {
			if(arr[i]==false) {
				for(int j=2;i*j<=M;j++) {
					arr[i*j]=true;
				}
			}
		}
		
		for(int i=N;i<=M;i++) {
			if(arr[i]==false && i!=1) {
				System.out.println(i);
			}
		}
	}
}