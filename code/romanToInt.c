/*
 * Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
 * */

#include <stdio.h>
#include <string.h>

int romanToInt(char *s) {
    int res = 0;
    for (int i = strlen(s) - 1; i >= 0; i--) {
        char c = s[i];
        switch (c) {
            case 'I':
                res += (res >= 5 ? -1 : 1);
                break;
            case 'V':
                res += 5;
                break;
            case 'X':
                res += 10 * (res >= 50 ? -1 : 1);
                break;
            case 'L':
                res += 50;
                break;
            case 'C':
                res += 100 * (res >= 500 ? -1 : 1);
                break;
            case 'D':
                res += 500;
                break;
            case 'M':
                res += 1000;
                break;
            default:
                break;
        }
    }
    return res;
}


int main(int argc, char const *argv[]) {
    printf("%d", romanToInt("VI"));
    return 0;
}
