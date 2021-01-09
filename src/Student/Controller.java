package Student;

import ExtraClasses.BookRepository;
import ExtraClasses.Books;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    @FXML
    public TableView tblBooks;


    private ObservableList<Books> bookList;

    public void initialize() {
        try {
            this.bookList = BookRepository.getInstance().getAllBooks();
            this.tblBooks.setItems(bookList);
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
