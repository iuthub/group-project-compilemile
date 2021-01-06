package logIn;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.io.IOException;
import java.sql.SQLException;


public class LogInController {
    @FXML
    public ComboBox<String> box;
    @FXML
    public TextField txtUsername;
    @FXML
    public PasswordField password;
//    @FXML
//    public PasswordField passwordConfirm;

    @FXML
    public void goToLibrarian(ActionEvent event) {
//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("/student/librarian.fxml"));
//            Stage stage = new Stage();
//            stage.setScene(new Scene(root, 650, 400));
//            stage.show();
//            ((Node)(event.getSource())).getScene().getWindow().hide();
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
    }

//    @FXML
//    public void btnSign() throws SQLException {
//        Role role = Role.valueOf(box.getValue());
//        String username = txtUsername.getText();
//        String passwordStr = password.getText();
//        String passwordConfirmStr = passwordConfirm.getText();
//
//        if (!passwordStr.equals(passwordConfirmStr)){
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Passwords not matching");
//            alert.setHeaderText("Ooops, there was an error!");
//            alert.setContentText("Passwords must be identical");
//
//            alert.showAndWait();
//        }
//
//        User user = new User(role, username, passwordStr);
//        Repository repo = Repository.getInstance();
//        repo.add(user);
//    }
}
