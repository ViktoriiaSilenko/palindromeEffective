package com.task;

import java.util.Arrays;
import java.util.Objects;

public class PalindromeUtils {

    public boolean isStringPalindrome(String str) {
        return Objects.equals(str, findLongestPalindrome(str));
    }

    public String findLongestPalindrome(String str) {
        if ((str==null) || (str.length()==0)) {
            return "";
        }

        char[] str2 = addBoundaries(str.toCharArray());
        int[] p = new int[str2.length];
        int c = 0, r = 0;
        int m = 0, n = 0;

        for (int i = 1; i < str2.length; i++) {
            if (i > r) {
                p[i] = 0;
                m = i-1;
                n = i+1;
            } else {
                int i2 = c*2-i;
                if (p[i2] < (r-i)) {
                    p[i] = p[i2];
                    m = -1;
                } else {
                    p[i] = r-i;
                    n = r+1;
                    m = i*2-n;
                }
            }
            while ((m >= 0) && (n < str2.length) && (str2[m] == str2[n])) {
                p[i]++;
                m--;
                n++;
            }
            if ((i+p[i]) > r) {
                c = i;
                r = i+p[i];
            }
        }
        int len = 0;
        c = 0;
        for (int i = 1; i < str2.length; i++) {
            if (len<p[i]) {
                len = p[i];
                c = i;
            }
        }

        char[] ss = Arrays.copyOfRange(str2, c - len, c + len + 1);
        return String.valueOf(removeBoundaries(ss));
    }

    private char[] addBoundaries(char[] cs) {
        if ((cs == null) || (cs.length == 0)) {
            return "||".toCharArray();
        }

        char[] cs2 = new char[cs.length*2 + 1];
        for (int i = 0; i < (cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

    private char[] removeBoundaries(char[] cs) {
        if ((cs == null) || (cs.length < 3)) {
            return "".toCharArray();
        }

        char[] cs2 = new char[(cs.length - 1)/2];
        for (int i = 0; i < cs2.length; i++) {
            cs2[i] = cs[i*2 + 1];
        }
        return cs2;
    }
}
