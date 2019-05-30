package sword2;

/*
 * 题目：https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 描述：根据题目给定的二叉树的先序遍历和中序遍历序列，构造出二叉树。先序序列pre:{1,2,4,7,3,5,6,8},中序in:{4,7,2,1,5,3,8,6}
 *	解题思路：递归的构造左子树和右子树。
 *		1.首先取pre的首元素pre[0]，这是整棵树的根节点。
 *		2.然后到in中寻找值等于pre[0]的节点，则此节点前边的元素即是根节点pre[0]左子树中的节点，后边的节点是根节点右子树中的节点。
 *		3.在pre[0]的左右子树中重复1，2步递归地构造左右子树，直到左右子树中的节点为空。
 *
 *
 * */
class TreeNode{
	private int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
	
	public int getVal() {
		return val;
	}
}

public class reConstructBinaryTree {
	public static TreeNode reConstructBinaryTree(int[] pre,int[] in) {
		TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
	}
	
	/**
	 * @param pre 先序遍历数组
	 * @param startPre 先序遍历序列在数组中的起始下标
	 * @param endPre 结尾下标
	 * @param in 中序遍历数组
	 * @param startIn 中序遍历序列起始下标
	 * @param endIn 结尾下标
	 * @return
	 */
	private static TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {
		if(startPre>endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]); //将先序遍历的第一个元素作为根节点
		
		//在中序遍历序列中找pre[startPre]，则该元素之前的元素就为左子树的节点，其后的节点为右子树的节点
		for(int i=startIn;i<=endIn;i++) {
			if(in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
				break;
			}
		}
		return root;
	}
	
	//-----------------main测试代码-------------------------------
	public static void Inorder(TreeNode root) {
		if(root.left != null)
			Inorder(root.left);
		System.out.print(root.getVal()+" ");
		if(root.right != null)
			Inorder(root.right);
	}
	
	public static void main(String[] args) {
		int[] pre = new int[]{1,2,4,7,3,5,6,8};
		int[] in  = new int[]{4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre,in);
		
		Inorder(root);
	}
	
}














