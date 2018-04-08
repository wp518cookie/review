package algo.kmp;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/4/8.
 */
public class StringKmp {
    public static void main(String[] args) {
        System.out.println(kmp("abcababcabcabc", "abcabcabc"));
    }

    public static int kmp(String source, String pattern) {
        int i = 0, j = 0;
        char[] src = source.toCharArray();
        char[] ptn = pattern.toCharArray();
        int sLen = src.length;
        int pLen = ptn.length;
        int[] next = next(ptn);
        while (i < sLen && j < pLen) {
            // 如果j = -1,或者当前字符匹配成功(src[i] = ptn[j]),都让i++,j++
            if (j == -1 || src[i] == ptn[j]) {
                i++;
                j++;
            } else {
                // 如果j!=-1且当前字符匹配失败,则令i不变,j=next[j],即让pattern模式串右移j-next[j]个单位
                j = next[j];
            }
        }
        if (j == pLen)
            return i - j;
        return -1;
    }

    private static int[] next(char[] sub) {
        int len = sub.length;
        int[] next = new int[len];
        int k = -1;
        int j = 0;
        next[0] = -1;
        while (j < len - 1) {
            if (k == -1 || sub[j] == sub[k]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        System.out.println(Arrays.toString(next));
        return next;
    }
}
