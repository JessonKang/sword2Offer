package test;

import java.util.ArrayList;
/*题目：顺时针打印矩阵
 *  输入矩阵： 1    2     3      4 
 *  	  5 6  7  8
  *		  9 10 11 12
  *		 13 14 15 16
 输出：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
  *    思路：
  *    	顺时针打印即是从左至右、从上至下、从右到左、从下往上打印，不过要注意边界，同时也要注意不要重复打印。
 * 
 * */
public class PrintMatrix{
	public static void printMatrix(int[][] matrxi){
		int row = matrxi.length; //行
		int col = matrxi[0].length; //列
		
		//记录4个边界
		int up = 0,down = row-1;
		int left = 0,right = col-1;
		
		while(up<=down && left<=right) {
			//输出up所在行元素
			for(int j=left;j<=right;++j) 
				System.out.print(matrxi[up][j]+" ");
			
			//输出right所在列
			for(int i=up+1;i<=down;++i) //注意matrix[up][right]元素已经在上面打印过了，所以i从up+1开始
				System.out.print(matrxi[i][right]+" ");
			
			//输出down所在行元素，注意是从右往左输出
			for(int k=right-1;k>=left;--k)
				System.out.print(matrxi[down][k]+" ");
			
			//输出left所在行，注意是从下往上输出
			for(int c=down-1;c>up;c--)
				System.out.print(matrxi[c][left]+" ");
			
			//打印完一圈之后，各边界做相应变化
			left++;
			right--;
			up++;
			down--;
		}
	}
	
	//----------------main测试-----------------------------
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16},
			{17,18,19,20}
			};
		printMatrix(matrix);
	}
}











