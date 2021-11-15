# Remove Linked List Elements

## Linked list
~~~~
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
~~~~

### problem 
~~~~
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
    }
}
~~~~

## solution



### Badsic 

* **Rmove Operation**: 
  * previous_node 
  * current_node
  * if current_node.val == val to be removed: previous_node.nex = current_node.next

#### **how to handle the first node? -> if it is the node to be removed**

##### Solution 1. Adding dummy node
* Time complexity = O(n)
* Space Complexity = O(1)
* previous = dummy
* current = head
* (while current != null) 
  * if current == val: previous.next = current.next
  * previous = current; current = current.next
* return dummy.next (<- this will be start as head)

##### Solution 2. Without dummy node
* Time complexity = O(n)
* Space Complexity = O(1)
* while(head != null && head.val == val): head = head.next (get next node that is not null and not the node to be removed)
* previous = dummy
* current = head
* (while current != null) 
  * if current == val: previous.next = current.next
  * previous = current; current = current.next
* return head