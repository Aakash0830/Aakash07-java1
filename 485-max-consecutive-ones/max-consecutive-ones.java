class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cunt = 0;
        int maxm =0;
        for (int i = 0;i<nums.length;i++){
            if(nums[i]==1){
                cunt++;
            }
            else{
                if(cunt>maxm){
                    maxm=cunt;
                }
                cunt=0;
            }
        } 
        return cunt>maxm ? cunt:maxm;
    }
}