package sword2offer.sword2Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode{
	int val=0;
	TreeNode left=null;
	TreeNode right=null;
	TreeNode(int va){
		val = va;
	}
}

public class PrintFromTopToBottom {
	 public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         ArrayDeque<TreeNode> qu = new ArrayDeque<TreeNode>();
         if(root == null)
             return list;
         qu.add(root);
         while(qu.size() != 0){
             TreeNode tmpNode = qu.remove();
             list.add(tmpNode.val);
             
           //一定要判断左右子树是否为空，否则将引发空指针异常
             if(tmpNode.left != null) 
            	 qu.add(tmpNode.left);
             if(tmpNode.right != null)
            	 qu.add(tmpNode.right);
         }
         return list;
     }
	 public static void main(String[] args) {
		 //10,6,14,4,8,12,16
		 TreeNode n1 = new TreeNode(10);
		 TreeNode n2 = new TreeNode(6);
		 TreeNode n3 = new TreeNode(14);
		 TreeNode n4 = new TreeNode(4);
		 n1.left = n2;
		 n1.right = n3;
		 n2.left = n4;
		 
		 ArrayList<Integer> list = printFromTopToBottom(n1);
		 for(int item:list)
			 System.out.print(item+" ");
	}
}







