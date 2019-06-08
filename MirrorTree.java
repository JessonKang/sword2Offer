package sword2;

/*��Ŀ����������ľ��񣬼������е������������н���
 * �������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * 
 * ˼·�� 
 * 		��ǰ������������ÿ���ڵ㣬����������Ľڵ����ӽڵ㣬�ͽ������������ӽڵ㣬�����������з�Ҷ�ӽڵ�����ҽڵ�֮�󣬾͵õ������ľ���
 * 		ע�⣺�ݹ齻�����ڵ���������������񽻻�����������Ҫһ���м�����������������ҽڵ㽻��Ҳ����ˣ����´��롣
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
		//��Ϊ��
		if(tree == null)
			return ;
		
		//ע�������ǰ������������������˽���
		TreeNode tmp = tree.left;
		tree.left = tree.right;
		tree.right = tmp;
		
		//�ٶԽ�����������������������о������
		if(tree.left != null)
			mirror(tree.left);
		if(tree.right != null)
			mirror(tree.right);
		
	}
}
