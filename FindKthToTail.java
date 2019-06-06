package test;

/*题目：找链表的倒数第k个结点
 * 	可以先求出链表的长度，然后再用length-k即得到倒数第k个结点的位置，再从头遍历到该位置即可，注意边界条件。
 * 	这里一定要考虑到各种边界条件：
 * 	1）链表head为空
 * 	2）k=0
 * 	3）k大于链表的长度
 * */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
    public int getVal() {
    	return val;
    }
}

public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head,int k) {
        if(head==null) //链表为空
            return head;
        
        ListNode p = head;
        int length = 0;
        while(p!=null){
            length++;
            p = p.next;
        }
        if(length < k) //k大于链表长度
            return null;
        
        ListNode pk=head;
        for(int i=0;i<length-k;i++) //这里考虑到了k=0的情况，循环执行length次，pk=null
            pk = pk.next;
        return pk;
    }
    //----------main测试----------------------
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode head1 = new ListNode(2);
		ListNode head2 = new ListNode(3);
		ListNode head3 = new ListNode(4);
		ListNode head4 = new ListNode(5);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = null;
		
		ListNode pListNode = head;
		while(pListNode != null) {
			System.out.print(pListNode.val + " ");
			pListNode = pListNode.next;
		}
		System.out.println();
		
		ListNode pkListNode = findKthToTail(head, 3);
		System.out.println(pkListNode.val);
    
    }
}











