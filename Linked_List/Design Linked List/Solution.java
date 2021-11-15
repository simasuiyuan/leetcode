class ListNode {
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
}
class MyLinkedList {
    // size of element, for checking illigle index
    int size;
    //this a dummy head
    ListNode dummyHead;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        size = 0;
        dummyHead = new ListNode(0);//here we define head node is a dummy node, not a real node!
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = dummyHead;// Note the head is a dummy node!
        for (int i = 0; i<=index; i++){
            currentNode = currentNode.next;// start from dummy node to scan, the desired node should @ index + 1 which is currentNode.next
        }
        return currentNode.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode newNode = new ListNode(val);
        ListNode currentNode = dummyHead;// Note the head is a dummy node!
        for (int i = 0; i<index; i++){
            currentNode = currentNode.next;// start from dummy node to scan, the desired node should @ index + 1 which is currentNode.next
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
        ListNode currentNode = dummyHead;// Note the head is a dummy node!
        for (int i = 0; i < index; i++){
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);


 */
public class Solution {
     
 }
 