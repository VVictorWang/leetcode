//
// Created by wangchengyi on 2018/11/21.
// see https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
//

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if (head != NULL) {
            ListNode *p = head;
            while (p != NULL && p->next != NULL) {
                int value = p->val;
                p->val = p->next->val;
                p->next->val = value;
                p = p->next->next;
            }
        }
        return head;
    }
};