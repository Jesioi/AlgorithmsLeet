class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) return findMedianSortedArrays(nums2, nums1);

        int left = 0;
        int right = n;

        while (left <= right) {
            int cut1 = left + (right - left) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];

            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l1 > r2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            } 

        }

        return 0.0;
    }
}
