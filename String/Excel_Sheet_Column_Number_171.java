package LeetCode;

public class Excel_Sheet_Column_Number_171 {
	//math.pow
	public int titleToNumber(String s) {
        int l=s.length()-1;
        int sum=0,i=0;
        while(l>=0){
            sum+=(s.charAt(l)-'A'+1)*Math.pow(26,i++);
            l--;
        }
        return sum;
    }
	//result*26+差值
	public int titleToNumber(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
            result=result*26+(s.charAt(i)-'A'+1);
        }
        return result;
    }
	//recursion 1,ABC recursively call 26*titleToNumber(AB)+C的差值
	public int titleToNumber(String s) {
        return s.length()!=0? 26*titleToNumber(s.substring(0,s.length()-1))+s.charAt(s.length()-1)-'A'+1:0;
    }
	//recursion 2,ABC recursively call math.pow(26,l-1)*A+titleToNumber(BC)
	public int titleToNumber(String s) {
        return s.length()!=0? (int)Math.pow(26,s.length()-1)*(s.charAt(0)-'A'+1)+titleToNumber(s.substring(1)):0;
    }
}
