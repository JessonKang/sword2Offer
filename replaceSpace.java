package sword2;

/*
 * ��Ŀ��Դ��https://www.nowcoder.com/questionTerminal/4060ac7e3e404ad1a894ef3e17650423
 * Ҫ�󣺸���һ���ַ������� "%20" �滻�ַ����еĿո�
 * �磺���롰how are you!��
 * �����Ϊ����how%20are%20you!��
 * 
 *  ˼·��
 *  1.�Ƚ��ַ���ת��Ϊ�ַ����飬�����String���ͣ������toCharArray()�����������StringBuffer���ͣ������
 *  	getChars(0,str.length(), chArr, 0)��ע�������length�ǳ��ȣ����Ǳ꣬���Բ��ǣ�length()-1
 * 	2.�ַ������пո�ĸ�����Ȼ�����������ص�������ĳ��ȣ�len = str.length()+2*countBlank,������������
 *  3.�������ַ����飬����ַ��Ƿǿո��򸳸�������Ķ�Ӧλ�ã����Ϊ�ո�������Ӧ��ֵ��
 * */

public class replaceSpace {
	    public static String replaceSpace(StringBuffer str) {

	    	char[] chArr = new char[str.length()];
	    	str.getChars(0,str.length(), chArr, 0); //ע�������length�ǳ��ȣ����Ǳ꣬���Բ��ǣ�length()-1
	    	
	        int countBlank = 0; //ͳ�ƿո����
	        for(int i=0;i<str.length();i++){
	            if(chArr[i]==' ')
	                countBlank++;
	        }
	        
	        int len = str.length()+2*countBlank; //�滻�ո����ַ�������
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
