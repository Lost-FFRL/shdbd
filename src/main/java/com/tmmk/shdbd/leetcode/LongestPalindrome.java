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
        System.out.println(solve(p));
        p = "cbbd";
        System.out.println(solve(p));
        System.out.println(solve("a"));
        System.out.println(solve("ab"));
        System.out.println(solve("bb"));
        System.out.println(solve("ccc"));
        System.out.println(solve("aaaaa"));
        System.out.println(solve("ababababa"));
        System.out.println(solve("oyxshtfvhudhhsnstwfxhdlhieqwaujxubhymmmuhpzjmjrwlapdlrnmzxprwkykmhcjozlivieafymrnixadlyomwvmoextitacntoopnldbhhzqsxkatwjmyzrvkhrwltapztwverlrnbownqhhdmuzwzynfdzdzgcjjxbwmziemkxhgsppdwureforlajyhucagmnxngmcxtzwrevgzdwzpbuxgkzdablbgzmjhnuvdaeonsotcwmazcpziuwjzgweygfvlqajzgujxsskaaduicsjyevqiwivrfvntmmbadqawskzrszhekrbdgdmfvszsypxhsaqeenogzegehuxifpkusuukrddouzshamsjukhagruhmwvrrrrvwmhurgahkujsmahszuoddrkuusukpfixuhegezgoneeqashxpyszsvfmdgdbrkehzsrzkswaqdabmmtnvfrviwiqveyjsciudaakssxjugzjaqlvfgyewgzjwuizpczamwctosnoeadvunhjmzgblbadzkgxubpzwdzgverwztxcmgnxnmgacuhyjalroferuwdppsghxkmeizmwbxjjcgzdzdfnyzwzumdhhqnwobnrlrevwtzpatlwrhkvrzymjwtakxsqzhhbdlnpootncatitxeomvwmoyldaxinrmyfaeivilzojchmkykwrpxzmnrldpalwrjmjzphummmyhbuxjuawqeihldhxfwtsnshhduhvfthsxyo"));
    }

    public static String solve(String s) {
        int length = s.length();
        String palindrome = s.substring(0, 1);
        int fromIdx, idx,last;
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

    public static boolean isPalindrome(String p) {
        int size = p.length() / 2;
        for (int i = 0; i < size; i++) {
            if (p.charAt(i) != p.charAt(p.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}
