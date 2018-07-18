package Priority_Queue;

public class Super_Ugly_Number_313 {
	//Array int[]index  14ms
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes==null||primes.length==0) return -1;
        int[]ugly=new int[n];
        int[]index=new int[primes.length];//each prime has an current index
        ugly[0]=1;
        for(int i=1;i<n;i++){//start from 1
            ugly[i]=Integer.MAX_VALUE;
            //each prime*current ugly[index]
            for(int j=0;j<primes.length;j++){
                if(primes[j]*ugly[index[j]]==ugly[i-1]){
                    index[j]++; //if =previous ugly number,move prime's index forward
                }
                ugly[i]=Math.min(ugly[i],primes[j]*ugly[index[j]]);
            }
        }
        return ugly[n-1];
    }
    
  //PriorityQueue 84ms
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes==null||primes.length==0) return -1;        
        Queue<int[]> pq=new PriorityQueue<>(primes.length,(a,b)->(a[0]-b[0]));
        int[]ugly=new int[n];
        ugly[0]=1;
        //a[0]:value, a[1]:index,a[2]:prime
        for(int j=0;j<primes.length;j++){
            pq.offer(new int[]{primes[j],1,primes[j]});
        }
        for(int i=1;i<n;i++){//start from 1
            ugly[i]=pq.peek()[0];
            //value*current ugly[index],index+1,prime stay
            while(pq.peek()[0]==ugly[i]){
                int[] temp=pq.poll();
                    pq.offer(new int[]{temp[2]*ugly[temp[1]],temp[1]+1,temp[2]});
                }                
            }
        return ugly[n-1];
        }
    
}
