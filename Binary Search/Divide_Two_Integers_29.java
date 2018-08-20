package Binary_Search;

public class Divide_Two_Integers_29 {
	//倍增法
	public int divide(int dividend, int divisor) {
        //corer case: divisor == 0 or -2^31 / -1
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        //在这里必须先取long再abs，否则int的最小值abs后overflow
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        long res = 0;
        while(dvd >= dvs){
            long tmp = dvs, num = 1;
            while(dvd >= (tmp << 1)){
                tmp <<= 1; //tmp = tmp * 2
                num <<= 1; //num = num * 2
            }
            dvd -= tmp;
            res += num;
        }
        
        return sign == 1 ? (int)res : (int)-res;
            
    }
}
