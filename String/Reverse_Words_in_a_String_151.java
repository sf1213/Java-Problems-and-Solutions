package String;

public class Reverse_Words_in_a_String_151 {
	//StringBuilder.append(), split(), trim()  7ms
	public String reverseWords(String s) {
        if(s==null) return null;
        StringBuilder res=new StringBuilder();
        String[] words=s.trim().split("\\s+"); //for one-or-more whitespace, this takes care of multiple spaces/tabs/newlines/etc
        for(int i=words.length-1;i>0;i--){
            res.append(words[i]).append(" ");               
        }
        return new String(res.append(words[0]));
    }
	
	//More concise JAVA build in library  9ms
	public String reverseWords(String s) {
        if(s==null) return null;
        String[] str=s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(str));
        return String.join(" ",str);
    }
	
	//no trim( ), no split( ), no StringBuilder  3ms
	public String reverseWords(String s) {
        char[]str=s.toCharArray();
        reverse(str,0,s.length()-1);
        int start=0;
        int end=0;
        for(int i=0;i<s.length();i++){
            if(str[i]!=' '){           //if current pointer i is letter
                str[end++]=str[i];
            }else if(i>0&&str[i-1]!=' '){   //if current pointer i is ' ', and its previous char is not ' '
                reverse(str,start,end-1);   //meaning it's the first space after word, reverse word
                str[end++]=' ';            //put one empty space after the word
                start=end;                 //make start point to the next position
            }
        }
        reverse(str,start,end-1);         //reverse the last word
        return new String(str,0,end>0&&str[end-1]==' '?end-1:end);
    
    }
    
    private void reverse(char[]a,int i,int j){
        while(i<j){
            char temp=a[i];
            a[i++]=a[j];
            a[j--]=temp;
        }
    }
}
