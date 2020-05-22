CREATE DATABASE IF NOT EXISTS db_board;
USE db_board;
DROP TABLE IF EXISTS board;

CREATE TABLE db_board.board
    (
    `bno`  INT NOT NULL,
    `title`  VARCHAR(50) NULL,
    `content` TEXT NOT NULL,
    `writer`  VARCHAR(45) NULL,
    `regDate` TIMESTAMP DEFAULT now(),
    `viewCnt` INT DEFAULT 0,
    PRIMARY KEY (`bno`)
);