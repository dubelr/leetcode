
/**
 * Number: 125
 * Title: Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/
 * Tags: Two Pointers, String
 * Difficulty: Easy
 * Content: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * 
 * Runtime: 13ms (50.62%)
 * Space: 45.5MB (40.33%)
 */

import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(String s) {
        // step 1: remove non-ascii characters
        ArrayList<Character> sArr = new ArrayList<>();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sArr.add(c);
            }
        }
        // step 2: iterate up to middle item,
        // checking from both sides if correct
        for (int i = 0; i < sArr.size() / 2; ++i) {
            if (sArr.get(i) != sArr.get(sArr.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

class SolutionImproved {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}