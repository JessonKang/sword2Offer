package sword2;

/*题目：求二叉树的镜像，即把所有的左右子树进行交换
 * 二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * 
 * 思路： 
 * 		先前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点，当交换完所有非叶子节点的左右节点之后，就得到了树的镜像。
 * 		注意：递归交换根节点的左右子树，就像交换两个整数需要一个中间变量，二叉树的左右节点交换也是如此，见下代码。
 * */
class TreeNode{
	int val=0;
	TreeNode left = null;
	TreeNode right = null;
	TreeNode(int va){
		val = va;
	}
}

public class MirrorTree {
	public void mirror(TreeNode tree) {
		//树为空
		if(tree == null)
			return ;
		
		//注意这里是把整个左右子树进行了交换
		TreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		
		//再对交换后的左子树和右子树进行镜像操作
		if(tree.left != null)
			mirror(tree.left);
		if(tree.right != null)
			mirror(tree.right);
		
	}
}
