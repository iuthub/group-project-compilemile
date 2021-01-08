package ExtraClasses;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class UserRepository {
    private static UserRepository instance;

    private final String DATABASE_URL = "jdbc:derby:./db/dataBase";

    private final String GET_Librarian_QUERY = "SELECT * FROM users WHERE role='Librarian'";
    private final String GET_Student_QUERY = "SELECT * FROM users WHERE role='Student'";
    private final String ADD_QUERY = "INSERT Into users(password, firstName, lastName, userName, role) VALUES(?,?,?,?,?)";
    private final String DELETE_QUERY = "DELETE FROM users WHERE id=?";
    private final String GET_LAST_ID = "SELECT MAX(id) FROM users";
    private final String UPDATE_QUERY = "UPDATE users SET password=? ,firstName=?, lastName=?, userName=? WHERE id=?";

    private Connection connection;

    private PreparedStatement getLibrarianStmt;
    private PreparedStatement getStudentStmt;
    private PreparedStatement addStmt;
    private PreparedStatement deleteStmt;
    private PreparedStatement getLastIdStmt;
    private PreparedStatement updateStmt;

    UserRepository() throws SQLException {
        connection = DriverManager.getConnection(DATABASE_URL);

        this.getLibrarianStmt = this.connection.prepareStatement(GET_Librarian_QUERY);
        this.getStudentStmt = this.connection.prepareStatement(GET_Student_QUERY);
        this.addStmt = this.connection.prepareStatement(ADD_QUERY);
        this.deleteStmt = this.connection.prepareStatement(DELETE_QUERY);
        this.getLastIdStmt = this.connection.prepareStatement(GET_LAST_ID);
        this.updateStmt = connection.prepareStatement(UPDATE_QUERY);
    }
    public static UserRepository getInstance() throws SQLException {
        if (instance == null) {
            return new UserRepository();
        }
        return instance;
    }

    //    METHODS TO GET THE VALUES OF USERS
    public ObservableList<User> getAllLibrarians() throws SQLException {
        ResultSet result;

        ObservableList<User> listOfLibrarians = FXCollections.observableArrayList();

        result = getLibrarianStmt.executeQuery();

        while (result.next()) {
            listOfLibrarians.add(new User(
                    result.getString("id"),
                    result.getString("password"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("userName"),
                    result.getString("role")
            ));
        }

        return listOfLibrarians;
    }
    public ObservableList<User> getAllStudents() throws SQLException {
        ResultSet result;

        ObservableList<User> listOfStudents = FXCollections.observableArrayList();

        result = getStudentStmt.executeQuery();

        while (result.next()) {
            listOfStudents.add(new User(
                    result.getString("id"),
                    result.getString("password"),
                    result.getString("firstName"),
                    result.getString("lastName"),
                    result.getString("userName"),
                    result.getString("role")
            ));
        }

        return listOfStudents;
    }


}
