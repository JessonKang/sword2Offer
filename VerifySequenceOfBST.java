package sword2;
/*��Ŀ������һ���������飬�жϸ������ǲ���ĳ�����������ĺ��������Ľ��������ture��false��
 *˼·��
 *	ע���ں��������õ��������У����һ�����������ĸ��ڵ��ֵ��������ǰ������ֿ��Է�Ϊ�����֣�
 *	��һ�������������ڵ��ֵ�����Ƕ��ȸ��ڵ�ֵС���ڶ��������������ڵ��ֵ�����Ƕ��ȸ��ڵ�ֵ��
 *	��1�����ݸ��ڵ��ֵ���ֳ����������к����������У�
 *	��2��	Ȼ���ж��������������Ƿ���ڱȸ��ڵ�С��ֵ����������򷵻�false��
 *	��3���ݹ��ж����������к������������Ƿ���������
 * 
 * 
 * */
public class VerifySequenceOfBST {
	public static boolean verifySequenceOfBST(int[] sequence) {
		if(sequence.length==0)	return false;
		return isTreeBST(sequence,0,sequence.length-1);
	}
	/**
	 * @param sequence ��������
	 * @param start	��ʼ�±�
	 * @param end	��β�±�
	 * @return
	 */
	public static boolean isTreeBST(int[] sequence,int start,int end) {
		/*��start == endʱ����ʾ��һ���ֱȽ�����
		 *�����е������ڹ鲢������Ϊ���Ķ����ǵݹ�ģ�����һ���ڵ�����ж�ʱ����������������Ϊ�գ����Ծ�ΪBST��return true
		 * 
		 * */
		if(start == end)	return true;
		
		int root = sequence[end]; //���ڵ�
		
		int i = start; //i�������������������еĵ�һ���ڵ㣬��iǰ�Ľڵ㶼ΪС�ڸ��ڵ���������ڵ�
		for(;i<end;i++) //end�Ǹ��ڵ㣬������Ƚϣ������ж�����Ϊ i<end
			if(sequence[i] > root) break;
		
		//�ж����е����������нڵ��Ƿ񶼴��ڸ��ڵ�
		int j = i;
		for(;j<end;j++)
			if(sequence[j] < root) return false;
		
		//�ݹ��ж����������к������������Ƿ���������
		/*ע�������ļ����֪��iָ����Ǵ��ڸ��ڵ�ĵ�һ���ڵ㣬�������������еĽڵ㣬�������ж�������ʱ����Ĳ���Ϊ��start,i-1��;
		 * endָ����Ǹ��ڵ㣬���ٲ�����һ�ε��жϣ����ж�����������Ĳ���Ϊ��i,end-1��;
		 * 
		 * */
		return isTreeBST(sequence,start,i-1) && isTreeBST(sequence,i,end-1);
	}
}




