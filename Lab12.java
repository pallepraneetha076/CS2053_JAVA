// Student.java
public class Student {
    private String name;
    private int age;
    private String grade;

    public Student(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade;
    }
}

// StudentGUI.java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class StudentGUI extends Application {

    private ArrayList<Student> students = new ArrayList<>();
    private TextArea displayArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Student Record System");

        // Form Controls
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label gradeLabel = new Label("Grade:");
        TextField gradeField = new TextField();

        Button addButton = new Button("Add Student");
        displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(200);

        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(gradeLabel, 0, 2);
        grid.add(gradeField, 1, 2);
        grid.add(addButton, 1, 3);
        grid.add(displayArea, 0, 4, 2, 1);

        // Event Handling
        addButton.setOnAction(e -> {
            String name = nameField.getText().trim();
            String ageText = ageField.getText().trim();
            String grade = gradeField.getText().trim();

            if (name.isEmpty() || ageText.isEmpty() || grade.isEmpty()) {
                showAlert(Alert.AlertType.WARNING, "Please fill all fields!");
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Age must be a number!");
                return;
            }

            Student student = new Student(name, age, grade);
            students.add(student);
            updateDisplay();

            // Clear fields
            nameField.clear();
            ageField.clear();
            gradeField.clear();
        });

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    private void showAlert(Alert.AlertType type, String message) {
        Alert alert = new Alert(type);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
