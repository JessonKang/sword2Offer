package sword2offer;

public class Power {
	public static double Power(double base,int n) {
		double res = 1,curr = base;
		int exponent;
		
		if(n==0)
			return 1; //任何数的0次方都是1
		else if(n>0) { //如果n<0，要求base^n，则需要先求bash^(-n)，然后再取倒数
			exponent = n;
		}else{
			if(base == 0) {//n小于0则后面求的是base^(-n)的倒数，而分母不能为0
				System.out.print("分母不能为0");
				System.exit(0);
			}
			exponent = -n;
		}
		
		while(exponent != 0) {
			/*如果输入的指数为32，则求32次方的简单累乘需要做31次，换个思路：
			 * 	是否可以在它的基础上直接倍乘，如已经求得了2^4,且已知n=32，则可以
			 *直接放2^4*2^4 = 2^8，依此类推求出2^32次方，不过要注意区分n为奇偶数的情况
			 * 
			 * 	判断exp是奇数还是偶数
			 * */
			if((exponent&1) == 1) //exp为奇数
				res *= curr;
			curr *= curr; //exp为偶数，则直接将当前的curr翻倍
			//注意，既然上面是翻倍相乘，那么这里对exponent的操作就不是减一了，
			//而是除2，这里用移位代替除2
			exponent >>= 1; 		
		}
		return n>=0 ? res:(1/res);
	}
	//----------main测试----------------
	public static void main(String[] args) {
		System.out.println("2^0 = "+Power(2, 0));
		System.out.println("0^0 = "+Power(0, 0));
		System.out.println("2^4 = "+Power(2, 4));
		System.out.println("2^(-5) = "+Power(2, -5));
		System.out.println("0^(-2) = "+Power(0, -2));
	}
}
















