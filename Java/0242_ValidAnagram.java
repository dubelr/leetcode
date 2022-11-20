import java.util.Arrays;

/**
 * Number: 242
 * Title: Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 * Tags: Hash Table, String, Sorting
 * Difficulty: Easy
 * Content: Given two strings s and t, return true if t is an anagram of s, and
 * false otherwise.An Anagram is a word or phrase formed by rearranging the
 * letters of a different word or phrase, typically using all the original
 * letters exactly once.
 * Runtime: 11ms (58.49%)
 * Space: 4575MB (24.22%)
 */

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for (int i = 0; i < sArr.length; ++i) {
            if (sArr[i] != tArr[i]) {
                return false;
            }
        }
        return true;

    }
}

class SolutionImproved {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];
        for (char c : s.toCharArray()) {
            a[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            a[c - 'a']--;
        }
        for (int n : a) {
            if (n != 0)
                return false;
        }
        return true;
    }
}