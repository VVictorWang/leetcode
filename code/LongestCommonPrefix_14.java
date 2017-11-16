
/**
 * Created by victor on 9/5/17.
 * email: chengyiwang@hustunque.com
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 */
public class LongestCommonPrefix_14 {
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        if (strs.length != 0) {
            for (i = 0; i < getMinLength(strs); i++) {
                if (!isSame(strs, i))
                    break;
            }
        } else
            return "";
        return strs[0].substring(0, i);
    }

    public static int getMinLength(String[] strs) {
        int min = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        return min;
    }

    public static boolean isSame(String[] strs, int index) {
        for (int i = 1; i < strs.length; i++) {
            if (strs[0].charAt(index) != strs[i].charAt(index)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"abca", "acba"}));
    }
}