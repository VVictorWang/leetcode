/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <limits.h>

char *intToStr(int m) {
    char temp[20], *result;
    if (m == INT_MIN) {
        char *s = intToStr(INT_MIN + 1);
        s[strlen(s) - 1] += 1;
        return s;
    }
    int i = 0, flag = 0;
    if (m < 0) {
        flag = 1;
        m = -m;
    }
    while (m > 0) {
        temp[i++] = (char) (m % 10 + '0');
        m /= 10;
    }
    if (flag) {
        temp[i++] = '-';
    }
    temp[i] = '\0';
    i--;
    int j = 0;
    result = (char *) malloc(sizeof(char) * (strlen(temp) + 1));
    for (j = 0; i >= 0; j++, i--) {
        result[j] = temp[i];
    }
    result[j] = '\0';
    return result;
}

int isPalindrome(int x) {
    char *s = intToStr(x);
    printf("%s\n", s);
    int length = strlen(s);
    int i = 0;
    for (i = 0; i < length / 2; i++) {
        if (s[i] != s[length - i - 1]) {
            return 0;
        }
    }
    return 1;
}

int main(int argc, char const *argv[]) {
    int x = INT_MIN;
    printf("%d\n", x);
    printf("%d\n", isPalindrome(x));
    return 0;
}
