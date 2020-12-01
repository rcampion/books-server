use books;

drop table Book;

create table Book(
id int AUTO_INCREMENT PRIMARY KEY,
Title varchar(45),
Author varchar(45),
Category int
);

INSERT INTO `books`.`Book`
(`Title`,
`Author`,
`Category`
)
VALUES
(
"Clean Code",
"Robert Cecil Martin",
1);

INSERT INTO `books`.`Book`
(
`Title`,
`Author`,
`Category`
)
VALUES
(
"Code Complete",
"Steve McConnell",
2);

INSERT INTO `books`.`Book`
(
`Title`,
`Author`,
`Category`
)
VALUES
(
"Refactoring",
"Martin Fowler, Kent Beck",
1);
INSERT INTO `books`.`Book`
(
`Title`,
`Author`,
`Category`
)
VALUES
(
"Refactoring 2",
"Martin Fowler, Kent Beck",
1);

drop table Customer;

create table Customer(
id int,
Name varchar(45),
PRIMARY KEY ( id )
);

INSERT INTO `books`.`Customer`
(`id`,
`Name`)
VALUES
(1,
"Richard Campion");

INSERT INTO `books`.`Customer`
(`id`,
`Name`)
VALUES
(2,
"Paul Fredette");

drop table CustomerBook;

create table CustomerBook(
id int,
CustomerID char,
BookID int,
PRIMARY KEY ( id )
);

INSERT INTO `books`.`CustomerBook`
(`id`,
`CustomerID`,
`BookID`)
VALUES
(1,
1,
1);

INSERT INTO `books`.`CustomerBook`
(`id`,
`CustomerID`,
`BookID`)
VALUES
(2,
1,
2);

INSERT INTO `books`.`CustomerBook`
(`id`,
`CustomerID`,
`BookID`)
VALUES
(3,
2,
2);