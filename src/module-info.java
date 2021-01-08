module group.project.compilemile {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;

    opens logIn;
    opens Admin;
    opens Librarian;
    opens Student;
    opens ExtraClasses;
}