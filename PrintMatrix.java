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
  *����һ��Ҫ���ǵ�������������磺!!!!!!!!!!!!!!!
  *	���о���[[1,2,3,4,5]]
  *	���о���[[1],[2],[3],[4],[5]]
  * ���е��У�[[1]]
  * �վ���:[]
 * */
public class PrintMatrix{
public static ArrayList<Integer> printMatrix(int [][] matrxi) {
        
       ArrayList<Integer> list = new ArrayList<Integer>();
       int row = matrxi.length; //��
		int col = matrxi[0].length; //��
		
        if(matrxi==null || row==0)
            return list;
		//��¼4���߽�
		int up = 0,down = row-1;
		int left = 0,right = col-1;
        while(up<=down && left<=right){
            //���up������Ԫ��
            for(int j=left;j<=right;++j) 
                list.add(matrxi[up][j]);

            //���right������
            for(int i=up+1;i<=down;++i) //ע��matrix[up][right]Ԫ���Ѿ��������ӡ���ˣ�����i��up+1��ʼ
                list.add(matrxi[i][right]);
            
            //���down������Ԫ�أ�ע���Ǵ����������
            if(up != down){ //�����ڶ��е�ʱ�������������ʣ��һ�У���ô��֮ǰ����е�ʱ����Ѿ�������ˣ������������ظ����
                for(int k=right-1;k>=left;--k)
                    list.add(matrxi[down][k]);
            }
            
            
            //���left�����У�ע���Ǵ����������        
            if(left != right) { //����һ��Ҫ���ǵ���ʣ��һ�е�����������ʣ��һ�У���ô��֮ǰ����е�ʱ����Ѿ��������
	            for(int c=down-1;c>up;c--)
	                list.add(matrxi[c][left]);
            }
            //��ӡ��һȦ֮�󣬸��߽�����Ӧ�仯
            left++;
            right--;
            up++;
            down--;
        }

        return list;
    }
	
	//----------------main����-----------------------------
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











