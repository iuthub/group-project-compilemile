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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class Controller {
    private ObservableList<User> librarianList;
    private ObservableList<User> studentList;

    @FXML
    public TableView<User> tblLibrarians;
    @FXML
    public TableView<User> tblStudents;

    //Labels For Displaying Librarian Details
    @FXML
    public Label lblFirstName;
    @FXML
    public Label lblLastName;
    @FXML
    public Label lblUsername;
    @FXML
    public Label lblPassword;
    @FXML
    public Label lblRole;
    @FXML
    public Label lblId;

    //Labels For Displaying Student Details
    @FXML
    public Label lblStudentId;
    @FXML
    public Label lblStudentFirstName;
    @FXML
    public Label lblStudentLastName;
    @FXML
    public Label lblStudentUsername;
    @FXML
    public Label lblStudentPassword;
    @FXML
    public Label lblStudentRole;

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

    private final String DATA_BASE="jdbc:derby:./db/dataBase";
    private final String sql = "SELECT * FROM users WHERE userName=? AND password=?";

    @FXML
    public void addLib() {
        User user = new User(
                "",
                txtLibPassword.getText(),
                txtLibFirstName.getText(),
                txtLibLastName.getText(),
                txtLibUsername.getText(),
                ""
        );

        try {
            Connection connection = DriverManager.getConnection(DATA_BASE);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText("Existing data:");
                alert.setContentText("This user is already in the system!\nPlease,create another one :)");

                alert.showAndWait();
            } else {
                user.setId(UserRepository.getInstance().addLibrarian(user));
                this.librarianList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void addStud() {
        User user = new User(
                "",
                txtStudPassword.getText(),
                txtStudFirstName.getText(),
                txtStudLastName.getText(),
                txtStudUsername.getText(),
                ""
        );

        try {
            Connection connection = DriverManager.getConnection(DATA_BASE);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText("Existing data:");
                alert.setContentText("This user is already in the system!\nPlease,create another one:)");

                alert.showAndWait();
            } else {
                user.setId(UserRepository.getInstance().addStudent(user));
                this.studentList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @FXML
    public void deleteLibrarian() {
        try {
            User user = (User) tblLibrarians.getSelectionModel().getSelectedItem();
            UserRepository.getInstance().deleteUser(user.getId());
            this.librarianList.remove(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    public void deleteStudent() {
        try {
            User user = (User) tblStudents.getSelectionModel().getSelectedItem();
            UserRepository.getInstance().deleteUser(user.getId());
            this.studentList.remove(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    public void updateLibrarian() {
        String userName = txtLibUsername.getText();
        String password = txtLibPassword.getText();
        try {
            Connection connection = DriverManager.getConnection(DATA_BASE);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText("Existing data:");
                alert.setContentText("This user is already in the system!\nPlease,create another one:)");

                alert.showAndWait();
            } else {
                try {
                    User user = (User) tblLibrarians.getSelectionModel().getSelectedItem();
                    user.setId(user.getId());
                    user.setPassword(txtLibPassword.getText());
                    user.setFirstName(txtLibFirstName.getText());
                    user.setLastName(txtLibLastName.getText());
                    user.setUserName(txtLibUsername.getText());
                    user.setRole(user.getRole());

                    UserRepository.getInstance().update(user);
                    this.librarianList.set(librarianList.indexOf(user),user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @FXML
    public void updateStudent() {
        String userName = txtStudUsername.getText();
        String password = txtStudPassword.getText();
        try {
            Connection connection = DriverManager.getConnection(DATA_BASE);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Alert");
                alert.setHeaderText("Existing data:");
                alert.setContentText("This user is already in the system!\nPlease,create another one:)");

                alert.showAndWait();
            } else {
                try {
                    User user = (User) tblStudents.getSelectionModel().getSelectedItem();
                    user.setId(user.getId());
                    user.setPassword(txtStudPassword.getText());
                    user.setFirstName(txtStudFirstName.getText());
                    user.setLastName(txtStudLastName.getText());
                    user.setUserName(txtStudUsername.getText());
                    user.setRole(user.getRole());

                    UserRepository.getInstance().update(user);
                    this.studentList.set(studentList.indexOf(user),user);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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

    // Method for displaying librarian's details
    @FXML
    public void displayLibrarianDetails(MouseEvent mouseEvent) {
        lblId.setText(tblLibrarians.getSelectionModel().getSelectedItem().getId());
        lblFirstName.setText(tblLibrarians.getSelectionModel().getSelectedItem().getFirstName());
        lblLastName.setText(tblLibrarians.getSelectionModel().getSelectedItem().getLastName());
        lblUsername.setText(tblLibrarians.getSelectionModel().getSelectedItem().getUserName());
        lblPassword.setText(tblLibrarians.getSelectionModel().getSelectedItem().getPassword());
        lblRole.setText(tblLibrarians.getSelectionModel().getSelectedItem().getRole());
    }

    // Method for displaying student's details
    @FXML
    public void displayStudentDetails(MouseEvent mouseEvent) {
        lblStudentId.setText(tblStudents.getSelectionModel().getSelectedItem().getId());
        lblStudentFirstName.setText(tblStudents.getSelectionModel().getSelectedItem().getFirstName());
        lblStudentLastName.setText(tblStudents.getSelectionModel().getSelectedItem().getLastName());
        lblStudentUsername.setText(tblStudents.getSelectionModel().getSelectedItem().getUserName());
        lblStudentPassword.setText(tblStudents.getSelectionModel().getSelectedItem().getPassword());
        lblStudentRole.setText(tblStudents.getSelectionModel().getSelectedItem().getRole());
    }
}
