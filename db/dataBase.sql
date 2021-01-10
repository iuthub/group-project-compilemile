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
    takenBy INT NOT NULL,
    title VARCHAR(20) NOT NULL,
    author VARCHAR(20) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    publishDate VARCHAR(20) NOT NULL
);

INSERT INTO users (password, firstName, lastName, userName, role)
VALUES
    ('7513061', 'Ulugbek', 'Yarkinov', 'Uuu', 'Admin'),
    ('8044321', 'Zufarbek', 'Zufarbekov', 'Zzz', 'Librarian'),
    ('1234567', 'Bois', 'Boiskhonov', 'Bbb', 'Student');

INSERT INTO books (takenBy, title, author, isbn, publishDate)
VALUES
    (1,'Academic English 3','Williams','500520', '12.01.2009'),
    (1,'OOP2','Deitel','100123', '03.12.2015'),
    (1,'Calculus','Markov','100123', '03.12.2015');