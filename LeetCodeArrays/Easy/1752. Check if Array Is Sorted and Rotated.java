1752. Check if Array Is Sorted and Rotated
https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description

Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.
There may be duplicates in the original array.
Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

Example 1:
Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100

solution:=
class Solution {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])  //For a valid rotated array, the last element needs to be compared with the first element to check for the "rotation break."
                count++;
            if (count > 1) 
                return false;
        }
        
        return true;

    }
}

Example:
Given the array [3, 4, 5, 1, 2], the comparisons are:

3 < 4 → No break
4 < 5 → No break
5 > 1 → Break occurs here (rotation)
1 < 2 → No break
Compare 2 and 3 (wrap-around comparison) → No break
The array is valid because there’s only one break in the order (5 > 1).

Without wrapping (i.e., comparing the last element to the first), we wouldn’t catch the break in the rotation.
