package StackPriorityQueue;

public class Evaluate_Reverse_Polish_Notation_150 {
	public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop()+stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case "/":
                    int n1=stack.pop();
                    int n2=stack.pop();
                    stack.push(n2/n1);//can't use 1/n1*n2
                    break;            //1/n1 may be 0
                default:
                    stack.push(Integer.valueOf(tokens[i]));                    
            }
        }
       return stack.pop(); 
    }
}
