public class {
    public static void main(String args[]) {
        System.out.println("Total number of arguments: " + args.length);

        if (args.length == 4) {
            System.out.println("--- Provided Arguments ---");
            for (int i = 0; i < args.length; i++) {
                System.out.println("Argument " + i + ": " + args[i]);
            }

            // Assigning command-line arguments to employee details
            String empId = args[0];
            String name = args[1];
            String department = args[2];
            String email = args[3];

            System.out.println("\n--- Employee Details ---");
            System.out.println("Employee ID: " + empId);
            System.out.println("Employee Name: " + name);
            System.out.println("Department: " + department);
            System.out.println("Email ID: " + email);
        } else {
            System.out.println("Please provide exactly 4 arguments for employee details.");
        }
    }
}
