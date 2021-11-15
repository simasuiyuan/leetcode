
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
//     public ListNode removeElements(ListNode head, int val) {
//         if (head == null) {
//             return head;
//         }
//         // create a dummy node before first node in case of removing first node
//         ListNode dummy = new ListNode(-1, head);
//         ListNode previous = dummy;
//         ListNode current = head;
//         while (current != null) {
//             if (current.val == val) {
//                 previous.next = current.next;
//             } else {
//                 previous = current;
//             }
//             current = current.next;
//         }
//         return dummy.next;
//     }
// }
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if(head == null) {
            return head;
        }
        // create a dummy node before first node in case of removing first node
        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }
}
