package hackerRank;
import java.util.*;
import java.util.stream.Collectors;

public class SolutionD4 {
    public static void main(String[] args) {
/*        List<String> grid1= new ArrayList<>();
        grid1.add("abc");
        grid1.add("lmp");
        grid1.add("qrt");
        System.out.println(gridChallenge(grid1));*/

        // loop is timeout..
        //int result = superDigit("861568688536788",1000000);
        //System.out.println(result);
        int[] intArray = {1,2,5,3,7,8,6,4};

        List<Integer> integerList = Arrays.stream(intArray)
                .boxed() // Convert int to Integer
                .collect(Collectors.toList());
        //q.add(2);q.add(5); q.add(1); q.add(3); q.add(4);
        minimumBribes(integerList);
    }

    // initial state is ordered list,
    // 知道终止态，但不知道怎么到达终止态，求到达终止态路径
    public static void minimumBribes(List<Integer> q) {
        Integer[] arr = q.toArray(new Integer[0]);
        boolean flg=false;
        boolean swapped = false;
        int swapTimes=0;
        for(int i=0; i<arr.length; i++){
            int diff= Math.abs(arr[i]-(i+1));
            if(diff > 2 && arr[i]> (i+1)){
                System.out.println("Too chaotic");
                flg=true;
                break;
            }
        }
        if(!flg){
            // use bubble sort to reverse back
            int temp;
            for(int i=0; i< arr.length; i++){
                for(int j=i+1; j< arr.length; j++){
                    //swap condition
                    if(arr[i]>arr[j]){
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                        swapTimes++;
                        swapped=true;
                    }
                }
                if(!swapped){break;} // early exit, already sorted!!
            }
            System.out.println(swapTimes);
        }

    }


    // return yes or no
    public static String gridChallenge(List<String> grid) {
        int l = grid.size();
        int c=grid.get(0).length();
        char[][] arr = new char[l][c];
        char[][] arrNew = new char[c][l];
        int i=0;
        for(String s: grid){
            char[] cs= s.toCharArray();
            Arrays.sort(cs);
            arr[i]=cs;
            i++;
        }
        // 2nd time, reverse this matrix
        for(int m=0; m<c; m++){
            for(int n=0; n<l; n++) {
                arrNew[m][n]=arr[n][m];
            }
        }
        //seems no available API to check arr is sorted or not
        for(int m=0; m<c; m++){
            for(int n=0; n<l-1; n++) {
                if (arrNew[m][n]>arrNew[m][n+1]){
                    return "NO";
                }
            }
        }
        return "YES";
    }

    // k times of repeated n
    public static int superDigit(String n, int k) {
        String original=n;
        boolean flg=false;
        while(original.length()>1) {
            char[] cs = original.toCharArray();
            long sum = 0;
            for (int i = 0; i < cs.length; i++) {
                sum = sum + Integer.parseInt(cs[i]+"");
            }
            if(!flg){sum = sum*k; flg=true;} //only for 1st time
            original = sum + "";
        }
        if(original.length()==1){
            return Integer.parseInt(original);
        }
        //return calcSum(original);
        return -1;
    }
/*    private static int calcSum(String str){
        if(str.length()==1){
            return Integer.parseInt(str);
        }

            char[] cs = str.toCharArray();
            long sum=0;
            for(int i=0;i< cs.length;i++){
                sum = sum + Integer.parseInt(cs[i]+"");
            }
            return calcSum(sum+"");
    }*/
}
