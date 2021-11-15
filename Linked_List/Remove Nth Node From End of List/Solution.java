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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode slowNode = dummyNode;
        ListNode fastNode = dummyNode;
        for (int i=0; i<=n; i++){
            fastNode = fastNode.next;
        }
        while(fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyNode.next;
    }
}
