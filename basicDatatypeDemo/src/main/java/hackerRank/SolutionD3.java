package hackerRank;

import java.util.Arrays;


public class SolutionD3 {

    public static void main(String[] args) {
        //int []a= new int[]{1,2,3,4,5,6,7};
        //findZigZagSequence(a, 7);
        //System.out.println(caesarCipher("STUVWXYZ",3));
        //System.out.println(caesarCipher("middle-Outz",2));
        System.out.println(palindromeIndex("prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp"));
        System.out.println(palindromeIndex("prcoitfiptvcxvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp"));
    }

    public static int palindromeIndex(String s) {
        String ss=new StringBuilder(s).reverse().toString();
        if(ss.equals(s)){
            return -1;
        }else{
            //consider remove which char to make it as palindrome,only 1 bit
            String newStr;
            for(int i=0; i<s.length(); i++){
                newStr = s.substring(0, i)+s.substring(i+1, s.length());
                ss = new StringBuilder(newStr).reverse().toString();
                if(ss.equals(newStr)){
                    return i;
                }
            }
        }
        return -1;
    }


    /*
     * forms have numeric values from 10 through 35.
     * This is independent of the Unicode specification, which does not assign numeric values to these char values.
     * */
    public static String caesarCipher(String s, int k) {
        int number=0;
        char[] chars= s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if(!Character.isAlphabetic(chars[i])){ }// do nothing
            else{
                if(Character.isUpperCase(chars[i])){
                    number = chars[i];
                    if((number + k%26) > 90){
                        number = number + k%26 - 26;
                        chars[i] = (char)number;
                    }else {
                        chars[i] = (char) (number + k % 26);
                    }
                }else{
                    number = chars[i];
                    if((number + k%26) > 122){
                        number = number + k%26 - 26 ;
                        chars[i] =(char)number;
                    } else {
                        chars[i] = (char) (number + k % 26);
                    }
                }

            }
        }
        return new String(chars);
    }

    /*
    * n towers of m height
    If m = 1: Player 2 wins.
    If m > 1 and n is odd: Player 1 wins.
    If m > 1 and n is even: Player 2 wins.
    * */
    public static int towerBreakers(int n, int m) {
        if(m == 1) {
            return 2;
        }else {
            if(n%2 ==0){
                return 1;
            } else{
                return 2;
            }
        }
    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2 -1;
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        int st = mid + 1;
        int ed = n - 2; //last position no need to change
        //reverse the second half
        while(st <= ed ){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }

        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
