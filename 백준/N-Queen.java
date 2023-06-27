/*
 * ���� 9663��: N-Queen
 * �˰��� �з�: #��Ʈ��ŷ #���Ʈ����
 */
import java.util.Scanner;

public class Main {
	public static int[] arr;
	public static int N;
	public static int cnt = 0;
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		N = sc.nextInt();
		arr = new int[N];
		
		dfs(0);
		System.out.println(cnt);
	}
	
	public static void dfs(int depth) {
		if(depth==N) {	//������ ����� ���� ��ġ�� ��ȿ�ϴٸ� count�� ������Ű�� ����
			cnt++;
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[depth]=i;
			
			//���� ��ġ�� ��ȿ�ϴٸ� ���� ������ �̵� (depth�� ���� �ǹ�)
			//�׷��� ������ ���� ���� �� ���� ���� �̵�
			if(checkQueen(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean checkQueen(int depth) {	//���� ���� ���� ��ġ�� ��ȿ���� Ȯ��
		for(int i=0;i<depth;i++) {
			//���� �� or �밢���� ��ġ�ϸ� false
			if(arr[i]==arr[depth] || Math.abs(arr[depth]-arr[i])== depth-i) {
				return false;
			}
		}
		return true;
	}
}