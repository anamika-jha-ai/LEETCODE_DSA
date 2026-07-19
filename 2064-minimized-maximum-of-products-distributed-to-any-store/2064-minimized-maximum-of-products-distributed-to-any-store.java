class Solution {

    public boolean isPossible(int[] quantities, int n, int limit) {

        int stores = 0;

        for (int quantity : quantities) {

            // Stores needed for this product type
            stores += (quantity + limit - 1) / limit;

            // Early exit if we already need too many stores
            if (stores > n) {
                return false;
            }
        }

        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        // Maximum quantity among all product types
        for (int quantity : quantities) {
            high = Math.max(high, quantity);
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(quantities, n, mid)) {
                ans = mid;
                high = mid - 1;   // Try a smaller maximum
            } else {
                low = mid + 1;    // Need a larger maximum
            }
        }

        return ans;
    }
}