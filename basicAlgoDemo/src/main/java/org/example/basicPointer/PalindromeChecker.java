package org.example.basicPointer;

public class PalindromeChecker {
    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal, Panama";
        String str2 = "Hello, World!";

        System.out.println(isPalindrome(str1)); // Output: true
        System.out.println(isPalindrome(str2)); // Output: false
    }

    //双指针相遇
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            while (left < right && !isAlphanumeric(str.charAt(left))) {
                left++;
            }
            while (left < right && !isAlphanumeric(str.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true; // If all checks pass, the string is a palindrome
    }

    private static boolean isAlphanumeric(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
