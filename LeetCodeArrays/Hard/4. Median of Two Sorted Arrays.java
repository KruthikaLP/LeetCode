4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=problem-list-v2&envId=array
  
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

solutions:=
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length, n = nums2.length;
      int c[] = new int[m+n];
      int j=0;
      int i=0,k=0;
     while(i<m && k<n){
        if(nums1[i]<nums2[k]){
            c[j] = nums1[i];
            j++;
            i++;
        }
        else{
            c[j] = nums2[k];
            j++; 
            k++;
        }
      }
      while(i<m){
         c[j] = nums1[i];
            j++;
            i++;
      }
      while(k<n){
         c[j] = nums2[k];
            j++; 
            k++;
      }
      int mid = (m+n)/2;
        if((m+n) % 2 == 0)
        {
            return (double)(c[mid] + c[mid-1])/2;
        }
        return (double)c[mid];
    }
}
