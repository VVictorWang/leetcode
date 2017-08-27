/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class AddTwoNumbers {
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int k;
        boolean flag = false;
        k = l1.val + l2.val;
        ListNode result = new ListNode(k % 10);
        ListNode head = result;
        if (k > 9) {
            flag = true;
        } else {
            flag = false;
        }
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null && l2 != null) {
            k = l1.val + l2.val;
            if(flag)
                k++;
            result.next = new ListNode(k % 10);
            result = result.next;
            if (k > 9) {
                flag = true;
            } else {
                flag = false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            k = l1.val;
            if(flag)
                k++;
            result.next = new ListNode(k % 10);
            result = result.next;
            if (k > 9) {
                flag = true;
            } else {
                flag = false;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            k = l2.val;
            if(flag)
                k++;
            result.next = new ListNode(k % 10);
            result = result.next;
            if (k > 9) {
                flag = true;
            } else {
                flag = false;
            }
            l2 = l2.next;
        }
        if(flag){
            result.next = new ListNode(1);
            result = result.next;
        }
        result.next = null;
        return head;
    }
    public static void main(String[] args) {
        ListNode s1= new ListNode(1);
        s1.next = new ListNode(4);
        ListNode s2 = new ListNode(2);
        s2.next = new ListNode(6);
        s2.next.next = new ListNode(8);
        ListNode result = addTwoNumbers(s1,s2);
        while(result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}