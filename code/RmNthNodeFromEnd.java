
public class RmNthNodeFromEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode myhead = new ListNode(0);
    myhead.next = head;
    ListNode p = myhead;
    ListNode q = myhead;
    for (int i = 0; i <= n && p != null; i++) {
      p = p.next;
    }
    while (p != null) {
      p = p.next;
      q = q.next;
    }
    q.next = q.next.next;
    return myhead.next;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    // head.next.next = new ListNode(3);
    // head.next.next.next = new ListNode(4);

    ListNode node = new RmNthNodeFromEnd().removeNthFromEnd(head, 1);
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }
}

class ListNode {
  public int val;
  public ListNode next;
  public ListNode(int val) { this.val = val; }
}