package test;
/*��Ŀ����
	����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣�
   ���е�ż��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
  
  ˼·�����ò��������˼�룬�Ӵ����������ĵ�һ��Ԫ�ؿ�ʼ������ǰԪ��Ϊ�������������Ϊ���Ҳ���λ��ͬʱ��
  	ǰ���ż�������ƣ�����һ��Ҫע���±ꡣ
 * 
 * */
public class reOrderArray {
	public static void reOrderArray(int [] array) {
        int i,j;
        for(i=0;i<array.length;i++){
            if(array[i]%2 != 0){ //Ϊ��������Ҫ��ǰ�ƣ�һֱ�Ƶ�ǰ���Ԫ��Ϊ����Ϊֹ
                int tmp = array[i];
                for(j=i-1;j>=0 && (array[j]%2==0);j--){ //ע��������жϱ߽���j>=0,���j-1ָ���Ԫ��Ϊż��������
                    array[j+1] = array[j]; 
                }
                /*ע����������forѭ���е�����������j<=0����array[j]Ϊ������
                 * 	���������õ��±���j+1
                 * */
                array[j+1] = tmp; 
            }//if 
        }
    }
	
    //-------------main����-------------------------------
	public static void printArry(int[] array) {
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
    public static void main(String[] args) {
		int[] arr = new int[] {1,2,3,4,5,6,7};
		printArry(arr);
		reOrderArray(arr);
		printArry(arr);
	}
}