package test;

/*��Ŀ��������ĵ�����k�����
 * 	�������������ĳ��ȣ�Ȼ������length-k���õ�������k������λ�ã��ٴ�ͷ��������λ�ü��ɣ�ע��߽�������
 * 	����һ��Ҫ���ǵ����ֱ߽�������
 * 	1������headΪ��
 * 	2��k=0
 * 	3��k��������ĳ���
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
        if(head==null) //����Ϊ��
            return head;
        
        ListNode p = head;
        int length = 0;
        while(p!=null){
            length++;
            p = p.next;
        }
        if(length < k) //k����������
            return null;
        
        ListNode pk=head;
        for(int i=0;i<length-k;i++) //���￼�ǵ���k=0�������ѭ��ִ��length�Σ�pk=null
            pk = pk.next;
        return pk;
    }
    //----------main����----------------------
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











