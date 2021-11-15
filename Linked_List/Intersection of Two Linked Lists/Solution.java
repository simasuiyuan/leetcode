/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int lengthOfLinkedListRec(ListNode head) {
        ListNode temp=head;
        if(temp==null) {
            return 0;
        } else {
            return 1+ lengthOfLinkedListRec(temp.next);
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = lengthOfLinkedListRec(headA);
        int lenB = lengthOfLinkedListRec(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        // let the curA be the longest linked list and lenA will be its length
        if (lenB > lenA) {
            int tempLen = lenA;
            ListNode tempCur = curA;
            lenA = lenB;
            lenB = tempLen;
            curA = curB;
            curB = tempCur;
        }
        for(int gap=(lenA-lenB); gap>0; gap--) {
            curA = curA.next; // align A B cursors
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}