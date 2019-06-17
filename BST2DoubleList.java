package sword2;

/*��Ŀ������һ�ö�����������������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ�򡣣����������ͷ��㣩
 *˼·��
 *	�ڶ����������У����ڵ�ֵ�������ӽڵ㣬С�����ӽڵ㡣������ת����˫����������ʱ��ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ��ǰһ���ڵ��ָ�룬
 *ԭ��ָ�����ӽڵ��ָ�����Ϊ������ָ���һ���ڵ��ָ�롣Ҫ��������������������������������
 *	��1���������������˫��������������ͷ��㣻
 *	��2����λ��������˫�������һ���ڵ㣻
 *	��3�����������˫����Ϊ�յĻ�������ǰroot׷�ӵ�������������棻
 *	��4���������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
 *	��5�����������������Ƿ�Ϊ��ȷ�����صĽڵ㣻����Ϊ�Ƿ��������ͷ��㣩
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
		//1.�������������˫��������������ͷ���
		TreeNode left = convert(root.left);
		//��p��λ����������������һ���ڵ�
		TreeNode p = left;
		while(p!=null && p.right!=null)
			p = p.right;
		
		//������������Ϊ�գ�����ǰroot׷�ӵ��������������
		if(left!=null) {
			p.right = root;
			root.left = p;
		}
		
		//�������������˫��������������ͷ���
		TreeNode right = convert(root.right);
		if(right != null) {
			right.left = root;
			root.right = right;
		}
		return left != null ? left:root;//���������ͷ���
	}
}














