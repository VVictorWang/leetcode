import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

  public static List<String> letterCombinations(String digits) {
    String[] DIGITS2CHAR = {"",    "",    "abc",  "def", "ghi",
                            "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> prev = new ArrayList<>();
    prev.add("");
    for (int i = digits.length() - 1; i >= 0; i--) {
      String str =
          DIGITS2CHAR[Integer.parseInt(String.valueOf(digits.charAt(i)))];
      List<String> newList = new ArrayList<>();
      for (int j = 0, l = str.length(); j < l; j++) {
        for (String s : prev) {
          s = str.charAt(j) + s;
          newList.add(s);
        }
      }
      prev = newList;
    }
    prev.remove("");
    return prev;
  }

  public static void main(String[] args) {
    List<String> resut = letterCombinations("234");
    for (String s : resut)
      System.out.println(s);
  }
}