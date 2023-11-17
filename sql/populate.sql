USE books;

INSERT INTO `books`.`BOOK`
(
`author`,
`author_id`,
`book_id`,
`category`,
`image`,
`isbn13`,
`language_id`,
`num_pages`,
`price`,
`publication_date`,
`publisher_id`,
`qty`,
`title`
)
VALUES
(
"Robert Cecil Martin",
1,
1,
1,
"assets/cms/static/img/books/Clean_Code.jpg",
"9780132350884",
1,
464,
11.11,
"2008-08-01",
1,
10,
"Clean Code: A Handbook of Agile Software Craftsmanship"
);

INSERT INTO `books`.`BOOK`
(
`author`,
`authorId`,
`bookId`,
`category`,
`image`,
`isbn13`,
`languageId`,
`numPages`,
`price`,
`publicationDate`,
`publisherId`,
`qty`,
`title`
)
VALUES
(
"Code Complete",
"Steve McConnell",
2,
11.11,
11);

INSERT INTO `books`.`BOOK`
(`title`,
`author`,
`category`,
`price`,
`qty`
)
VALUES
(
"Refactoring",
"Martin Fowler, Kent Beck",
1,
11.11,
11);

INSERT INTO `books`.`BOOK`
(
`author`,
`authorId`,
`bookId`,
`category`,
`image`,
`isbn13`,
`languageId`,
`numPages`,
`price`,
`publicationDate`,
`publisherId`,
`qty`,
`title`
)
VALUES
(
"Refactoring 2",
"Martin Fowler, Kent Beck",
1,
11.11,
11);

drop table Customer;
drop table CUSTOMER;

create table CUSTOMER(
id int,
contactId int,
name varchar(45),
PRIMARY KEY ( id )
);

INSERT INTO `books`.`CUSTOMER`
(`id`,
`name`)
VALUES
(1,
"Richard Campion");

INSERT INTO `books`.`CUSTOMER`
(`id`,
`Name`)
VALUES
(2,
"Paul Fredette");

drop table CustomerBook;
drop table CUSTOMER_BOOK;

create table CUSTOMER_BOOK(
id int,
customerId char,
bookId int,
PRIMARY KEY ( id )
);

INSERT INTO `books`.`CUSTOMER_BOOK`
(`id`,
`customerId`,
`bookId`)
VALUES
(1,
1,
1);

INSERT INTO `books`.`CUSTOMER_BOOK`
(`id`,
`customerId`,
`bookId`)
VALUES
(2,
1,
2);

INSERT INTO `books`.`CUSTOMER_BOOK`
(`id`,
`customerId`,
`bookId`)
VALUES
(3,
2,
2);