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
  *这里一定要考虑到各种输入情况如：!!!!!!!!!!!!!!!
  *	单行矩阵：[[1,2,3,4,5]]
  *	单列矩阵：[[1],[2],[3],[4],[5]]
  * 单行单列：[[1]]
  * 空矩阵:[]
 * */
public class PrintMatrix{
public static ArrayList<Integer> printMatrix(int [][] matrxi) {
        
       ArrayList<Integer> list = new ArrayList<Integer>();
       int row = matrxi.length; //行
		int col = matrxi[0].length; //列
		
        if(matrxi==null || row==0)
            return list;
		//记录4个边界
		int up = 0,down = row-1;
		int left = 0,right = col-1;
        while(up<=down && left<=right){
            //输出up所在行元素
            for(int j=left;j<=right;++j) 
                list.add(matrxi[up][j]);

            //输出right所在列
            for(int i=up+1;i<=down;++i) //注意matrix[up][right]元素已经在上面打印过了，所以i从up+1开始
                list.add(matrxi[i][right]);
            
            //输出down所在行元素，注意是从右往左输出
            if(up != down){ //即存在多行的时候才输出，如果仅剩下一行，那么在之前输出行的时候就已经输出过了，则这里是做重复输出
                for(int k=right-1;k>=left;--k)
                    list.add(matrxi[down][k]);
            }
            
            
            //输出left所在行，注意是从下往上输出        
            if(left != right) { //这里一定要考虑到仅剩下一列的情况，如果仅剩下一列，那么在之前输出列的时候就已经输出过了
	            for(int c=down-1;c>up;c--)
	                list.add(matrxi[c][left]);
            }
            //打印完一圈之后，各边界做相应变化
            left++;
            right--;
            up++;
            down--;
        }

        return list;
    }
	
	//----------------main测试-----------------------------
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
			{1},
			{2},
			{3},
			{4},
			{5}
			};
		ArrayList<Integer> list =printMatrix(matrix);
	}
}











