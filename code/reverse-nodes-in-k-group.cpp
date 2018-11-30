/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 *
 * see https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
 * Runtime 16ms
 */
class Solution {
public:
    pair<ListNode *, ListNode *> reverserList(ListNode *head, int n) {
        if (n <= 1 || head == NULL) {
            return pair<ListNode *, ListNode *>(head, head);
        }
        ListNode *previous = head, *current = head->next, *next = NULL;
        int i = 1;
        while (current != NULL && i < n) {
            next = current->next;
            current->next = previous;
            previous = current;
            current = next;
            i++;
        }
        head->next = current;
        if (i < n) {
            head = previous;
            current = previous->next;
            next = NULL;
            i = 1;
            while (current != NULL && i < n) {
                next = current->next;
                current->next = previous;
                previous = current;
                current = next;
                i++;
            }
            head->next = current;
        }
        return pair<ListNode *, ListNode *>(previous, head);
    }


    ListNode *reverseKGroup(ListNode *head, int k) {
        if (head == NULL || k <= 0) {
            return head;
        }
        pair<ListNode *, ListNode *> result = reverserList(head, k);
        ListNode *p = result.second;
        while (p->next != NULL) {
            pair<ListNode *, ListNode *> temp = reverserList(p->next, k);
            p->next = temp.first;
            p = temp.second;
        }
        return result.first;
    }
};