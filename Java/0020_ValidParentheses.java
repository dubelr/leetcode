/**
* Number: 20
* Title:  Valid Parentheses
* Link: https://leetcode.com/problems/valid-parentheses/
* Tags: String, Stack
* Difficulty: Easy
* Content: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
* An input string is valid if: 
* Open brackets must be closed by the same type of brackets.
* Open brackets must be closed in the correct order.
* Every close bracket has a corresponding open bracket of the same type.
* 
* Runtime: 2-3ms (79-92%)
*/
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // to store the closing brackets in expected order
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            switch(c){
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if(stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}