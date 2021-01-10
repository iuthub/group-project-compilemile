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
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {

    @FXML
    public TableView<Books> tblBooks;
    @FXML
    public TableView<Books> tblMyBooks;

    //      Labels For Book Details
    @FXML
    public Label lblBookId;
    @FXML
    public Label lblBookTitle;
    @FXML
    public Label lblBookAuthor;
    @FXML
    public Label lblBookISBN;
    @FXML
    public Label lblBookPubDate;
    @FXML
    public Label lblBookTakenBy;


    //      Labels For MyBook Details
    @FXML
    public Label lblMyBookId;
    @FXML
    public Label lblMyBookTitle;
    @FXML
    public Label lblMyBookAuthor;
    @FXML
    public Label lblMyBookISBN;
    @FXML
    public Label lblMyBookPubDate;
    @FXML
    public Label lblMyBookTakenBy;

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

    @FXML
    public void displayBookDetails(MouseEvent mouseEvent) {
        lblBookId.setText(tblBooks.getSelectionModel().getSelectedItem().getBookID());
        lblBookTitle.setText(tblBooks.getSelectionModel().getSelectedItem().getTitle());
        lblBookAuthor.setText(tblBooks.getSelectionModel().getSelectedItem().getAuthor());
        lblBookISBN.setText(tblBooks.getSelectionModel().getSelectedItem().getIsbn());
        lblBookPubDate.setText(tblBooks.getSelectionModel().getSelectedItem().getPublishDate());
        lblBookTakenBy.setText(tblBooks.getSelectionModel().getSelectedItem().getTakenBy());
    }

    @FXML
    public void displayMyBookDetails(MouseEvent mouseEvent) {
        lblMyBookId.setText(tblMyBooks.getSelectionModel().getSelectedItem().getBookID());
        lblMyBookTitle.setText(tblMyBooks.getSelectionModel().getSelectedItem().getTitle());
        lblMyBookAuthor.setText(tblMyBooks.getSelectionModel().getSelectedItem().getAuthor());
        lblMyBookISBN.setText(tblMyBooks.getSelectionModel().getSelectedItem().getIsbn());
        lblMyBookPubDate.setText(tblMyBooks.getSelectionModel().getSelectedItem().getPublishDate());
        lblMyBookTakenBy.setText(tblMyBooks.getSelectionModel().getSelectedItem().getTakenBy());
    }
}
