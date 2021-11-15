# Linked List Cycle II

* Finding cycle in Linked list else return null
* Finding the cycle start point index, if no cycle return -1

![循环链表](https://img-blog.csdnimg.cn/20200816110112704.png)

# idea

### 2 pointers: slow and fast
* slow pointer moves 1 step each iter
* fast pointer moves 2 steps each iter
  
**Cycle detection**
* if there is a cycle, the fast pointer will catch the slow pointer again
* ![141.环形链表](https://tva1.sinaimg.cn/large/008eGmZEly1goo4xglk9yg30fs0b6u0x.gif)

**Cycle starting index**
![142环形链表2](https://img-blog.csdnimg.cn/20210318162938397.png)

* slow pointer moves $N = x + y$ 
* fast pointer moves $M = x + y + n(y + z)$  (n indicates number of iterations fast point run through cycle to catch teh slow pointer)
* when fast pointer catch up slow pointer in cycle: $M = 2N$ (fast run twice moves than slow)
* $M = 2N$ -> $x + y + n(y + z) = 2(x+y)$ -> $x = (n-1)(y+z) + z$ 
  * where $y+z$ is the full cycle moves, 
  * $n-1$ is the no.of iteration fast pointer run through cycles moves before catch the slow
* $x == z$ -> cycle starting index
  * index1 @head (init node); index2 @meetpoint 
  * index1++; index2++ -> until index1 == index2 -> cycle start point!

~~~~
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        // int slowMove = 0;
        ListNode fastNode = head;
        // int fastMove = 0;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                ListNode index1 = fastNode; // distant from cycle start index -> meet point = z
                ListNode index2 = head;// distant from init index -> cycle start index = x
                // the cycle start at x = z
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
~~~~
