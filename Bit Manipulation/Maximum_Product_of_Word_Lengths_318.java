package Bit_Manipulation;

public class Maximum_Product_of_Word_Lengths_318 {
	//Bit Manipulation, 12ms
	public int maxProduct(String[] words) {
        int[] value=new int[words.length];
        for(int i=0;i<words.length;i++){ //Transform word to int
            String str=words[i]; 
            for(int j=0;j<str.length();j++){ 
                value[i]|=1<<(str.charAt(j)-'a');
            }
        }
        int maxLen=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((value[i]&value[j])==0){
                    maxLen=Math.max(maxLen,words[i].length()*words[j].length());
                }
            }
        }
        return maxLen;
    }
}
