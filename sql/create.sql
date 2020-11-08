use books;

-- drop table Book;

create table Book(
id int,
Title varchar(45),
Author varchar(45),
PRIMARY KEY ( id )
);

INSERT INTO `books`.`Book`
(`id`,
`Title`,
`Author`
)
VALUES
(1,
"Clean Code",
"Robert Cecil Martin");

INSERT INTO `books`.`Book`
(`id`,
`Title`,
`Author`
)
VALUES
(2,
"Code Complete",
"Steve McConnell");

INSERT INTO `books`.`Book`
(`id`,
`Title`,
`Author`
)
VALUES
(3,
"Refactoring",
"Martin Fowler, Kent Beck");

-- drop table Customer;

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

-- drop table CustomerBook;

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