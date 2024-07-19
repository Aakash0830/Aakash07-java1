class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k=k%n;
        Reverse(nums,0,n-1);
        Reverse(nums,0,k-1);
        Reverse(nums,k,n-1);
    }
    public static void Reverse(int[] nums,int i,int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}