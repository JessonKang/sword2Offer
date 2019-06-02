package sword2;
/*
 * ��Ŀ1����̨�ף�һ�ο��Ե�1��̨�ף�Ҳ����������̨�ף�����̨����n�������ж���������n��̨�׵ķ�����
 * ��Ŀ2����̬��̨�ף�һ�ο�����1����2����...��n��̨�ף�����̨����n�������ж���������n��̨�׵ķ�����
 * 
 */
public class JumpFloor {
	//һ�ο�����1/2��̨��
	public static int jumpFloor1(int target) {
		if(target == 1)
			return 1;
		else if(target == 2)
			return 2;
		else
			return jumpFloor1(target-1)+jumpFloor1(target-2);
	}
	
	/*��̬��̨��
	 * f(1) = 1 //һ����1��
	 * f(2) = f(1) + f(0) //һ����1������һ����2����f(0)=f(2-2),��ʾһ�ΰ�2��̨�����꣬������Ҫ��f(0)=1
	 * f(3) = f(3-1) + f(3-2) + f(3-3) //һ��ѡ����1/2/3��
	 * ...
	 * f(n-1) = f((n-1)-1) + f((n-1)-2) + ... + f(2) + f(1) + f(0)
	 * 		  = f(n-2) + f(n-3) + ... + f(2) + f(1) + f(0) 
	 * 
	 * f(n)= f(n-1) + f(n-2) + ... + f(2) + f(1) + f(0)
	 * 
	 * ��f(n)��f(n-1)�ı��ʽ֪���Լ�f(n)Ϊ��
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
















