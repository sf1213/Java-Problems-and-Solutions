package Priority_Queue;

public class Find_K_Pairs_with_Smallest_Sums_373 {
	//PriorityQueue brutal force:O(n1*n2*log(n1*n2-k))   lambda-77ms, comparator-24ms
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {       
        List<int[]> res=new ArrayList<>();
         if(nums1==null||nums2==null) return res;
        //Comparater:a[0]+a[1]
        // Queue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]+a[1]-(b[0]+b[1])));
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() { // comparator fast
			public int compare(int[] a, int[] b) {
				return a[0] + a[1] - (b[0] + b[1]);
			}
		});
        int n=nums1.length*nums2.length;
        for(int n1:nums1){
            for(int n2:nums2){
                pq.offer(new int[]{n1,n2});
                if(pq.size()>n-k){
                    res.add(pq.poll());
                }
            }
        }
        return res;
    }
    
  //PriorityQueue clever:O(klog(k))  lambda-54ms, comparator-4ms
  
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {       
        List<int[]> res=new ArrayList<>();
         if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return res;
        //Comparater:a[0]+a[1], a[2]:index of nums1
        //Queue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]+a[1]-(b[0]+b[1])));//lambda slow
        Queue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){  //comparator fast
            public int compare(int[]a,int[]b){
                return a[0]+a[1]-(b[0]+b[1]);
            }
                                            });
        for(int i=0;i<nums2.length&&i<k;i++){
            pq.offer(new int[]{nums1[0],nums2[i],0});
        }
        while(k-->0&&!pq.isEmpty()){ //!pq.isEmpty() if for:k>l1*l2
            int[] cur=pq.poll();
            res.add(new int[]{cur[0],cur[1]});
            //complete traverse nums1,no need to offer, just continue poll
            if(cur[2]==nums1.length-1) continue;
            pq.offer(new int[]{nums1[cur[2]+1],cur[1],cur[2]+1});
        }
        return res;
        }
}
