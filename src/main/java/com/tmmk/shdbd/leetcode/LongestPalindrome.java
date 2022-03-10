package com.tmmk.shdbd.leetcode;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String p = "babad";
//        System.out.println(solve(p));
        p = "cbbd";
//        System.out.println(solve1(p));
//        System.out.println(solve1("a"));
//        System.out.println(solve1("ab"));
//        System.out.println(solve1("bb"));
//        System.out.println(solve1("ccc"));
//        System.out.println(solve1("aaabaaaa"));
        System.out.println(isPalindrome("tattarbrattat"));
//        System.out.println(solve1("oyxshtfvhudhhsnstwfxhdlhieqwaujxubhymmmuhpzjmjrwlapdlrnmzxprwkykmhcjozlivieafymrnixadlyomwvmoextitacntoopnldbhhzqsxkatwjmyzrvkhrwltapztwverlrnbownqhhdmuzwzynfdzdzgcjjxbwmziemkxhgsppdwureforlajyhucagmnxngmcxtzwrevgzdwzpbuxgkzdablbgzmjhnuvdaeonsotcwmazcpziuwjzgweygfvlqajzgujxsskaaduicsjyevqiwivrfvntmmbadqawskzrszhekrbdgdmfvszsypxhsaqeenogzegehuxifpkusuukrddouzshamsjukhagruhmwvrrrrvwmhurgahkujsmahszuoddrkuusukpfixuhegezgoneeqashxpyszsvfmdgdbrkehzsrzkswaqdabmmtnvfrviwiqveyjsciudaakssxjugzjaqlvfgyewgzjwuizpczamwctosnoeadvunhjmzgblbadzkgxubpzwdzgverwztxcmgnxnmgacuhyjalroferuwdppsghxkmeizmwbxjjcgzdzdfnyzwzumdhhqnwobnrlrevwtzpatlwrhkvrzymjwtakxsqzhhbdlnpootncatitxeomvwmoyldaxinrmyfaeivilzojchmkykwrpxzmnrldpalwrjmjzphummmyhbuxjuawqeihldhxfwtsnshhduhvfthsxyo"));
    }

    public static String solve(String s) {
        int length = s.length();
        String palindrome = s.substring(0, 1);
        int fromIdx, idx, last;
        for (int i = 0; i < length - 1; i++) {
            char item = s.charAt(i);
            fromIdx = i + 1;
            while (true) {
                idx = s.indexOf(item, fromIdx);
                last = s.lastIndexOf(item);
                if (idx == -1) {
                    break;
                }
                String pal = s.substring(i, idx + 1);
                if (isPalindrome(pal)) {
                    palindrome = pal.length() > palindrome.length() ? pal : palindrome;
                    if (idx == last && palindrome.length() > s.length() / 2) {
                        return palindrome;
                    }
                }
                fromIdx = idx + 1;
            }

        }
        return palindrome;
    }

    public static String solve1(String s) {
        int length = s.length();
        String palindrome = s.substring(0, 1);
        int last, endIdx;
        String sub = "";
        for (int i = 0; i < length - 1; i++) {
            char item = s.charAt(i);
            endIdx = length;
            while (true) {
                // abcdaba
                // 从字符串尾部开始匹配，优先匹配最大长度，匹配终止循环
                sub = s.substring(i, endIdx);
                last = sub.lastIndexOf(item);
                if (last <= 0 || sub.length() < palindrome.length()) {
                    break;
                }
                String pal = s.substring(i, i + last + 1);
                if (isPalindrome(pal)) {
                    // 剩余长度没有已匹配的长，可结束方法
                    palindrome = pal.length() > palindrome.length() ? pal : palindrome;
                    if (s.length() - i < palindrome.length()) {
                        return palindrome;
                    }
                    break;
                }
                endIdx = i + last;
            }

        }
        return palindrome;
    }

    // "tat tar rat tat"
    public static boolean isPalindrome(String p) {
        int size = p.length() / 2;
        int mod = p.length() % 2 + size;
        for (int i = 0; i < size; i++) {
            if (p.charAt(i) != p.charAt(p.length() - 1 - i)
                    || p.charAt(size - 1 - i) != p.charAt(mod + i)) {
                return false;
            }
        }
        return true;
    }

}
