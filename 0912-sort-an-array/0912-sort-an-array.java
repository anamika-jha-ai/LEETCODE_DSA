class Solution {

    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int si, int ei) {

        // Base case
        if(si >= ei) {
            return;
        }

        // Find mid
        int mid = si + (ei - si) / 2;

        // Sort left half
        mergeSort(nums, si, mid);

        // Sort right half
        mergeSort(nums, mid + 1, ei);

        // Merge both sorted halves
        merge(nums, si, mid, ei);
    }

    public void merge(int[] nums, int si, int mid, int ei) {

        int temp[] = new int[ei - si + 1];

        int i = si;       // pointer for left half
        int j = mid + 1;  // pointer for right half
        int k = 0;        // pointer for temp array

        // Compare both halves
        while(i <= mid && j <= ei) {

            if(nums[i] < nums[j]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[j];
                j++;
            }

            k++;
        }

        // Copy remaining left half
        while(i <= mid) {
            temp[k] = nums[i];
            i++;
            k++;
        }

        // Copy remaining right half
        while(j <= ei) {
            temp[k] = nums[j];
            j++;
            k++;
        }

        // Copy temp back into original array
        for(int p = 0; p < temp.length; p++) {
            nums[si + p] = temp[p];
        }
    }
}