package Binary_Search;

public class First_Bad_Version_278 {
	public int firstBadVersion(int n) {
        int start=1,end=n;
        while(start<end){
            int mid=start+(end-start)/2;
            if(isBadVersion(mid)) end=mid;
            else start=mid+1;
        }
        return end; //at last, start=end
    }
}
