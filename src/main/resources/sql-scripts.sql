CREATE DATABASE IF NOT EXISTS `todo_db`;
USE `todo_db`;

DROP TABLE IF EXISTS `users`;

TRUNCATE `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARBINARY(45) DEFAULT NULL,
  `last_name` VARBINARY(45) DEFAULT NULL,
  `email` VARBINARY(45) DEFAULT NULL,
  `password` VARBINARY(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `password`) VALUES
  (1, 'petr', 'gulchuk', 'asdf', '111');

SELECT * FROM users;
