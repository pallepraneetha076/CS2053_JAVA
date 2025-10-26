class Printer {
    // Synchronized method ensures only one thread can print at a time
    public synchronized void printDocument(String documentName, int copies) {
        System.out.println(Thread.currentThread().getName() + " started printing: " + documentName);
        for (int i = 1; i <= copies; i++) {
            System.out.println(Thread.currentThread().getName() + " printing copy " + i);
            try {
                Thread.sleep(500); // simulate time taken to print
            } catch (InterruptedException e) {
                System.out.println("Printing interrupted");
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished printing: " + documentName + "\n");
    }
}

class User extends Thread {
    private Printer printer;
    private String documentName;
    private int copies;

    public User(Printer printer, String documentName, int copies, String threadName) {
        super(threadName);
        this.printer = printer;
        this.documentName = documentName;
        this.copies = copies;
    }

    @Override
    public void run() {
        printer.printDocument(documentName, copies);
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Printer sharedPrinter = new Printer();

        User user1 = new User(sharedPrinter, "Report.pdf", 3, "User1");
        User user2 = new User(sharedPrinter, "Invoice.docx", 2, "User2");
        User user3 = new User(sharedPrinter, "Presentation.pptx", 4, "User3");

        user1.start();
        user2.start();
        user3.start();
    }
}
