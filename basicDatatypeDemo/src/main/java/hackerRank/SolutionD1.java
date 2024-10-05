package hackerRank;
import java.util.*;
import java.util.stream.*;
public class SolutionD1 {

    public static void main(String[] args) {
        // [-4, 3, -9, 0, 4, 1]
      List<Integer> testS2 = Arrays.asList(-4, 3, -9, 4, 1);
    System.out.println(findMedian(testS2));
        //plusMinus(testS2);
/*        List<Integer> testS1 = Arrays.asList(256741038,623958417,467905213,714532089,938071625);
        miniMaxSum(testS1);*/
        //System.out.println(timeConversion("12:45:54PM"));

    }
    public static void plusMinus(List<Integer> arr) {
        List<Integer> positives = arr.stream().filter(n -> n > 0).collect(Collectors.toList());
        List<Integer> negatives = arr.stream().filter(n -> n < 0).collect(Collectors.toList());
        List<Integer> zeros = arr.stream().filter(n -> n == 0).collect(Collectors.toList());
        Double positiveRatio= (double) positives.size()/arr.size();
        Double negativeRatio= (double) negatives.size()/arr.size();
        Double zeroRatio = (double) zeros.size()/arr.size();
        System.out.printf(" %.6f%n", positiveRatio);
        System.out.printf(" %.6f%n", negativeRatio);
        System.out.printf(" %.6f%n", zeroRatio);
    }

    public static void miniMaxSum(List<Integer> arr) {// fixlenth=5, only find 4
        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());

        long maxSum = sortedList.stream()
                .skip(1) // Skip the first element
                .mapToLong(Integer::longValue)
                .sum();
        Collections.reverse(sortedList); // stream no reversed method, but collections do have!!
        long minSum = sortedList.stream()
                .skip(1) // Skip the first element
                .mapToLong(Integer::longValue)
                .sum();
        System.out.println(minSum);
        System.out.println(maxSum);
    }


    //Given a time in -hour AM/PM format, convert it to military (24-hour) time.All input times are valid
    public static String timeConversion(String s) {
        int hours= Integer.parseInt(s.substring(0,2));
        String rest=s.substring(2, s.length()-2);
        if(s.contains("PM")){ // afternoon
            if(hours < 12) {
                int newHours = hours + 12;
                return newHours + rest;
            } else { //"13:40:22PM" possible?
                return s.substring(0,2) + rest;
            }
        }else if(s.contains("AM")){ //morning
            if(hours >= 12){
                int newHours = hours-12;
                return (newHours==0?"00":newHours) + rest;
            }else{
                return s.substring(0,2) + rest;
            }
        }else{
            //by default do nothing
        }
        return null;
    }

    //only consider middle position, no need to think duplicate value
    // input arr is odd size
    public static int findMedian(List<Integer> arr) {
        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());
        //sortedList.get(sortedList.size()/2);
        return sortedList.get(sortedList.size()/2);
    }
}
