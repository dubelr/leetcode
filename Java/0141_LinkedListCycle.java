import java.util.HashSet;
import java.util.Set;

/**
 * Number: 141
 * Title:  Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 * Tags: 
 * Difficulty: Easy
 * Content: Given a linked list, determine if it has a cycle in it.
 * 
 * Original runtime: 15ms (5.01%)
 * Original space: 47.7MB (10.42%)
 * 
 * Improved runtime: 0ms (100%)
 * Improved space: 45.9MB (47.41%)
 */

class Solution {
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}

class OriginalSolution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode runner = head;
        while(runner != null) {
            if(visited.contains(runner)){
                return true;
            }
            visited.add(runner);
            runner = runner.next;
        }
        return false;
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

