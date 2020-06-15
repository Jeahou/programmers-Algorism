package practice;
import java.util.*;
public class Kakao2020_4 {
	static boolean[][] colVisited;
	static boolean[][] rowVisited;
	static boolean isExistCol(int x, int y) {
		return (y==1 || colVisited[y-1][x] == true || rowVisited[y][x] == true ||  rowVisited[y][x-1] == true);
	}
	static boolean isExistRow(int x, int y) {
		return (colVisited[y-1][x] == true || colVisited[y-1][x+1] == true || (rowVisited[y][x-1] == true && rowVisited[y][x+1]));
	}
	static boolean remove(int x, int y, int k, int n) {
		if(k==0) {
			colVisited[y][x] = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(colVisited[i][j] && !isExistCol(j, i)) {
						colVisited[y][x] = true;
						return false;
					}
					if(rowVisited[i][j] && !isExistRow(j, i)) {
						colVisited[y][x] = true;
						return false;
					}
				}
			}
		}else {
			rowVisited[y][x] = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(colVisited[i][j] && !isExistCol(j, i)) {
						rowVisited[y][x] = true;
						return false;
					}
					if(rowVisited[i][j] && !isExistRow(j, i)) {
						rowVisited[y][x] = true;
						return false;
					}
				}
			}
		}
		return true;
	}
	static int[][] cal(int[][] buildList, int n) {
		int cnt =0;
		colVisited = new boolean[n+3][n+3];
		rowVisited = new boolean[n+3][n+3];
		for(int[] map : buildList) {
			int x = map[0]+1;
			int y = map[1]+1;
			if(map[3] == 1) {
				if(map[2] == 0) {
					if(isExistCol(x, y)) {
						colVisited[y][x] = true;
						cnt++;
					}
				}else if(map[2] == 1){
					if(isExistRow(x, y)) {
						rowVisited[y][x] = true;
						cnt++;
					}
				}
			}else {
				if(map[2] == 0) {
					if(remove(x,y,0,n+3)) cnt--;
					
				}else {
					if(remove(x,y,1,n+3)) cnt--;
				}
			}
		}
		int[][] result = new int[cnt][3];
		int idx = 0;
		for(int i=0; i<n+3; i++) {
			for(int j=0; j<n+3; j++) {
				if(colVisited[j][i]) result[idx++] = new int[]{i-1, j-1, 0};
				if(rowVisited[j][i]) result[idx++] = new int[]{i-1, j-1, 1};
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] buildList = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		int[][] result = cal(buildList, n);
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
