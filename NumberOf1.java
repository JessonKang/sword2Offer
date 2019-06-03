package sword2;

public class NumberOf1 {
	    public int NumberOf1(int n) {
	        /*解法1：当输入的n为负数时会陷入死循环，因为负数的补码的最高位为1，向右移位的时候高位会补符号位
	         * 每一次把n往右移动一位，然后跟1做与运算，判断最右边的位是否为1，统计为1的个数。
	        int count=0;
	        while(n!=0){
	            if((n&1) != 0)
	                count++;
	            n = n>>1;
	        }
	        return count;
	        */
	        
	        /*解法2：32的整数需要循环32次
	         * 这次是每次把1往左边移动一位，然后与n做与运算，根据结果判断n的该位是否为1，统计1的个数。
	         * int count = 0;
	        int flag = 1;
	        while(flag != 0){
	            if((n&flag) != 0)
	                count++;
	            flag = flag<<1;
	        }
	        return count;*/
	        
	        /*解法3：用到了位运算的小技巧
			        即：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0，那么一个整数的二进制
			        表示中有多少个1，就可以进行多少次这样的操作。
	        */
	        int count = 0;
	        while(n != 0){
	            count++;
	            n = (n-1) & n;
	        }
	        return count;
	   }
}














}
