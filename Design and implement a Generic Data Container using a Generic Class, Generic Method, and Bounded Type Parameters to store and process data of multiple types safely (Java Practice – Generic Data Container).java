import java.util.*;

class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

public class GenericDataContainer {

    // Generic Method
    public static <K, V> void display(K key, V value) {
        System.out.println(key + " = " + value);
    }

    // Bounded Type Parameter
    public static <T extends Number> void findMaximum(T num1, T num2) {
        if (num1.doubleValue() > num2.doubleValue())
            System.out.println("Maximum Number : " + num1);
        else
            System.out.println("Maximum Number : " + num2);
    }

    public static void main(String[] args) {

        // Generic Class
        Box<Integer> intBox = new Box<>(100);
        Box<String> strBox = new Box<>("Hello Generics");

        System.out.println("Integer Box Value : " + intBox.getValue());
        System.out.println("Type of stored item : " + intBox.getValue().getClass().getName());

        System.out.println("String Box Value : " + strBox.getValue());
        System.out.println("Type of stored item : " + strBox.getValue().getClass().getName());

        // Generic Method
        System.out.println("\n---- Key-Value Pairs ----");
        display("Rahul", 88);
        display(101, "CSE");

        // Bounded Type Parameter
        System.out.println();
        findMaximum(89, 75);

        String s1 = "Rahul";
        String s2 = "Sneha";

        System.out.println("Maximum (Alphabetical) : " +
                (s1.compareTo(s2) > 0 ? s1 : s2));

        System.out.println("Maximum Marks : " + Math.max(92.3, 89.5));
    }
}
