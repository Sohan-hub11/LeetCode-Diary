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
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if(head == null || head.next == null)
            return head;

        // Step 1: Find list length and tail node
        
        int n = 0;
        ListNode curr = head;
        ListNode tail = null;
        // 1 -> 2-> 3 -> 4
        //n = 4
        while(curr != null){
            tail = curr; 
            curr = curr.next;
            n++;
        }

        // Step 2: Normalize k

        k = k % n;
        int steps = (n-k) % n;

        if(steps == 0)
            return head;
        
        // Step 3: Find the new tail (node just before the new head)

        ListNode newTail = head;
        for(int i=1; i<steps; i++){
            newTail = newTail.next;
        }

        // Step 4: Rewire pointers

        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}