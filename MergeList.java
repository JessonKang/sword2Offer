package sword2offer.sword2Offer;

/*题目：合并两个有序链表，合并后的链表非递减排序
 * 	思路：新建一个头结点list用于合并操作，注意返回时返回list.next即可。
 * 		注意各种边界条件一定要考虑到
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
        
        ListNode list = new ListNode(-1); //创建一个头结点，便于处理，在程序最后返回：list.next即可
        ListNode listPre = list;
        ListNode l1=list1,pre1=null;
        ListNode l2=list2,pre2=null;
        
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){ //将l1指向的结点插在listPre后面
                pre1 = l1.next; //保存l1的后继
                l1.next = null; //孤立l1指向的结点
                listPre.next = l1;
                listPre = listPre.next;
                l1 = pre1;
            }else{
                pre2 = l2.next; //让pre2指向l2的后继
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














