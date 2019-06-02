package sword2;
/* 题目来源：https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 
 * 思路：这里仍然是斐波那契数列的问题（下面的分析中，对于矩形的形状，把target当成底，2当成高比较好理解）
 *	1、如果target=0,更大的矩形为2*target=0，则 return 0；
 *	2、如果target=1,则return 1，刚好一个2*1的小矩形进行覆盖；
 *	3、如果target=2，即大矩形的形状为2*2，则可以横着放两个小矩形，也可以竖着放两个小矩形，两种放法return 2;
 *	4、如果target >= 2,则大矩形的形状为 target*2，设总放法为f(target)
 *		当选择把小矩形矩形竖着放时，则有f(target-1)种
 *		当选择把小矩形横着放时，则这个小矩形下面的空位置的摆放是固定的，即只能横着摆放，则有f(target-2)种放法
 * 
 * 注意：这种经典的递归问题，写代码的时候应该尽量写成非递归形式
 * 		1.递归形式基本上大家都会写，没什么意思；
 * 		2.递归存在大量的重复计算，需要的时间更长，还可能导致栈溢出。
 * */
public class RectCover {
	//递归版
	public static int  rectCoverRecur(int target) {
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2)
			return 2;
		
		return rectCoverRecur(target-1)+rectCoverRecur(target-2);
	}
	
	//迭代版
	public static int rectCoverIter(int target) {
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2)
			return 2;
		
		int fOne = 1;
		int fTwo = 2;
		int fSum = 0;
		
		for(int i=3;i<=target;++i) {
			fSum = fOne + fTwo;
			
			fOne = fTwo;
			fTwo = fSum;
		}
		return fSum;
	}
	//--------------main测试---------------------
	public static void main(String[] args) {
		System.out.println("the number:" + rectCoverRecur(3));
		System.out.println("the number:" + rectCoverIter(3));
		
	}
	
}











