package sword2offer.sword2Offer;
import java.util.Stack;

/*题目：
 * 	输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序。
 * 案例：
 * 	压栈序列：1,2,3,4,5	出栈序列：4,5,3,2,1
 *思路：
 *	借用一个辅助栈，同时设置一个遍历出栈序列的索引popIndex(初始为0)，遍历压栈顺序，先将第一个放入辅助栈中，这里是1，然后判断栈顶元素（即1）是否等于出栈序列的第一个元素（即4），
 *不相等，则继续对压栈序列的下一个元素进行压栈，直到栈顶元素与popIndex指向的元素相等后开始出栈，出栈的同时popIndex后移，直到栈顶元素与popIndex指向的元素不相等，这样
 *循环到压栈序列遍历完，如果辅助栈为空，则出栈序列是压栈序列的一种情况，否则不是。
 * 	   
 * 
 * */
public class StackPushAndPop {
	public boolean isPopOrder(int[] pushA,int[] popA) {
		//注意：看到任何一道题都要考虑输入的各种情况
		if(pushA.length==0 || popA.length==0)
			return false;
		
		Stack<Integer> s = new Stack<Integer>(); //辅助栈
		int popIndex = 0; //遍历popA序列的下标
		for(int i=0;i<pushA.length;++i) {
			s.push(pushA[i]); //
			while(!s.empty() || s.peek()==popA[popIndex]) {
				s.pop();
				popIndex++;
			}
		}
		return s.empty();
	}
}
