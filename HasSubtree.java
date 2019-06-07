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
		//��Tree1��Tree2����Ϊ���ʱ�򣬲Ž��бȽ�
		if(root2!=null && root1!=null) {
			//��������ڵ�Ϊ����ж��Ƿ����Tree2
			if(root1.val == root2.val) {
				result = doesTree1HaveTree2(root1,root2);
			}
			
			//���root2����root1����ڵ�Ϊ���ڵ����������жϲ����������ٿ���root1.left�Ƿ���������
			if(!result) {
				result = hasSubTree(root1.left,root2);
			}
			
			//����root1.right
			if(!result) {
				result = hasSubTree(root1.right,root2);
			}
		}
		//���ؽ��
		return result;
	}
	
	public static boolean doesTree1HaveTree2(TreeNode tree1,TreeNode tree2) {
		//���tree2�������ˣ���ʾtree2�еĽڵ㶼����tree1�еĶ��ϣ�����true
		if(tree2 == null)
			return true;
		
		//tree2δ�����꣬��tree1�������ˣ�false
		if(tree1 == null) 
			return false;
		
		//��ǰ�ڵ㲻ƥ��
		if(tree1.val != tree2.val)
			return false;
		
		//���tree1.val == tree2.val�����������ӽڵ�
		return doesTree1HaveTree2(tree1.left,tree2.left) && doesTree1HaveTree2(tree2.left,tree2.right);
		
	}
	
}














