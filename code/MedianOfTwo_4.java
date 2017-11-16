/*
*There are two sorted arrays nums1 and nums2 of size m and n respectively.
*Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*Example 1:
*nums1 = [1, 3]
*nums2 = [2]
*The median is 2.0
*/

public class MedianOfTwo_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }
        int length = temp.length;
        if (length % 2 == 0) {
            return (temp[length / 2] + temp[length / 2 - 1]) / 2.0;
        } else
            return temp[length / 2];
    }

   
}