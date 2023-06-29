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
		
		for(int i=1;i<W-1;i++) {	//�糡 ����� �����ϰ� �� ����� ���� Ȯ��
			left_max=0;
			right_max=0;
			
			for(int j=i-1;j>=0;j--) {	//���� ����� ���ʿ��� �ִ���� ã��
				left_max = Math.max(ary[j], left_max);
			}
			for(int j=i+1;j<W;j++) {	//���� ����� �����ʿ��� �ִ���� ã��
				right_max = Math.max(ary[j], right_max);
			}
			
			max=left_max>right_max?right_max:left_max;	//�� ���� ����� �������� �ִ���� ����
			if(max<=ary[i])	//���� ��Ϻ��� ���� ����� ���ٸ� ������ ���� �� �����Ƿ� ���� ���� �̵�
				continue;
			rain_cnt+=H-(H-max)-ary[i];	//���� ���
		}
	
		System.out.println(rain_cnt);
	}
	
}