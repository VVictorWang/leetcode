/**
 * Created by victor on 8/27/17.
 * email: chengyiwang@hustunque.com
 */

/*
* Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 Example:
 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example:
 Input: "cbbd"
 Output: "bb"
* */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char *subString(char *src, int start, int end){
    int length = (int) strlen(src);
    char *result;
    int i = 0;
    if (start < 0) //如果起始index小于0，则从初始开始
        start = 0;
    if (end > length) { //如果终止index超过源字符串长度，则切到末尾
        result = (char *) malloc(sizeof(char) * (length - start + 1));
        for (i = start; i < length; i++) {
            result[i - start] = src[i];
        }
    } else {
        result = (char *) malloc(sizeof(char) * (end - start + 1));
        for (i = start; i < end; i++) {
            result[i - start] = src[i];
        }
    }
    result[i - start] = '\0';
    return result;
}
int expandPalin(char *s, int left, int right) {
    int length = strlen(s);
    while (left >= 0 && right < length && s[left] == s[right]) {
        left--;
        right++;
    }
    return right - left - 1;
}

char* longestPalindrome(char* s) {
    int start = 0, end = 0;
    int length = strlen(s);
    for (int i = 0; i < length; i++) {
        int len1 = expandPalin(s, i, i);
        int len2 = expandPalin(s, i, i + 1);
        int len = len1 > len2 ? len1 : len2;
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return subString(s, start, end + 1);
}

int main() {
    char s[] = "huwgdwnxwguwhdqdioqwhdoiqnwhdiuqwhdidiwoqdowiqsjidqjowisidwqo";
    printf("%s", longestPalindrome(s));
    return 0;
}