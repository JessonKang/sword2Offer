package sword2;
/*题目：输入一个整数数组，判断该数组是不是某二叉搜素树的后续遍历的结果，返回ture或false。
 *思路：
 *	注意在后续遍历得到的序列中，最后一个数字是树的根节点的值。数组中前面的数字可以分为两部分：
 *	第一部分是左子树节点的值，他们都比根节点值小；第二部分是右子树节点的值，他们都比根节点值大。
 *	（1）根据根节点的值划分出左子树序列和右子树序列；
 *	（2）	然后判断右子树序列中是否存在比根节点小的值，如果存在则返回false；
 *	（3）递归判断左子树序列和右子树序列是否满足条件
 * 
 * 
 * */
public class VerifySequenceOfBST {
	public static boolean verifySequenceOfBST(int[] sequence) {
		if(sequence.length==0)	return false;
		return isTreeBST(sequence,0,sequence.length-1);
	}
	/**
	 * @param sequence 遍历序列
	 * @param start	开始下标
	 * @param end	结尾下标
	 * @return
	 */
	public static boolean isTreeBST(int[] sequence,int start,int end) {
		/*当start == end时，表示这一部分比较完了
		 *这里有点类似于归并排序；因为树的定义是递归的，当对一个节点进行判断时，由于左右子树都为空，所以就为BST，return true
		 * 
		 * */
		if(start == end)	return true;
		
		int root = sequence[end]; //根节点
		
		int i = start; //i用来保存右子树序列中的第一个节点，即i前的节点都为小于根节点的左子树节点
		for(;i<end;i++) //end是根节点，不参与比较，所以判断条件为 i<end
			if(sequence[i] > root) break;
		
		//判断序列的右子树序列节点是否都大于根节点
		int j = i;
		for(;j<end;j++)
			if(sequence[j] < root) return false;
		
		//递归判断左子树序列和右子树序列是否都满足条件
		/*注意从上面的计算可知，i指向的是大于根节点的第一个节点，即右子树序列中的节点，所以在判断左子树时传入的参数为（start,i-1）;
		 * end指向的是根节点，不再参与下一次的判断，故判断右子树传入的参数为（i,end-1）;
		 * 
		 * */
		return isTreeBST(sequence,start,i-1) && isTreeBST(sequence,i,end-1);
	}
}




