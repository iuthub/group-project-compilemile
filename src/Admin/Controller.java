package Admin;

import ExtraClasses.User;
import ExtraClasses.UserRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    private ObservableList<User> librarianList;
    private ObservableList<User> studentList;

    @FXML
    public TableView tblLibrarians;
    @FXML
    public TableView tblStudents;

    //    Librarian's TextFields
    @FXML
    public TextField txtLibPassword;
    @FXML
    public TextField txtLibFirstName;
    @FXML
    public TextField txtLibLastName;
    @FXML
    public TextField txtLibUsername;


    //    Student's TextFields
    @FXML
    public TextField txtStudPassword;
    @FXML
    public TextField txtStudFirstName;
    @FXML
    public TextField txtStudLastName;
    @FXML
    public TextField txtStudUsername;



    public void initialize() {
        try {
            this.librarianList = UserRepository.getInstance().getAllLibrarians();
            this.tblLibrarians.setItems(librarianList);
            this.studentList = UserRepository.getInstance().getAllStudents();
            this.tblStudents.setItems(studentList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void handleLogOut(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/logIn/logIn.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 400, 350));
            stage.setTitle("Log In");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
