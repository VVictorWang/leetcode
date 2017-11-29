/*
 * @Author: victor 
 * @Date: 2017-11-30 05:23:59 
 * @Last Modified by: victor
 * @Last Modified time: 2017-11-30 05:25:01
 * 
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.

 * For example, given n = 3, a solution set is:
 *
 *[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 *]
 */
import java.util.ArrayList;
import java.util.List;

public class GenerateParenthese {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    if (n == 0)
      return result;
    backtrack(result, "", 0, 0, n);
    return result;
  }

  public void backtrack(List<String> list, String str, int open, int close,
                        int max) {

    if (str.length() == max * 2) {
      list.add(str);
      return;
    }

    if (open < max)
      backtrack(list, str + "(", open + 1, close, max);
    if (close < open)
      backtrack(list, str + ")", open, close + 1, max);
  }

  public static void main(String[] args) {
    System.out.print(new GenerateParenthese().generateParenthesis(0));
  }
}