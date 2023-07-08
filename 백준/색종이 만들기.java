/*
 * ���� 2630��: ������ �����
 * �˰��� �з�: #��� #��������
 */
import java.util.*;
import java.io.*;

public class Main { 
	static int b_cnt = 0;
	static int w_cnt = 0;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		color_paper(N,0,0);
		System.out.println(w_cnt+"\n"+b_cnt);
	}
	
	public static void color_paper(int N, int row, int column) {
		boolean state = true;
		int color = map[row][column];
		
		for(int i=row;i<row+N;i++) {	//�����̰� ��� ���������� ä���� �ִ��� Ȯ��
			for(int j=column;j<column+N;j++) {
				if(map[i][j]!=color) {
					state=false;
				}
			}
		}
		
		if(state) {
			if(map[row][column]==1) {	//�Ķ������� ä�����ٸ� blue_count �ƴ϶�� white_count�� ����
				b_cnt++;
			}
			else {
				w_cnt++;
			}
		}
		else {	//�� �������� 4�� ���ȣ��
			color_paper(N/2, row, column);
			color_paper(N/2, row, column+N/2);
			color_paper(N/2, row+N/2, column);
			color_paper(N/2, row+N/2, column+N/2);
		}
		
		return;
	}
}