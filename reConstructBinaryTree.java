package sword2;

/*
 * ��Ŀ��https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * ������������Ŀ�����Ķ��������������������������У����������������������pre:{1,2,4,7,3,5,6,8},����in:{4,7,2,1,5,3,8,6}
 *	����˼·���ݹ�Ĺ�������������������
 *		1.����ȡpre����Ԫ��pre[0]�������������ĸ��ڵ㡣
 *		2.Ȼ��in��Ѱ��ֵ����pre[0]�Ľڵ㣬��˽ڵ�ǰ�ߵ�Ԫ�ؼ��Ǹ��ڵ�pre[0]�������еĽڵ㣬��ߵĽڵ��Ǹ��ڵ��������еĽڵ㡣
 *		3.��pre[0]�������������ظ�1��2���ݹ�ع�������������ֱ�����������еĽڵ�Ϊ�ա�
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
	 * @param pre �����������
	 * @param startPre ������������������е���ʼ�±�
	 * @param endPre ��β�±�
	 * @param in �����������
	 * @param startIn �������������ʼ�±�
	 * @param endIn ��β�±�
	 * @return
	 */
	private static TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {
		if(startPre>endPre || startIn > endIn)
			return null;
		TreeNode root = new TreeNode(pre[startPre]); //����������ĵ�һ��Ԫ����Ϊ���ڵ�
		
		//�����������������pre[startPre]�����Ԫ��֮ǰ��Ԫ�ؾ�Ϊ�������Ľڵ㣬���Ľڵ�Ϊ�������Ľڵ�
		for(int i=startIn;i<=endIn;i++) {
			if(in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
				break;
			}
		}
		return root;
	}
	
	//-----------------main���Դ���-------------------------------
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














