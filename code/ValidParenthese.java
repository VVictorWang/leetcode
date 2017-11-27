/*
 * @Author: victor
 * @Date: 2017-11-28 04:50:42
 * @Last Modified by: victor
 * @Last Modified time: 2017-11-28 04:52:28
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
import java.util.Stack;

public class ValidParenthese {
  public boolean isValid(String s) {
    Stack<Character> characters = new Stack<>();
    characters.push('0');
    char[] strs = s.toCharArray();
    for (int i = 0; i < strs.length; i++) {
      if (strs[i] == '(' || strs[i] == '[' || strs[i] == '{')
        characters.push(strs[i]);
      else if (strs[i] == ')') {
        while (!characters.isEmpty()) {
          if (characters.peek() == '{' || characters.peek() == '[')
            return false;
          if (characters.pop() == '(')
            break;
        }
        if (characters.isEmpty())
          return false;
      } else if (strs[i] == ']') {
        while (!characters.isEmpty()) {
          if (characters.peek() == '{' || characters.peek() == '(')
            return false;
          if (characters.pop() == '[')
            break;
        }
        if (characters.isEmpty())
          return false;
      } else if (strs[i] == '}') {
        while (!characters.isEmpty()) {
          if (characters.peek() == '(' || characters.peek() == '[')
            return false;
          if (characters.pop() == '{')
            break;
        }
        if (characters.isEmpty())
          return false;
      }
    }
    characters.pop();
    if (!characters.isEmpty())
      return false;
    return true;
  }

  public static void main(String[] args) {
    String s = "{}";
    System.out.println(new ValidParenthese().isValid(s));
  }
}