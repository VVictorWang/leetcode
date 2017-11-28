/*
 * @Author: victor 
 * @Date: 2017-11-29 05:16:20 
 * @Last Modified by: victor
 * @Last Modified time: 2017-11-29 05:16:44
 * 
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

public class MergeTwoSortedList {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode p1 = l1, p2 = l2, result = new ListNode(0);
    ListNode q = result;
    while (p1 != null && p2 != null) {
      if (p1.val <= p2.val) {
        q.next = new ListNode(p1.val);
        q = q.next;
        p1 = p1.next;
      } else {
        q.next = new ListNode(p2.val);
        q = q.next;
        p2 = p2.next;
      }
    }
    while (p1 != null) {
      q.next = new ListNode(p1.val);
      q = q.next;
      p1 = p1.next;
    }
    while (p2 != null) {
      q.next = new ListNode(p2.val);
      q = q.next;
      p2 = p2.next;
    }
    return result.next;
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(0);
    node1.next = new ListNode(9);

    ListNode node2 = new ListNode(3);
    node2.next = new ListNode(5);
    ListNode result = new MergeTwoSortedList().mergeTwoLists(node1, node2);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}

class ListNode {
  public int val;
  public ListNode next;
  ListNode(int x) { val = x; }
}