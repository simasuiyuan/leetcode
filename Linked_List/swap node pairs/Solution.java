/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// class Solution {

//     public ListNode swapPairs(ListNode head) {
//         ListNode dummyNode = new ListNode(0, head);
//         ListNode prev = dummyNode;
//         while(prev.next != null && prev.next.next != null) {
//             ListNode temp = head.next.next;
//             prev.next = head.next;
//             head.next.next = head;
//             head.next = temp;
//             prev = head;
//             head = head.next;
//         }
//         return dummyNode.next;
//     }
// }

class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head==null ||  head.next==null) return head;
        ListNode nextNode = head.next;
        ListNode newNode = swapPairs(nextNode.next);//this  one leads to new head.next.next
        nextNode.next = head;
        head.next = newNode;
        return nextNode;
    }
}
