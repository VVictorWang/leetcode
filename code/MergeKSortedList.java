/*
 * @Author: victor
 * @Date: 2017-12-01 04:55:14
 * @Last Modified by: victor
 * @Last Modified time: 2017-12-01 04:55:34
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 */

public class MergeKSortedList {
  public ListNode mergeKLists(ListNode[] lists) {
    int length = lists.length;
    // System.out.print(length/2);
    if (length == 1) {
      return lists[0];
    } else if (length > 2) {
      ListNode[] left = new ListNode[length / 2 + 1];
      ListNode[] right = new ListNode[length / 2 + 1];
      for (int i = 0; i < length; i++) {
        if (i < (length / 2))
          left[i] = lists[i];
        else
          right[i - length / 2] = lists[i];
      }
      ListNode leftNode = mergeKLists(left);
      ListNode rightNode = mergeKLists(right);
      ListNode[] temp = {leftNode, rightNode};
      return mergeKLists(temp);
    } else if (length == 2) {
      ListNode left = lists[0];
      ListNode right = lists[1];
      ListNode result = new ListNode(0);
      ListNode head = result;
      while (left != null && right != null) {
        if (left.val < right.val) {
          result.next = new ListNode(left.val);
          result = result.next;
          left = left.next;
        } else {
          result.next = new ListNode(right.val);
          result = result.next;
          right = right.next;
        }
      }
      while (left != null) {
        result.next = new ListNode(left.val);
        result = result.next;
        left = left.next;
      }
      while (right != null) {
        result.next = new ListNode(right.val);
        result = result.next;
        right = right.next;
      }
      return head.next;
    }
    return null;
  }
  public static void main(String[] args) {
    ListNode x1 = new ListNode(3);
    x1.next = new ListNode(6);
    ListNode x2 = new ListNode(4);
    x2.next = new ListNode(9);
    ListNode x3 = new ListNode(5);
    ListNode x4 = new ListNode(9);
    x4.next = new ListNode(10);
    ListNode[] data = {x1, x2, x3, x4};
    ListNode result = new MergeKSortedList().mergeKLists(data);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}