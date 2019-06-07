package sword2;

class TreeNode{
	int val=0;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
}

public class HasSubtree {
	public static boolean hasSubTree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		//当Tree1和Tree2都不为零的时候，才进行比较
		if(root2!=null && root1!=null) {
			//以这个根节点为起点判断是否包含Tree2
			if(root1.val == root2.val) {
				result = doesTree1HaveTree2(root1,root2);
			}
			
			//如果root2是以root1这个节点为根节点的子树这个判断不成立，则再考察root1.left是否满足条件
			if(!result) {
				result = hasSubTree(root1.left,root2);
			}
			
			//考察root1.right
			if(!result) {
				result = hasSubTree(root1.right,root2);
			}
		}
		//返回结果
		return result;
	}
	
	public static boolean doesTree1HaveTree2(TreeNode tree1,TreeNode tree2) {
		//如果tree2遍历完了，表示tree2中的节点都能与tree1中的对上，返回true
		if(tree2 == null)
			return true;
		
		//tree2未遍历完，但tree1遍历完了，false
		if(tree1 == null) 
			return false;
		
		//当前节点不匹配
		if(tree1.val != tree2.val)
			return false;
		
		//如果tree1.val == tree2.val，继续考察子节点
		return doesTree1HaveTree2(tree1.left,tree2.left) && doesTree1HaveTree2(tree2.left,tree2.right);
		
	}
	
}














