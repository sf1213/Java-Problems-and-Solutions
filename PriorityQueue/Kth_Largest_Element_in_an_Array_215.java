package Priority_Queue;

public class Kth_Largest_Element_in_an_Array_215 {
	//Arrays.sort  4ms
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        return nums[n-k];
    }
    
    //PriorityQueue  8ms
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
            if(pq.size()>k) pq.poll();
        }
        return pq.peek();
    }
    
  //Simple QuickSort 5ms
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);//random nums
        k=nums.length-k;
        int lo=0;
        int hi=nums.length-1;
        while(lo<hi){
            int j=partition(nums,lo,hi);
            if(j<k) lo=j+1;
            else if(j>k) hi=j-1;
            else break;
        }
        return nums[k];
    }
    //a[0] ~ a[k-1] <= pivot; a[k+1] ~ a[n-1] >= pivot
    private int partition(int[]a,int lo,int hi){
        int i=lo;
        int j=hi+1;
        int pivot=a[lo];
        while(i<j){
            do{i++;} while(a[i]<pivot&&(i<hi));
            do{j--;} while(a[j]>pivot); //no need to require j>lo
            if(i<j) swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }
    
    private void swap(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    private void shuffle(int[]a){
        Random random=new Random();
        for(int i=0;i<a.length;i++){
            int r=random.nextInt(i+1);
            swap(a,i,r);
        }
    }
    
  //three-way QuickSort 8ms
    public int findKthLargest(int[] nums, int k) {
        k=nums.length-k;
        shuffle(nums);//random nums  
        return partition(nums,0,nums.length-1,k);
    }
    //a[0] ~ a[lt-1] <pivot; a[lt] ~ a[gt] = pivot; a[gt+1] ~ a[n-1] > pivot
    private int partition(int[]a,int lo,int hi,int k){
        int pivot=a[lo];
        int lt=lo;
        int gt=hi;
        int i=lo+1;
       
        while(i<=gt){
            if(a[i]<pivot) swap(a,i++,lt++);
            else if(a[i]>pivot) swap(a,i,gt--);
            else i++;
        }
        if(k>gt) return partition(a,gt+1,hi,k);
        else if(k<lt) return partition(a,lo,gt-1,k);
        else return a[lt];
    }
    
    private void swap(int[]a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    private void shuffle(int[]a){
        Random random=new Random();
        for(int i=0;i<a.length;i++){
            int r=random.nextInt(i+1);
            swap(a,i,r);
        }
    }
}
