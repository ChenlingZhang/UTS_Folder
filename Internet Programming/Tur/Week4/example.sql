CREATE DATABASE uts;
use uts;
CREATE TABLE film (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    year int  NOT NULL,
    director varchar(255) NOT NULL
);


INSERT INTO film (name, year, director)
VALUES ('The 39 Steps', 1935, 'Alfred Hitchcock');
INSERT INTO film (name, year, director)
VALUES ('Stagecoach', 1939, 'John Ford');
INSERT INTO film (name, year, director)
VALUES ('Metropolis', 1927, 'Fritz Lang');
INSERT INTO film (name, year, director)
VALUES ('M', 1931, 'Fritz Lang');
INSERT INTO film (name, year, director)
VALUES ('A Night at the Opera', 1935, 'Sam Wood');
INSERT INTO film (name, year, director)
VALUES ('A Day at the Races', 1937, 'Sam Wood');
INSERT INTO film (name, year, director)
VALUES ('The Rock', 1996, 'Michael Bray');
INSERT INTO film (name, year, director)
VALUES ('Babel', 2005, 'Alejandro Inarritu');
INSERT INTO film (name, year, director)
VALUES ('On Golden Pond', 1981, 'Mark Rydell');
