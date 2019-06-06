package sword2offer.sword2Offer;

/*��Ŀ���ϲ��������������ϲ��������ǵݼ�����
 * 	˼·���½�һ��ͷ���list���ںϲ�������ע�ⷵ��ʱ����list.next���ɡ�
 * 		ע����ֱ߽�����һ��Ҫ���ǵ�
 * */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null)
            return list1;
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        
        ListNode list = new ListNode(-1); //����һ��ͷ��㣬���ڴ����ڳ�����󷵻أ�list.next����
        ListNode listPre = list;
        ListNode l1=list1,pre1=null;
        ListNode l2=list2,pre2=null;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){ //��l1ָ��Ľ�����listPre����
                pre1 = l1.next; //����l1�ĺ��
                l1.next = null; //����l1ָ��Ľ��
                listPre.next = l1;
                listPre = listPre.next;
                l1 = pre1;
            }else{
                pre2 = l2.next; //��pre2ָ��l2�ĺ��
                l2.next = null;
                listPre.next = l2;
                listPre = listPre.next;
                l2 = pre2;
            }
        }
        if(l1 != null){
            listPre.next = l1;
        }
        if(l2 != null){
            listPre.next = l2;
        }
        return list.next;
    }
}














