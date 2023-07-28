/*
 * ���� 14719��: ����
 * �˰��� �з�: #���� #�ùķ��̼�
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
		// �糡 ����� �����ϰ� �� ����� ���� Ȯ��
		for(int i=1;i<W-1;i++) {
			left_max=0;
			right_max=0;
			// ���� ����� ���ʿ��� �ִ���� ã��
			for(int j=i-1;j>=0;j--) {
				left_max = Math.max(ary[j], left_max);
			}
			// ���� ����� �����ʿ��� �ִ���� ã��
			for(int j=i+1;j<W;j++) {
				right_max = Math.max(ary[j], right_max);
			}
			// �� ���� ����� �������� �ִ���� ����
			max=left_max>right_max?right_max:left_max;
			// ���� ��Ϻ��� ���� ����� ���ٸ� ������ ���� �� �����Ƿ� ���� ���� �̵�
			if(max<=ary[i]) {
				continue;
			}
			// ���� ���
			rain_cnt+=H-(H-max)-ary[i];
		}
	
		System.out.println(rain_cnt);
	}
	
}