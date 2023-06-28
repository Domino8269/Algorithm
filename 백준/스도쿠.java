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
				if(ary[i][j]==0) {	//0�� ������ ��� �ε����� �迭�� ����
					zero[cnt][0]=i;
					zero[cnt][1]=j;
					cnt++;
				}
			}
		}
		
		sudoku(0);
	}
	
	public static void sudoku(int depth) {
		if(depth==cnt || cnt==0) {	//�ִ����(0�� ������ŭ) ���޽� ������ ��� �� ���α׷� ����
			printsudoku();
			System.exit(0);
		}
		
		for(int k=1;k<=9;k++) {	//1~9���� ���ڴ���
			ary[zero[depth][0]][zero[depth][1]]=k;
			if(checkNum(zero[depth][0], zero[depth][1])) {	//���� ���ڰ� �ߺ��Ǿ����� Ȯ��. �ߺ��Ǵ� ���ڰ� ���ٸ� ���ȣ��(���� 0 ��ġ�� �̵�)
				sudoku(depth+1);
			}
		}
		ary[zero[depth][0]][zero[depth][1]]=0;	//9���� �õ��ߴµ� �� �� �ִ� ���ڰ� ���� ��� 0���� �ٽ� �ʱ�ȭ
	}
	
	public static boolean checkNum(int row, int column) {
		
		for(int i=0;i<9;i++) {	//���� �� Ȯ��
			if(ary[row][i]==ary[row][column] && i!=column) {
				return false;
			}
		}
		
		
		for(int i=0;i<9;i++) {	//���� �� Ȯ��
			if(ary[i][column]==ary[row][column] && i!=row) {
				return false;
			}
		}
		
		int f_row=(row/3)*3;
		int f_column=(column/3)*3;
		
		for(int i=f_row; i<f_row+3; i++) {	//���� �ڽ� Ȯ��
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