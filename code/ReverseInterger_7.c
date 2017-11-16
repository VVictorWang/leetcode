/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Note:
The input is assumed to be a 32-bit signed integer.
Your function should return 0 when the reversed integer overflows.
 * 
 * */

#include <stdio.h>
#include <limits.h>

int reverse(int x) {
    int temp = x > 0 ? x : -x;
    int result = 0;
    while (temp > 0) {
        if (result > (INT_MAX / 10 - temp % 10 + 1)) {
            return 0;
        }
        result *= 10;
        result += temp % 10;
        temp /= 10;
    }
    return x > 0 ? result : -result;
}

int main() {
    int x = 1463847412;
    printf("%d\n", reverse(x));
    return 0;
}