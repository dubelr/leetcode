/**
* Number: 1
* Title: Two Sum
* Link: https://leetcode.com/problems/two-sum/
* Tags: Array, Hash Table
* Level: Easy
* Content: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* You may assume that each input would have exactly one solution, and you may not use the same element twice.
* 
* Runtime range: 1-4ms
* Runtime percentile range: 90-100%
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // hashmap < num, index >
        // iterate through nums [O(n)], determine if complement is in set [O(1)]
        // total time: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return null;       
    }
}