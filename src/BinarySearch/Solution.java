package BinarySearch;

public class Solution {
    public int firstBadVersion(int n) {
        int i=1,j=n;
        while(i<=j){
            int mid = (i+j)/2;
            if(isBadVersion(mid)){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
    }

    public boolean isPerfectSquare(int num) {
        if(num==1)return true;
        int i = 1, j = num-1;
        while(i<j){
            int mid = i + (j-i) /2;
            int midSqr = mid*mid;
            if(midSqr == num) return true;
            if(midSqr > num){
                j=mid;
            }
            if(midSqr < num){
                i=mid+1;
            }
        }
        return false;
    }


    public static boolean isBadVersion(int version){
        return version==1702766719;
    }
}
