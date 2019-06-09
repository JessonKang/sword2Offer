package sword2offer.sword2Offer;

import java.util.Stack;

/*题目：实现一个能得到栈中最小元素的min函数，要求调用min、push、pop的时间复杂度都是O(1)
 * 思路：
 * 	错误想法：一开始自己把每个push进栈的元素都与栈顶元素进行比较，让最小的元素在栈顶，但是这样破坏了栈的结构，元素的顺序不再是先进后出了，所以不行。
 * 	正确思路：
 * 		维护两个栈，一个数据s、一个保存最小值的栈sMin
 * 		当push(node)时，如果sMin为空，或者node<sMin.peek()，则node直接push进sMin，即sMin的栈顶元素保存栈的最小值；如果node>=sMin.peek(),则直接再把sMin
 * 的栈顶元素进栈一次，让sMin的元素个数与s相同，具体见代码。
 * 
 * 
 * */
public class MinElementOfStack {
	    Stack<Integer> s = new Stack<Integer>(); //数据栈
	    Stack<Integer> sMin = new Stack<Integer>(); //最小值栈
	    public void push(int node) {
	        s.push(node); 
	        if(sMin.empty() || node<sMin.peek())
	            sMin.push(node);
	        else
	            sMin.push(sMin.peek()); //当前待入栈结点node大于sMin中的最小结点，因此把栈顶元素再入栈一次
	    }
	    
	    //出栈操作时二者都要pop
	    public void pop() { 
	        s.pop();
	        sMin.pop();
	    }
	    
	    public int top() {
	        return s.peek();
	    }
	    
	    public int min() {
	        return sMin.peek();
	    }
}
