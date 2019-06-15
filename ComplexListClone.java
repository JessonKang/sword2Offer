package sword2;
/*��Ŀ������һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 *    ���ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 *˼·��
 *	��������
 *	1.����ÿ����㣬�縴�ƽ��A�õ�A1����A1�嵽���A���棻
 *	2.���±������������Ͻ������ָ����½ڵ㣬�磺A1.random = A.random.next;ע��������A.random.next��ԭ����Ҫ��A1.randomָ��
 *�½ڵ㣬�������ֵ��A.random�Ļ��ͳ�����A1ָ���Ͻ���ˡ�
 *	3.���±����������������ֳ�����
 * */

class RandomListNode{
	int label;
	RandomListNode next=null;
	RandomListNode random=null;
	RandomListNode(int label){
		this.label = label;
	}
}

public class ComplexListClone {
	public RandomListNode clone(RandomListNode pHead) {
		if(pHead == null)
			return null;
		RandomListNode current = pHead;
		//1.����ÿ�����
		while(current!=null) {
			RandomListNode cloneNode = new RandomListNode(current.label); //���ƽ��
			cloneNode.next = current.next;
			current.next = cloneNode;
			current = cloneNode.next;
		}
		
		//2.�������ָ��
		current = pHead;
		while(current!=null) {
			current.next.random = current.random==null?null:current.random.next;
			current = current.next.next;
		}
		
		//3.�������
		current = pHead;
		RandomListNode pCloneHead = pHead.next;
		while(current != null) {
			RandomListNode cloneNode = current.next; //ָ��current����ĸ��ƽ��
			current.next = cloneNode.next; //�ı�ԭʼ�����ָ��
			cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
			current = current.next;
		}
		return pCloneHead;
	}
}








