package sword2;

/*
 * 题目来源：https://www.nowcoder.com/questionTerminal/4060ac7e3e404ad1a894ef3e17650423
 * 要求：给定一个字符串，用 "%20" 替换字符串中的空格。
 * 如：输入“how are you!”
 * 则输出为：“how%20are%20you!”
 * 
 *  思路：
 *  1.先将字符串转换为字符数组，如果是String类型，则调用toCharArray()方法，如果是StringBuffer类型，则调用
 *  	getChars(0,str.length(), chArr, 0)，注意这里的length是长度，不是标，所以不是：length()-1
 *  2.字符数组中空格的个数，然后计算出待返回的新数组的长度：len = str.length()+2*countBlank,并创建新数组
 *  3.遍历旧字符数组，如果字符是非空格，则赋给新数组的对应位置，如果为空格，则做相应赋值。
 * */

public class replaceSpace {
	    public static String replaceSpace(StringBuffer str) {

	    	char[] chArr = new char[str.length()];
	    	str.getChars(0,str.length(), chArr, 0); //注意这里的length是长度，不是标，所以不是：length()-1
	    	
	        int countBlank = 0; //统计空格个数
	        for(int i=0;i<str.length();i++){
	            if(chArr[i]==' ')
	                countBlank++;
	        }
	        
	        int len = str.length()+2*countBlank; //替换空格后的字符串长度
	        char[] newArr = new char[len+1];
	        
	        
	        for(int i=0,j=0;i<chArr.length && j<=len;i++) {
	        	if(chArr[i]==' ') {
	        		newArr[j++]='%';
	        		newArr[j++]='2';
	        		newArr[j++]='0';
	        	}
	        	else
	        		newArr[j++]=chArr[i];
	        }
	        
	        String str1 = new String(newArr);
	        return str1;
	    }
	    
	    public static void main(String[] args) {
			StringBuffer str = new StringBuffer("how are you!");
			System.out.println(str);
			System.out.println(replaceSpace(str));
			
		}
	        
}
