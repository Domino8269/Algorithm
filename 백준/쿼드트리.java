/*
 * ���� 1992��: ����Ʈ��
 * �˰��� �з�: #��� #��������
 */
import java.io.*;

public class Main { 
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		quadTree(N,0,0);
		System.out.println(sb);
	}
	
	public static void quadTree(int N, int row, int column) {
		boolean state = true;
		int color = map[row][column];
		// 0 Ȥ�� 1�� ������ �� �ִ��� Ȯ��
		for(int i=row;i<row+N;i++) {
			for(int j=column;j<column+N;j++) {
				if(map[i][j]!=color) {
					state=false;
				}
			}
		}
		// ������ �����ϴٸ� ������ ����� �߰���
		if(state) {
			sb.append(map[row][column]);
		}
		// ������ �Ұ����ϴٸ� �� �������� 4�� ���ȣ��
		else {
			sb.append('(');
			quadTree(N/2, row, column);
			quadTree(N/2, row, column+N/2);
			quadTree(N/2, row+N/2, column);
			quadTree(N/2, row+N/2, column+N/2);
			sb.append(')');
		}
		
		return;
	}
}