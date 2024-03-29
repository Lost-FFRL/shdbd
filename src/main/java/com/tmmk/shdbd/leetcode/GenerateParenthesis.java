package com.tmmk.shdbd.leetcode;

import cn.hutool.http.webservice.SoapUtil;

import javax.management.MXBean;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 同时查看：22. 括号生成
 * <p>
 * 剑指 Offer II 085. 生成匹配的括号
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/IDBivT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Lost
 * @version 1.0.0
 * @date 2021-12-01 21:44
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis t = new GenerateParenthesis();
        // ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())",
        // "(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]
        //        System.out.println(t.ge2(4));
        // (((())))
        // ((() ()))
        // ()(( ()))
        // (())( )()
        System.out.println(t.ge3(1));
        System.out.println(1 << 2);
        System.out.println(Integer.parseInt("101010", 2));
    }

    public List<String> ge3(int n) {
        List<String> result = new ArrayList<>();
        // 假设：( = 1,) = 0, ()=10
        // 可推算出组合可能性最大与最小值，最大值：1100，最小值：1010
        String maxStr = "10";
        String minStr = "10";
        for (int i = 0; i < n - 1; i++) {
            maxStr = "1" + maxStr + "0";
            minStr = minStr + "10";
        }
        // 添加最大值与最小值
        if (maxStr.equals(minStr)) {
            // n = 1 的情况
            result.add(maxStr.replace("1", "(").replace("0", ")"));
        } else {
            result.add(maxStr.replace("1", "(").replace("0", ")"));
            result.add(minStr.replace("1", "(").replace("0", ")"));
        }
        int max = Integer.parseInt(maxStr, 2);
        int min = Integer.parseInt(minStr, 2);

        char[] stack = new char[n + 1];
        // 1不可能结尾，过滤掉奇数，步长为2，求出所有合法的组合
        for (int i = min + 2; i < max; i = i + 2) {
            // 过滤 1与0的统计值不等于N的
            char[] chars = Integer.toBinaryString(i).toCharArray();
            // 首位必然为chars[0] = '1'，跳过计算
            int oneNum = 1;
            int index = 1;
            boolean flag = true;
            stack[0] = chars[0];
            // 数组循环，示例：['1','1','1','0','0','0']
            for (int j = 1; j < chars.length - 1; j++) {
                // 总数统计'1' 出现的次数，只能等于N
                if (chars[0] == chars[j]) {
                    oneNum++;
                }
                if (oneNum > n) {
                    flag = false;
                    break;
                }
                // 10 组合消除，不相等，入栈，相等消除
                if (index == 0) {
                    if (chars[0] != chars[j]) {
                        flag = false;
                        break;
                    }
                    stack[index] = chars[j];
                    index++;
                } else {
                    if (stack[index - 1] == chars[j]) {
                        stack[index] = chars[j];
                        index++;
                    } else {
                        index--;
                    }
                }
            }
            if (flag && oneNum == n) {
                result.add(String.valueOf(chars).replace("1", "(").replace("0", ")"));
            }
        }
        return result;
    }

    public List<String> ge2(int n) {
        int size = n * 2;
        String value = "";
        for (int i = 0; i < n; i++) {
            value = "(" + value + ")";
        }
        char[] container = value.toCharArray();
        Set<String> result = new HashSet<>(size);
        result.add(value);
        char tmp;
        int num = 0;
        for (int i = n - 1; i < size - 2; i++) {
            tmp = container[i];
            container[i] = container[i + 1];
            container[i + 1] = tmp;
            char[] in = Arrays.copyOf(container, size);
            result.add(String.valueOf(in));
            for (int j = 0; j <= num; j++) {
                System.out.println("i=" + i + ",j=" + j + ",num=" + num + ": " + String.valueOf(in));
                in = add(result, in, n - 1 + j, j * 2 + 1, num);
            }
            num++;
        }
        return new ArrayList<>(result);
    }

    public char[] add(Set<String> result, char[] param, int start, int end, int num) {
        if (start <= end) {
            return param;
        }
        char tmp = param[start];
        param[start] = param[start - 1];
        param[start - 1] = tmp;
        result.add(String.valueOf(param));
        System.out.println("** s=" + start + ",e=" + end + ",num=" + num + ": " + String.valueOf(param));
        return add(result, Arrays.copyOf(param, param.length), --start, end, num);
    }

    public String arr2str(String[] param) {
        StringBuilder sb = new StringBuilder();
        for (String s : param) {
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> generateParenthesis(int n) {
        // 行不通
        String[] container = new String[n * 2];
        for (int i = 0; i < n; i++) {
            container[i] = "(";
            container[2 * n - 1 - i] = ")";
        }
        Set<String> result = new HashSet<>(n * (n - 1));
        result.add(arr2str(container));
        String tmp;
        for (int i = n - 1; i < 2 * n - 2; i++) {
            tmp = container[i];
            container[i] = container[i + 1];
            container[i + 1] = tmp;
            String[] in = Arrays.copyOf(container, n * 2);
            result.add(arr2str(in));
            System.out.println("i=" + i + " : " + arr2str(in));
            for (int j = n - 2; j > 0; j--) {
                tmp = in[j];
                in[j] = in[j + 1];
                in[j + 1] = tmp;
                result.add(arr2str(in));
                System.out.println("j=" + j + " : " + arr2str(in));
            }
        }
        return new ArrayList<>(result);
    }

}
