package Array;

public class Bulls_and_Cows_299 {
	public String getHint(String secret, String guess) {
        int[] number=new int[10];
        int bull=0,cow=0;
        for(int i=0;i<secret.length();i++){
            int s=secret.charAt(i)-'0';
            int g=guess.charAt(i)-'0';
            if(s==g) {
                bull++;
            }else{
                if(number[s]<0) cow++;
                if(number[g]>0) cow++;
                number[s]++;                
                number[g]--;                
            }
        }        
        return bull+"A"+cow+"B";
    }
	//Hashmap
	public String getHint(String secret, String guess) {
        Map<Integer,Integer> number=new HashMap<>();
        int bull=0,cow=0;
        for(int i=0;i<secret.length();i++){
            int s=secret.charAt(i)-'0';
            int g=guess.charAt(i)-'0';
            if(s==g) {
                bull++;
            }else{              
                number.put(s,number.getOrDefault(s,0)+1);
                if(number.get(s)<=0) cow++;
                number.put(g,number.getOrDefault(g,0)-1);
                if(number.get(g)>=0) cow++;               
            }
        }       
        return bull+"A"+cow+"B";
    }
}
