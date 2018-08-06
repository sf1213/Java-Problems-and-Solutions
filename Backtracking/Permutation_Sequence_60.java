package Backtracking;

public class Permutation_Sequence_60 {
	//9ms
	public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        List<Integer> number=new ArrayList<>();
        int factorial=1;
        for(int i=1;i<=n;i++){
            factorial*=i;    //{1,2,6,24,...,n!}
            number.add(i);   //{1,2,...,n}
        }
        int num=k-1;
        for(int i=0;i<n;i++){
            factorial/=n-i;       //factorial in this round
            int index=num/factorial;  //index in this round
            sb.append(number.remove(index));
            num-=index*factorial;   //How many numbers left          
        }
        return sb.toString();
    }
}
