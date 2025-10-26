class Book {
    String title;
    String author;
    double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println();
    }
}

public class Lab1 {
    public static void main(String args[]) {
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 279.99);
        Book b2 = new Book("1984", "George Orwell", 199.99);

        b1.display();
        System.out.println("------");
        b2.display();
    }
}
