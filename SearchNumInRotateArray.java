package sword2offer;

public class SearchNumInRotateArray {
	public static int search(int[] array,int target) {
		int start = 0, end = array.length -1;
		while(start<=end) {
			int mid = start + ((end-start)>>1);
			if(array[mid] == target)
				return array[mid];
		
			//情况A：旋转点（未旋转数组序列的第一个元素）在中位数右侧
			if(array[mid] >= array[start]) {
				//最左侧元素 <= target < 中位数
				if(array[mid]>target && array[start]<=target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}//if
			//情况B：旋转点在中位数左侧，或与中位数重合
			else {
				//中位数 < target <=最右边元素
				if(array[mid]<target && target<=array[end]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}//while
		return -1; //未找到
	}
	
	//-------main测试-----------
	public static void main(String[] args) {
		int[] array = new int[] {9,10,11,12,19,2,3,4,5,6};
		System.out.println(search(array, 111));
	}
}
