CREATE TABLE Owners
    (
    owner_id int,
    name int,
    PRIMARY KEY (owner_id)
    );

CREATE TABLE Dogs
    (
    id int,
    name varchar(50),
    age int,
    owner_id int,
    FOREIGN KEY (owner_id) REFERENCES Owners(owner_id)
    );