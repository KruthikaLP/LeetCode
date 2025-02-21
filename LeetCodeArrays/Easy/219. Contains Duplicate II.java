219. Contains Duplicate II
https://leetcode.com/problems/contains-duplicate-ii/description/

Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105

solutions:=
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Initialize a HashMap to store the last index of each element.
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate over each element in the array.
        for (int i = 0; i < nums.length; i++) {
            // If the current element is found in the map and satisfies the condition.
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true; // Found the pair.
            }
            // Update the current element's index in the map.
            map.put(nums[i], i);
        }
        
        // No such pair found, return false.
        return false;
    }
}

    
