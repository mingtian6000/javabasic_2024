package hackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class SolutionD2 {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList(1, 2, 3));
        listOfLists.add(Arrays.asList(4, 5, 6));
        listOfLists.add(Arrays.asList(7, 8, 9));
        // diagonalDifference(listOfLists);
        List<Integer> test = Arrays.asList(63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33);
        System.out.println(countingSort(test));
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        return 0;
    }


    //Given an array of integers, where all elements but one occur twice, find the unique element.
    public static int lonelyinteger1(List<Integer> a) {
        Map<Integer, Integer> records= new HashMap<>();

        for(int i=0; i<a.size(); i++){
            if(!records.containsKey(a.get(i))){
                records.put(a.get(i), new Integer(1));
            }else{
                int value = records.get((a.get(i))).intValue();
                value++;
                records.put(a.get(i), value);
            }
        }
        Map<Integer, Integer> result = records.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<Integer> element = result.keySet().stream().collect(Collectors.toList());
        return element.get(0);
    }

    //Given a square matrix, calculate the absolute difference between the sums of its diagonals.
    public static int diagonalDifference(List<List<Integer>> arr) {
        int rows = arr.size();
        int cols = arr.get(0).size(); // Assuming all inner lists are of the same size
        int sumLeft = 0, sumRight = 0;
        Integer[][] array2D = new Integer[rows][cols];
        for (int i = 0; i < rows; i++) {
            List<Integer> innerList = arr.get(i);
            for (int j = 0; j < cols; j++) {
                array2D[i][j] = innerList.get(j);
                if(i==j){
                    sumLeft += array2D[i][j];
                    System.out.println("left array["+i+"]["+j+"]");
                }
                if((i+j)==(rows-1)){
                    sumRight += array2D[i][j];
                    System.out.println("right array["+i+"]["+j+"]");
                }
            }
        }
        System.out.println(sumLeft+" "+sumRight);
        return Math.abs(sumLeft-sumRight);
    }

/*    countingSort has the following parameter(s):
    arr[n]: an array of integers
    Returns
    int[100]: a frequency array*/
    public static List<Integer> countingSort(List<Integer> arr) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for(int i=0; i<100; i++){
            resultMap.put(new Integer(i), 0);
        }
        for(Integer i: arr){
            int value = resultMap.get(i);
            value = value +1;
            resultMap.put(i, value);
        }
        List<Integer> values = resultMap.values().stream().collect(Collectors.toList());
        return values;
    }
}
