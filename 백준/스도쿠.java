/*
 * ���� 2580��: ������
 * �˰��� �з�: #��Ʈ��ŷ
 */
import java.util.Scanner;

public class Main {
	public static int[][] ary = new int[9][9];
	public static int[][] zero = new int[81][2];
	public static int cnt = 0;
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				ary[i][j]=sc.nextInt();
				// 0�� ������ ��� �ε����� �迭�� ����
				if(ary[i][j]==0) {
					zero[cnt][0]=i;
					zero[cnt][1]=j;
					cnt++;
				}
			}
		}
		
		sudoku(0);
	}
	
	public static void sudoku(int depth) {
		// �ִ����(0�� ������ŭ) ���޽� ������ ��� �� ���α׷� ����
		if(depth==cnt || cnt==0) {
			printsudoku();
			System.exit(0);
		}
		// 1~9���� ���ڴ���
		for(int k=1;k<=9;k++) {
			ary[zero[depth][0]][zero[depth][1]]=k;
			// ���� ���ڰ� �ߺ��Ǿ����� Ȯ��. �ߺ��Ǵ� ���ڰ� ���ٸ� ���ȣ��(���� 0 ��ġ�� �̵�)
			if(checkNum(zero[depth][0], zero[depth][1])) {
				sudoku(depth+1);
			}
		}
		// 9���� �õ��ߴµ� �� �� �ִ� ���ڰ� ���� ��� 0���� �ٽ� �ʱ�ȭ
		ary[zero[depth][0]][zero[depth][1]]=0;
	}
	
	public static boolean checkNum(int row, int column) {
		// ���� �� Ȯ��
		for(int i=0;i<9;i++) {
			if(ary[row][i]==ary[row][column] && i!=column) {
				return false;
			}
		}
		
		// ���� �� Ȯ��
		for(int i=0;i<9;i++) {
			if(ary[i][column]==ary[row][column] && i!=row) {
				return false;
			}
		}
		
		int f_row=(row/3)*3;
		int f_column=(column/3)*3;
		// ���� �ڽ� Ȯ��
		for(int i=f_row; i<f_row+3; i++) {
			for(int j=f_column;j<f_column+3;j++) {
				if(ary[i][j]==ary[row][column] && (i!=row && j!=column)) {
					return false;
				}
			}
		}

		return true;
	}
	
	public static void printsudoku() {
		for(int[] arr : ary) {
			for(int num : arr) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
}