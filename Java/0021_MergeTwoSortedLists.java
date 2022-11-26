/*
* Number: 21
* Title:  Merge Two Sorted Lists
* Link: https://leetcode.com/problems/merge-two-sorted-lists/
* Tags: 
* Difficultyw: 
* Content: You are given the heads of two sorted linked lists list1 and list2. Merge the two lists 
* in a one sorted list. The list should be made by splicing together the nodes of the first two lists. 
* Return the head of the merged linked list.
* 
* Runtime: 1ms (81.82%)
* Space: 42-43MB (8%)
*/

/*
* Avoid recursion next time in favor of runner approach. Wasted time on grabbing last item from 
* newList every time. It's easy to make .next mistakes vs .[get last node]. Recursion doesn't
* improve runtime but does waste space w stack calls. Also easy to accidentally decouple listTail
* from listHead
*/
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return mergeTwoListsHelper(null, list1, list2);
    }

    private ListNode mergeTwoListsHelper(ListNode newList, ListNode list1, ListNode list2) {
        // case: l1 & 2 are null -> newList
        if (list1 == null && list2 == null) {
            return newList;
        }
        // case: l1 is null -> newList + l2
        if (list1 == null && list2 != null) {
            if (newList == null) {
                return list2;
            }
            getLast(newList).next = list2;
            return newList;
        }
        // case: l2 is null -> newList + l1
        if (list2 == null) {
            if (newList == null) {
                return list1;
            }
            getLast(newList).next = list1;
            return newList;
        }
        // case: l1, l2 non-null; newList null -> set it to min of l1, l2, increment
        // runner
        if (newList == null) {
            if (list1.val < list2.val) {
                newList = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newList = new ListNode(list2.val);
                list2 = list2.next;
            }
            return mergeTwoListsHelper(newList, list1, list2);
        }
        // else: all inputs are non-null -> return newList + pull min from (l1,l2) +
        // recur
        if (list1.val < list2.val) {
            getLast(newList).next = new ListNode(list1.val);
            list1 = list1.next;

        } else {
            getLast(newList).next = new ListNode(list2.val);
            list2 = list2.next;
        }
        return mergeTwoListsHelper(newList, list1, list2);
    }

    private ListNode getLast(ListNode list) {
        ListNode toReturn = list;
        if (list == null) {
            return null;
        }
        while (list.next != null) {
            toReturn = list.next;
            list = list.next;
        }
        return toReturn;
    }

    private String printLinkedList(ListNode list) {
        String toReturn = "[";
        while (list != null) {
            toReturn += (list.val);
            list = list.next;
        }
        toReturn += ("]");
        return toReturn;
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}