package sword2offer;

public class SearchNumInRotateArray {
	public static int search(int[] array,int target) {
		int start = 0, end = array.length -1;
		while(start<=end) {
			int mid = start + ((end-start)>>1);
			if(array[mid] == target)
				return array[mid];
		
			//���A����ת�㣨δ��ת�������еĵ�һ��Ԫ�أ�����λ���Ҳ�
			if(array[mid] >= array[start]) {
				//�����Ԫ�� <= target < ��λ��
				if(array[mid]>target && array[start]<=target) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}//if
			//���B����ת������λ����࣬������λ���غ�
			else {
				//��λ�� < target <=���ұ�Ԫ��
				if(array[mid]<target && target<=array[end]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}//while
		return -1; //δ�ҵ�
	}
	
	//-------main����-----------
	public static void main(String[] args) {
		int[] array = new int[] {9,10,11,12,19,2,3,4,5,6};
		System.out.println(search(array, 111));
	}
}
