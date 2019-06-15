package sword2;
/*题目：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *    返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *思路：
 *	分三步走
 *	1.复制每个结点，如复制结点A得到A1，将A1插到结点A后面；
 *	2.重新遍历链表，复制老结点的随机指针给新节点，如：A1.random = A.random.next;注意这里是A.random.next的原因是要让A1.random指向
 *新节点，如果赋的值是A.random的话就成了让A1指向老结点了。
 *	3.重新遍历链表，将新链表拆分出来。
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
		//1.复制每个结点
		while(current!=null) {
			RandomListNode cloneNode = new RandomListNode(current.label); //复制结点
			cloneNode.next = current.next;
			current.next = cloneNode;
			current = cloneNode.next;
		}
		
		//2.复制随机指针
		current = pHead;
		while(current!=null) {
			current.next.random = current.random==null?null:current.random.next;
			current = current.next.next;
		}
		
		//3.拆分链表
		current = pHead;
		RandomListNode pCloneHead = pHead.next;
		while(current != null) {
			RandomListNode cloneNode = current.next; //指向current后面的复制结点
			current.next = cloneNode.next; //改变原始链表的指向
			cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
			current = current.next;
		}
		return pCloneHead;
	}
}








