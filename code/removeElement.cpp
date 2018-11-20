//
// Created by wangchengyi on 2018/11/20.
//

/**
 * See https://leetcode.com/problems/remove-element/
 */
class Solution {
public:
    int removeElement(vector<int> &nums, int val) {
        vector<int>::iterator item;
        int i = 0;
        for (item = nums.begin(); item != nums.end(); item++) {
            if (*item == val) {
                nums.erase(nums.begin() + i);
                item--;
            } else {
                i++;
            }
        }
        return nums.size();
    }
};