// Box.java
public class Box<T> {
    private T element;

    // Constructor
    public Box(T element) {
        this.element = element;
    }

    // Getter
    public T getElement() {
        return element;
    }

    // Setter
    public void setElement(T element) {
        this.element = element;
    }

    // Print method
    public void printElement() {
        System.out.println("Element: " + element);
    }
}


// Main.java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Integer Box
        Box<Integer> intBox = new Box<>(10);
        intBox.printElement();

        // String Box
        Box<String> strBox = new Box<>("Hello World");
        strBox.printElement();

        // Double Box
        Box<Double> dblBox = new Box<>(15.75);
        dblBox.printElement();

        // Using ArrayList with autoboxing
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);  // autoboxed to Integer
        numbers.add(10); // autoboxed to Integer
        numbers.add(15); // autoboxed to Integer

        System.out.println("\nNumbers in ArrayList:");
        for (Integer num : numbers) {
            System.out.println(num);  // unboxing happens automatically if needed
        }
    }
}


