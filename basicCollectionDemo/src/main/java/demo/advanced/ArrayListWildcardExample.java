package demo.advanced;
import java.util.ArrayList;
import java.util.List;

public class ArrayListWildcardExample {

    public static <T> void copy(List<? extends T> source, List<? super T> destination) {
        for (T element : source) {
            destination.add(element);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> intSource = new ArrayList<>();
        intSource.add(1);
        intSource.add(2);
        ArrayList<Number> numberDestination = new ArrayList<>();
        copy(intSource, numberDestination);
        System.out.println(numberDestination);
    }
}
