package sword2;

public class minNumberInRotateArray {
	public static int minNumberSearch(int[] array) {
		if(array==null || array.length==0)
			return 0;
		
		int left = 0,right=array.length-1;
		int mid = 0;
		
		//确保旋转了
		while(array[left]>=array[right]) {
			if(right-left == 1) { //right和left相邻，又array[left]>=array[right]，则right指向的元素为目标元素
				mid = right;
				break;
			}
			
			mid = left + (right-left)/2;
			//如果left、mid、right指向的元素值相等，则无法确定中间元素mid是属于前面还是后面的递增子数组只能顺序查找
			if(array[left]==array[right]&&array[right]==array[mid])
				return minOrder(array,left,right);
			
			if(array[mid] >= array[left])//中间元素位于前面的递增子数组，此时最小元素位于中间元素的后面
				left = mid;	//这里要注意不能为mid+1，因为mid可能为所求元素？？？？
			else //中间位于后面的递增子数组，此时最小元素位于中间元素的前面
				right = mid;
		}//while
		return array[mid];
		
	}
	
	public static int minOrder(int[] array,int left,int right) {
		int result=array[left];
		for(int i=left+1;i<=right;++i) {
			if(array[i]<array[left])
				result = array[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array = new int[] {4,5,6,7,8,0,1,2,3};
		//int[] array = new int[] {1,0,1,1,1};
		int min = minNumberSearch(array);
		System.out.println("min: "+min);
	}
}
















