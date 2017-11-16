/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *convert(char *s, int numRows) {
    if (numRows == 1) {
        return s;
    }
    int size = strlen(s);
    char *result = (char *) malloc(sizeof(char) * (size + 1));
    int distance, distance2;
    int k = 0;
    for (int i = 0; i < numRows; ++i) {
        distance = 2 * (numRows - 1);
        distance2 = i ? distance - 2 * i : 0;
        for (int j = i; j < size; j += distance) {
            result[k++] = s[j];
            if ((distance2 != 0) && j + distance2 < size) {
                result[k++] = s[j + distance2];
            }
        }
    }
    result[k] = '\0';
    return result;
}

int main() {
    char s[] = "PAYPALISHIRING";
    printf("%s", convert(s, 3));
    return 0;
}