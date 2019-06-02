package sword2;
/* ��Ŀ��Դ��https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * ��Ŀ�����ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * 
 * ˼·��������Ȼ��쳲��������е����⣨����ķ����У����ھ��ε���״����target���ɵף�2���ɸ߱ȽϺ���⣩
 *	1�����target=0,����ľ���Ϊ2*target=0���� return 0��
 *	2�����target=1,��return 1���պ�һ��2*1��С���ν��и��ǣ�
 *	3�����target=2��������ε���״Ϊ2*2������Ժ��ŷ�����С���Σ�Ҳ�������ŷ�����С���Σ����ַŷ�return 2;
 *	4�����target >= 2,�����ε���״Ϊ target*2�����ܷŷ�Ϊf(target)
 *		��ѡ���С���ξ������ŷ�ʱ������f(target-1)��
 *		��ѡ���С���κ��ŷ�ʱ�������С��������Ŀ�λ�õİڷ��ǹ̶��ģ���ֻ�ܺ��Űڷţ�����f(target-2)�ַŷ�
 * 
 * ע�⣺���־���ĵݹ����⣬д�����ʱ��Ӧ�þ���д�ɷǵݹ���ʽ
 * 		1.�ݹ���ʽ�����ϴ�Ҷ���д��ûʲô��˼��
 * 		2.�ݹ���ڴ������ظ����㣬��Ҫ��ʱ������������ܵ���ջ�����
 * */
public class RectCover {
	//�ݹ��
	public static int  rectCoverRecur(int target) {
		if(target == 0)
			return 0;
		if(target == 1)
			return 1;
		if(target == 2)
			return 2;
		
		return rectCoverRecur(target-1)+rectCoverRecur(target-2);
	}
	
	//������
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
	//--------------main����---------------------
	public static void main(String[] args) {
		System.out.println("the number:" + rectCoverRecur(3));
		System.out.println("the number:" + rectCoverIter(3));
		
	}
	
}











