package com.task;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeUtilsTest {
    private static PalindromeUtils palindromeUtils;

    @BeforeClass
    public static void setUp() {
        palindromeUtils = new PalindromeUtils();
    }

    @Test
    public void isStringPalindromeForNullLineTest(){
        assertFalse(palindromeUtils.isStringPalindrome(null));
    }


    @Test
    public void isStringPalindromeForEmptyLineTest(){
        assertTrue(palindromeUtils.isStringPalindrome(""));
    }

    @Test
    public void isStringPalindromeForOneSymbolLineTest(){
        assertTrue(palindromeUtils.isStringPalindrome("1"));
    }

    @Test
    public void isStringPalindromeForPalindromeLineTest() {
        assertTrue(palindromeUtils.isStringPalindrome("1221"));
    }

    @Test
    public void isStringPalindromeForNonPalindromeLineTest() {
        assertFalse(palindromeUtils.isStringPalindrome("1121"));
    }

    @Test
    public void findLongestPalindromeForEmptyLineTest() throws Exception {
        assertEquals("", palindromeUtils.findLongestPalindrome(""));

    }

    @Test
    public void findLongestPalindromeForNonPalindromeLineTest() throws Exception {
        assertEquals("1", palindromeUtils.findLongestPalindrome("12345"));

    }

    @Test
    public void findLongestPalindromeTest() throws Exception {
        assertEquals("121", palindromeUtils.findLongestPalindrome("128121"));

    }

}