package sword2;

/*题目：输入一棵二叉搜素树，将该树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。（返回链表的头结点）
 *思路：
 *	在二叉搜素树中，根节点值大于左子节点，小于右子节点。所以在转换成双向有序链表时，原先指向左子节点的指针调整为链表中指向前一个节点的指针，
 *原先指向右子节点的指针调整为链表中指向后一个节点的指针。要让链表有序，因此中序遍历二叉搜素树。
 *	（1）将左子树构造成双链表，并返回链表头结点；
 *	（2）定位至左子树双链表最后一个节点；
 *	（3）如果左子树双链表不为空的话，将当前root追加到左子树链表后面；
 *	（4）如果右子树链表不为空的话，将该链表追加到root节点之后；
 *	（5）根据左子树链表是否为空确定返回的节点；（因为是返回链表的头结点）
 * 
 * */
class TreeNode{
	int val=0;
	TreeNode left=null;
	TreeNode right=null;
	public TreeNode(int val) {
		this.val = val;
	}
}

public class BST2DoubleList {
	public TreeNode convert(TreeNode root) {
		if(root == null)
			return null;
		if(root.left==null && root.right==null)
			return root;
		//1.将左子树构造成双链表，并返回链表头结点
		TreeNode left = convert(root.left);
		//将p定位到左子树链表的最后一个节点
		TreeNode p = left;
		while(p!=null && p.right!=null)
			p = p.right;
		
		//若左子树链表不为空，将当前root追加到左子树链表后面
		if(left!=null) {
			p.right = root;
			root.left = p;
		}
		
		//将右子树构造成双链表，并返回链表头结点
		TreeNode right = convert(root.right);
		if(right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left:root;//返回链表的头结点
	}
}














