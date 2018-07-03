package String;

public class Roman_to_Integer_13 {
	//switch case
	public int romanToInt(String s) {       
        if(s==null||s.length()==0) return 0;
        
       int sum=charToint(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){  //from right to left
            if(charToint(s.charAt(i))<charToint(s.charAt(i+1))){
                sum-=charToint(s.charAt(i)); //if i<i+1, sum-
            }else{
                sum+=charToint(s.charAt(i)); //else sum+
            }                       
        }
        return sum;        
    }
    
    private int charToint(char c){
        switch(c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;   
    }

  //Hashmap
    public int romanToInt(String s) {
        Map<Character,Integer> mymap=new HashMap<Character,Integer>();
        mymap.put('I',1);
        mymap.put('V',5);
        mymap.put('X',10);
        mymap.put('L',50);
        mymap.put('C',100);
        mymap.put('D',500);
        mymap.put('M',1000);
        
        char[]c=s.toCharArray();
        
        int pre=mymap.get(c[0]);
        int sum=pre;
        for(int i=1;i<c.length;i++){ //from left to right
            int cur=mymap.get(c[i]);
            if(pre<cur) sum-=2*pre;  //if left<right, sum=sum-2*left
            sum+=cur;                //else sum=sum+cur
            pre=cur;
        }
        return sum;
    }
    
}
