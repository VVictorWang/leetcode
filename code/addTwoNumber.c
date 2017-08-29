/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *Output: 7 -> 0 -> 8
 * Definition for singly-linked list.
 */
#include <stdio.h>
#include <stdlib.h>
struct ListNode
{
	int val;
	struct ListNode *next;
};

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    int k;
    int flag = 0;
    k = l1->val + l2->val;
    struct ListNode *result = (struct ListNode *)malloc(sizeof(struct ListNode));
    result->val = k % 10;
    struct ListNode *head = result;
    if (k > 9) {
    	flag = 1;
    } else {
		flag = 0;
	}
    l1 = l1->next;
    l2 = l2->next;
    while (l1 != NULL && l2 != NULL) {
        k = l1->val + l2->val;
        if(flag)
        	k++;
        result->next = (struct ListNode *)malloc(sizeof(struct ListNode));
        result->next->val = k % 10;
        result = result->next;
        if (k > 9) {
            flag = 1;
        } else {
            flag = 0;
        }
        l1 = l1->next;
        l2 = l2->next;
    }
    while (l1 != NULL) {
        k = l1->val;
         if(flag)
        	k++;
        result->next = (struct ListNode *)malloc(sizeof(struct ListNode));
        result->next->val = k % 10;
        result = result->next;
        if (k > 9) {
            flag = 1;
        } else {
            flag = 0;
        }
        l1 = l1->next;
    }
    while (l2 != NULL) {
        k = l2->val;
         if(flag)
        	k++;
        result->next = (struct ListNode *)malloc(sizeof(struct ListNode));
        result->next->val = k % 10;
        result = result->next;
        if (k > 9) {
            flag = 1;
        } else {
            flag = 0;
        }
        l2 = l2->next;
    }
    if(flag){
    	result->next = (struct ListNode *)malloc(sizeof(struct ListNode));
    	result->next->val = 1;
    	result = result->next;
    }
    result->next = NULL;
    return head;
}

int main(){
	struct ListNode * s1 = (struct ListNode *)malloc(sizeof(struct ListNode));
	s1->val = 5;
	// s1->next->val = 4;
	// s1->next->next->val = 3;

	struct ListNode * s2 = (struct ListNode *)malloc(sizeof(struct ListNode));
	// s2->next = (struct ListNode *)malloc(sizeof(struct ListNode));
	// s2->next->next = (struct ListNode *)malloc(sizeof(struct ListNode));
	s2->val = 5;
	// s2->next->val = 5;	
	// s2->next->next->val = 4;

	struct ListNode *result =addTwoNumbers(s1,s2);
	while(result!=NULL){
		printf("%d\n",result->val );
		result = result->next;
	}
	return 0;
}
