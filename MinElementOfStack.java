package sword2offer.sword2Offer;

import java.util.Stack;

/*��Ŀ��ʵ��һ���ܵõ�ջ����СԪ�ص�min������Ҫ�����min��push��pop��ʱ�临�Ӷȶ���O(1)
 * ˼·��
 * 	�����뷨��һ��ʼ�Լ���ÿ��push��ջ��Ԫ�ض���ջ��Ԫ�ؽ��бȽϣ�����С��Ԫ����ջ�������������ƻ���ջ�Ľṹ��Ԫ�ص�˳�������Ƚ�����ˣ����Բ��С�
 * 	��ȷ˼·��
 * 		ά������ջ��һ������s��һ��������Сֵ��ջsMin
 * 		��push(node)ʱ�����sMinΪ�գ�����node<sMin.peek()����nodeֱ��push��sMin����sMin��ջ��Ԫ�ر���ջ����Сֵ�����node>=sMin.peek(),��ֱ���ٰ�sMin
 * ��ջ��Ԫ�ؽ�ջһ�Σ���sMin��Ԫ�ظ�����s��ͬ����������롣
 * 
 * 
 * */
public class MinElementOfStack {
	    Stack<Integer> s = new Stack<Integer>(); //����ջ
	    Stack<Integer> sMin = new Stack<Integer>(); //��Сֵջ
	    public void push(int node) {
	        s.push(node); 
	        if(sMin.empty() || node<sMin.peek())
	            sMin.push(node);
	        else
	            sMin.push(sMin.peek()); //��ǰ����ջ���node����sMin�е���С��㣬��˰�ջ��Ԫ������ջһ��
	    }
	    
	    //��ջ����ʱ���߶�Ҫpop
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
