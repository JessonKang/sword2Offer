package test;

import java.util.ArrayList;
/*��Ŀ��˳ʱ���ӡ����
 *  ������� 1    2     3      4 
 *  	  5 6  7  8
  *		  9 10 11 12
  *		 13 14 15 16
 �����1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
  *    ˼·��
  *    	˳ʱ���ӡ���Ǵ������ҡ��������¡����ҵ��󡢴������ϴ�ӡ������Ҫע��߽磬ͬʱҲҪע�ⲻҪ�ظ���ӡ��
 * 
 * */
public class PrintMatrix{
	public static void printMatrix(int[][] matrxi){
		int row = matrxi.length; //��
		int col = matrxi[0].length; //��
		
		//��¼4���߽�
		int up = 0,down = row-1;
		int left = 0,right = col-1;
		
		while(up<=down && left<=right) {
			//���up������Ԫ��
			for(int j=left;j<=right;++j) 
				System.out.print(matrxi[up][j]+" ");
			
			//���right������
			for(int i=up+1;i<=down;++i) //ע��matrix[up][right]Ԫ���Ѿ��������ӡ���ˣ�����i��up+1��ʼ
				System.out.print(matrxi[i][right]+" ");
			
			//���down������Ԫ�أ�ע���Ǵ����������
			for(int k=right-1;k>=left;--k)
				System.out.print(matrxi[down][k]+" ");
			
			//���left�����У�ע���Ǵ����������
			for(int c=down-1;c>up;c--)
				System.out.print(matrxi[c][left]+" ");
			
			//��ӡ��һȦ֮�󣬸��߽�����Ӧ�仯
			left++;
			right--;
			up++;
			down--;
		}
	}
	
	//----------------main����-----------------------------
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











