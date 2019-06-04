package test;
/*题目描述
	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
   所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
  
  思路：利用插入排序的思想，从待处理的数组的第一个元素开始，若当前元素为奇数，则在左边为其找插入位置同时将
  	前面的偶数往后移，这里一定要注意下标。
 * 
 * */
public class reOrderArray {
	public static void reOrderArray(int [] array) {
        int i,j;
        for(i=0;i<array.length;i++){
            if(array[i]%2 != 0){ //为奇数，需要往前移，一直移到前面的元素为奇数为止
                int tmp = array[i];
                for(j=i-1;j>=0 && (array[j]%2==0);j--){ //注意这里的判断边界是j>=0,如果j-1指向的元素为偶数，后移
                    array[j+1] = array[j]; 
                }
                /*注意插入排序从for循环中的跳出条件是j<=0或者array[j]为奇数，
                 * 	所以这里用到下标是j+1
                 * */
                array[j+1] = tmp; 
            }//if 
        }
    }
	
    //-------------main测试-------------------------------
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