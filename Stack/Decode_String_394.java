package StackPriorityQueue;

public class Decode_String_394 {
	public String decodeString(String s) {
        if(s==null||s.length()==0) return new String();
        Deque<StringBuilder> strStack=new ArrayDeque<>();
        Deque<Integer> intStack=new ArrayDeque<>();
        //Until meet ']',record the current string that need to be repeated
        StringBuilder cur=new StringBuilder();
        int k=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                //eg 654=(6*10+5)*10+4
                k=k*10+c-'0';
            }else if(c=='['){       //begin of new next level
                intStack.push(k);
                strStack.push(cur); //parent
                cur=new StringBuilder();
                k=0;    //'[' means the next level, so cur and k all=0
            }else if(c==']'){    //end of this level
                StringBuilder temp=cur;  //current string that need to be repeated
                cur=strStack.pop();  //parent
               for(int i=intStack.pop();i>0;i--)
                    cur.append(temp);
            }else{  //letter
                cur.append(c);
            }
        }
        return cur.toString();
    }
	
	//Recursion
	private int pos=0; //pass value through recursion
    public String decodeString(String s) {
        StringBuilder res=new StringBuilder();
        int k=0;
        for(int i=pos;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                k=k*10+s.charAt(i)-'0';
            }else if(s.charAt(i)=='['){
                pos=i+1;  //recurtion start from next char
                String next=decodeString(s);
                while(k-->0) res.append(next);
                k=0;
                i=pos;
            }else if(s.charAt(i)==']'){
                pos=i;   //pass current position out
                return res.toString();
            }else{
                res.append(s.charAt(i));
            }
            
        }
        return res.toString();
    }  
}
