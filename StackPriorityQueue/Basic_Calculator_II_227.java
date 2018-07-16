package StackPriorityQueue;

public class Basic_Calculator_II_227 {
	//Stack
    public int calculate(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
        int sum=0,num=0;
        char sign='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            //when encounter "+-*/" or the last index, add num to sum
            if("+-*/".indexOf(c)>=0||i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    sum-=stack.peek();
                    stack.push(stack.pop()*num);
                }else{
                    sum-=stack.peek();
                    stack.push(stack.pop()/num);
                }
                sum+=stack.peek();
                sign=c;
                num=0;
            }
        }
        return sum;
    }
    
  //No Stack
    public int calculate(String s) {
        int sum=0,num=0;
        int pre=0; //prev is equivalent as stack.peek()
        char sign='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+c-'0';
            }
            //when encounter "+-*/" or the last index, add num to sum
            if("+-*/".indexOf(c)>=0||i==s.length()-1){
                if(sign=='+'){
                    pre=num;
                }else if(sign=='-'){
                    pre=-num;
                }else if(sign=='*'){
                    sum-=pre;
                    pre*=num;
                }else{
                    sum-=pre;
                    pre/=num;
                }
                sum+=pre;
                sign=c;
                num=0;
            }
        }
        return sum;
    }
}
