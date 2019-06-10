package sword2offer.sword2Offer;
import java.util.Stack;

/*��Ŀ��
 * 	���������������У���һ�����б�ʾջ��ѹ��˳���жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ������
 * 	ѹջ���У�1,2,3,4,5	��ջ���У�4,5,3,2,1
 *˼·��
 *	����һ������ջ��ͬʱ����һ��������ջ���е�����popIndex(��ʼΪ0)������ѹջ˳���Ƚ���һ�����븨��ջ�У�������1��Ȼ���ж�ջ��Ԫ�أ���1���Ƿ���ڳ�ջ���еĵ�һ��Ԫ�أ���4����
 *����ȣ��������ѹջ���е���һ��Ԫ�ؽ���ѹջ��ֱ��ջ��Ԫ����popIndexָ���Ԫ����Ⱥ�ʼ��ջ����ջ��ͬʱpopIndex���ƣ�ֱ��ջ��Ԫ����popIndexָ���Ԫ�ز���ȣ�����
 *ѭ����ѹջ���б����꣬�������ջΪ�գ����ջ������ѹջ���е�һ������������ǡ�
 * 	   
 * 
 * */
public class StackPushAndPop {
	public boolean isPopOrder(int[] pushA,int[] popA) {
		//ע�⣺�����κ�һ���ⶼҪ��������ĸ������
		if(pushA.length==0 || popA.length==0)
			return false;
		
		Stack<Integer> s = new Stack<Integer>(); //����ջ
		int popIndex = 0; //����popA���е��±�
		for(int i=0;i<pushA.length;++i) {
			s.push(pushA[i]); //
			while(!s.empty() || s.peek()==popA[popIndex]) {
				s.pop();
				popIndex++;
			}
		}
		return s.empty();
	}
}
