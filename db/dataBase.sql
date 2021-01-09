DROP TABLE users;
DROP TABLE books;

CREATE TABLE users(
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    password VARCHAR(20) NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    userName VARCHAR(20) NOT NULL,
    role VARCHAR(10) NOT NULL
);
CREATE TABLE books(
    bookID INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    state INT NOT NULL,
    title VARCHAR(20) NOT NULL,
    author VARCHAR(20) NOT NULL,
    isbn VARCHAR(20) NOT NULL
);

INSERT INTO users (password, firstName, lastName, userName, role)
VALUES
    ('7513061', 'Ulugbek', 'Yarkinov', 'Uuu', 'Admin'),
    ('8044321', 'Zufarbek', 'Zufarbekov', 'Zzz', 'Librarian'),
    ('1234567', 'Boiss', 'Boiskhonov', 'Bbb', 'Student');

INSERT INTO books (state, title, author, isbn)
VALUES
    (1,'Academic English 3','Unknown','500520'),
    (1,'OOP2','Unknown','100123');