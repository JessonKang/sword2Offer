package sword2;
/*
 * 题目1：跳台阶，一次可以调1个台阶，也可以跳两个台阶，给定台阶数n，计算有多少种跳完n级台阶的方法。
 * 题目2：变态跳台阶，一次可以跳1级、2级、...、n级台阶，给定台阶数n，计算有多少种跳完n级台阶的方法。
 * 
 */
public class JumpFloor {
	//一次可以跳1/2级台阶
	public static int jumpFloor1(int target) {
		if(target == 1)
			return 1;
		else if(target == 2)
			return 2;
		else
			return jumpFloor1(target-1)+jumpFloor1(target-2);
	}
	
	/*变态跳台阶
	 * f(1) = 1 //一次跳1级
	 * f(2) = f(1) + f(0) //一次跳1级，或一次跳2级，f(0)=f(2-2),表示一次把2级台阶跳完，所以先要置f(0)=1
	 * f(3) = f(3-1) + f(3-2) + f(3-3) //一次选择跳1/2/3级
	 * ...
	 * f(n-1) = f((n-1)-1) + f((n-1)-2) + ... + f(2) + f(1) + f(0)
	 * 		  = f(n-2) + f(n-3) + ... + f(2) + f(1) + f(0) 
	 * 
	 * f(n)= f(n-1) + f(n-2) + ... + f(2) + f(1) + f(0)
	 * 
	 * 由f(n)于f(n-1)的表达式知可以简化f(n)为：
	 * 		f(n) = f(n-1) + f(n-1)
	 *           = 2*f(n-1)
	 */
	public static int jumpFloor2(int target) {
		if(target == 0 || target == 1)
			return 1;
		else
			return 2*jumpFloor2(target-1);
	}
	public static void main(String[] args) {
		System.out.println("Simple jump floor:"+jumpFloor1(3));
		System.out.println("Hard jumpe floor:"+jumpFloor2(3));
	}
}
















