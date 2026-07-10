class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n==0 || n==1){
            return n;
        }
        int j = 0 ;
        for(int i = 0 ; i<n ; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
}