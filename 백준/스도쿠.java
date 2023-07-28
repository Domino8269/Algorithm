/*
 * 백준 2580번: 스도쿠
 * 알고리즘 분류: #백트래킹
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
				// 0의 개수와 행렬 인덱스를 배열에 저장
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
		// 최대깊이(0의 개수만큼) 도달시 스도쿠 출력 후 프로그램 종료
		if(depth==cnt || cnt==0) {
			printsudoku();
			System.exit(0);
		}
		// 1~9까지 숫자대입
		for(int k=1;k<=9;k++) {
			ary[zero[depth][0]][zero[depth][1]]=k;
			// 현재 숫자가 중복되었는지 확인. 중복되는 숫자가 없다면 재귀호출(다음 0 위치로 이동)
			if(checkNum(zero[depth][0], zero[depth][1])) {
				sudoku(depth+1);
			}
		}
		// 9까지 시도했는데 들어갈 수 있는 숫자가 없는 경우 0으로 다시 초기화
		ary[zero[depth][0]][zero[depth][1]]=0;
	}
	
	public static boolean checkNum(int row, int column) {
		// 같은 행 확인
		for(int i=0;i<9;i++) {
			if(ary[row][i]==ary[row][column] && i!=column) {
				return false;
			}
		}
		
		// 같은 열 확인
		for(int i=0;i<9;i++) {
			if(ary[i][column]==ary[row][column] && i!=row) {
				return false;
			}
		}
		
		int f_row=(row/3)*3;
		int f_column=(column/3)*3;
		// 같은 박스 확인
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