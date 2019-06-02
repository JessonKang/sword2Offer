package sword2;

public class minNumberInRotateArray {
	public static int minNumberSearch(int[] array) {
		if(array==null || array.length==0)
			return 0;
		
		int left = 0,right=array.length-1;
		int mid = 0;
		
		//ȷ����ת��
		while(array[left]>=array[right]) {
			if(right-left == 1) { //right��left���ڣ���array[left]>=array[right]����rightָ���Ԫ��ΪĿ��Ԫ��
				mid = right;
				break;
			}
			
			mid = left + (right-left)/2;
			//���left��mid��rightָ���Ԫ��ֵ��ȣ����޷�ȷ���м�Ԫ��mid������ǰ�滹�Ǻ���ĵ���������ֻ��˳�����
			if(array[left]==array[right]&&array[right]==array[mid])
				return minOrder(array,left,right);
			
			if(array[mid] >= array[left])//�м�Ԫ��λ��ǰ��ĵ��������飬��ʱ��СԪ��λ���м�Ԫ�صĺ���
				left = mid;	//����Ҫע�ⲻ��Ϊmid+1����Ϊmid����Ϊ����Ԫ�أ�������
			else //�м�λ�ں���ĵ��������飬��ʱ��СԪ��λ���м�Ԫ�ص�ǰ��
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
















