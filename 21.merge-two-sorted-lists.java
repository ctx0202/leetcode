/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
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
    // Loop through two ListNodes and maintain the index on each one
    // Compare, if h1 > h2, then move h1 to the next one; else move h2 to the next one
    // If h1 || h2 is null, add the remaining to the current index
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode head1 = list1, head2 = list2;
        while(head1 != null && head2 != null){
            if(head1.val > head2.val) {
                cur.next = new ListNode(head2.val);
                head2 = head2.next;
            }else {
                cur.next = new ListNode(head1.val);
                head1 = head1.next;
            }
            cur = cur.next;
        }
        if(head1 != null) {
            cur.next = head1;
        }
        if(head2 != null) {
            cur.next = head2;
        }
        return dummy.next;
    }
}
// @lc code=end

