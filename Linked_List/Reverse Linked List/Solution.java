// //Iteratively
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode previousNode = null;
//         ListNode currentNode = head;
//         ListNode temp;
//         while (currentNode != null) {
//             temp = currentNode.next;
//             currentNode.next = previousNode;
//             previousNode = currentNode;
//             currentNode = temp;
//         }
//         return previousNode;
//     }
// }

//Recursivly
class Solution {
    public ListNode reverse(ListNode previousNode, ListNode currentNode) {
        if (currentNode ==null) {
            return previousNode;
        }
        ListNode temp = currentNode.next;
        currentNode.next = previousNode;
        //Compare to Iteratively solution 
        //previousNode = currentNode;
        //currentNode = temp;
        return reverse(currentNode, temp);
    }
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }
}
