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
    private int len(ListNode head)
    {
        int counter = 0;
        ListNode temp = head;
        while(temp != null)
        {
            counter++;
            temp = temp.next;
        }
        return counter;
    }
    private ListNode getNode(int index, ListNode head)
    {
        ListNode temp = head;
        for(int i=1; i<=index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        int i = 0;
        int j = len(head) - 1;
        while(i < j)
        {
            ListNode leftNode = getNode(i, head);
            ListNode rightNode = getNode(j, head);
            int temp = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = temp;
            i++;
            j--;
        }
        return head;
    }
}
