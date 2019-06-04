package sword2offer;

public class Power {
	public static double Power(double base,int n) {
		double res = 1,curr = base;
		int exponent;
		
		if(n==0)
			return 1; //�κ�����0�η�����1
		else if(n>0) { //���n<0��Ҫ��base^n������Ҫ����bash^(-n)��Ȼ����ȡ����
			exponent = n;
		}else{
			if(base == 0) {//nС��0����������base^(-n)�ĵ���������ĸ����Ϊ0
				System.out.print("��ĸ����Ϊ0");
				System.exit(0);
			}
			exponent = -n;
		}
		
		while(exponent != 0) {
			/*��������ָ��Ϊ32������32�η��ļ��۳���Ҫ��31�Σ�����˼·��
			 * 	�Ƿ���������Ļ�����ֱ�ӱ��ˣ����Ѿ������2^4,����֪n=32�������
			 *ֱ�ӷ�2^4*2^4 = 2^8�������������2^32�η�������Ҫע������nΪ��ż�������
			 * 
			 * 	�ж�exp����������ż��
			 * */
			if((exponent&1) == 1) //expΪ����
				res *= curr;
			curr *= curr; //expΪż������ֱ�ӽ���ǰ��curr����
			//ע�⣬��Ȼ�����Ƿ�����ˣ���ô�����exponent�Ĳ����Ͳ��Ǽ�һ�ˣ�
			//���ǳ�2����������λ�����2
			exponent >>= 1; 		
		}
		return n>=0 ? res:(1/res);
	}
	//----------main����----------------
	public static void main(String[] args) {
		System.out.println("2^0 = "+Power(2, 0));
		System.out.println("0^0 = "+Power(0, 0));
		System.out.println("2^4 = "+Power(2, 4));
		System.out.println("2^(-5) = "+Power(2, -5));
		System.out.println("0^(-2) = "+Power(0, -2));
	}
}
















