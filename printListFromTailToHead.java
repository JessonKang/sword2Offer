package sword2;

import java.util.ArrayList;
import java.util.Stack;

/*
 *题目来源：https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *描述：从尾到头打印链表
 * 3种思路：
 * 	1.借助栈操作
 * 	2.递归
 *	3.先反转单链表 
 * */

class ListNode{
	int val;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
}

public class printListFromTailToHead {
/*
 * 法一：借助栈实现逆序输出操作
 * 思路：
 * 	1.新建一个stack，遍历链表，如果当前节点不为空则入栈，一直遍历到链表尾部，则此时stack从栈顶到栈底逆序存储着链表的元素；
 * 	2.新建一个List，将stack中的元素pop至list中，此时list中的逆序存储着链表中的数据；
 * */
	public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
	        if(listNode==null)
	            return null;
	        Stack<Integer> s = new Stack();
	        while(listNode != null){
	            s.push(listNode.val);
	            listNode = listNode.next;
	        }
	        
	        ArrayList<Integer> arr = new ArrayList();
	        while(!s.empty()){
	            arr.add(s.pop());
	        }
	        return arr;
	    }
	
/*
 * 法二：递归实现
 * 	一直向后遍历直到尾节点时开始向list里加val，见recur()方法
 * 1 2 3 4 
 * */
	public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ListNode ptr = listNode;
		recur(list,ptr);
		return list;
	}
	public static void recur(ArrayList<Integer> list,ListNode listNode) {
		if(listNode != null) {
			recur(list,listNode.next);
			list.add(listNode.val);
		}
	}
	
/*
 * 法三：反转链表（但是这样会改变链表的结构）
 * 	1.先反转单链表，然后再把链表元素从头至尾输入只list中。
 * 
 * */
	public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode){
		//单链表的反转多做几次，基础太差了，这个都写不好
		ListNode tail,p,pre;
		tail = listNode;//指向首节点
		p = listNode.next;
		tail.next = null; //让第一个节点与链表断开
		
		while(p!=null) {
			pre = p.next; 
			p.next = tail;
			tail = p;
			p = pre;
		}
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(tail!=null) {
			list.add(tail.val);
			tail=tail.next;
		}
		return list;
		
	}
	

	//main函数，测试区域
	 public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		ArrayList<Integer> arr;
		//arr = printListFromTailToHead1(n1); //法一测试
		//arr = printListFromTailToHead2(n1); //法二测试
		arr = printListFromTailToHead3(n1); //法二测试
		for(int i=0;i<arr.size();i++)
			System.out.print(arr.get(i)+" ");
	}
}


