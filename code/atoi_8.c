/*
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
       You are responsible to gather all the input requirements up front.
 * */

#include <stdio.h>
#include <limits.h>

int myAtoi(char *str) {
    int result = 0, i = 0, flag = 0;
    while (str[i] == ' ')
        i++;
    if (str[i] == '-') {
        i++;
        flag = 1;
    } else if (str[i] == '+')
        i++;
    while (str[i] != '\0') {
        if ((str[i] >= '0' && str[i] <= '9')) {
            if (result >= (INT_MAX / 10 - (str[i] - '0') + 7)) {
                if (flag && result > (INT_MAX / 10 - (str[i] - '0') + 7)) {
                    return INT_MIN;
                }
                return flag ? -INT_MAX : INT_MAX;
            }
            result *= 10;
            result += str[i++] - '0';
        } else {
            return flag ? -result : result;
        }
    }
    return flag ? -result : result;
}

int main(int argc, char const *argv[]) {
    char str[] = "-2147483649";
    printf("%d\n", myAtoi(str));
    return 0;
}
